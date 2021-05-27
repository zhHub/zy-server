package com.zy.server.core.infra.excel;

import com.zy.server.core.infra.common.exception.BaseException;
import com.zy.server.core.infra.enums.ExcelVersion;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * fileName: ExcelWriter
 * create: 2021-5-27 22:28
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class ExcelWriter {
    
    private static final Logger LOG = LoggerFactory.getLogger(ExcelWriter.class);
    private static final String DEFAULT_SHEET_NAME = "Sheet %d";
    private Workbook workbook;
    private final List<SheetWriter> sheetWriterList;
    private final ExcelVersion excelVersion;
    
    private ExcelWriter(ExcelVersion excelVersion, int rowAccessWindowSize) {
        switch (excelVersion) {
            case EXCEL_2003:
                workbook = new HSSFWorkbook();
                break;
            case EXCEL_2007:
                workbook = new SXSSFWorkbook(rowAccessWindowSize);
                break;
            default:
                throw new BaseException("Unknown excel version");
        }
        this.excelVersion = excelVersion;
        sheetWriterList = new LinkedList<>();
    }
    
    public static ExcelWriter createExcel(ExcelVersion excelVersion, int rowAccessWindowSize) {
        return new ExcelWriter(excelVersion, rowAccessWindowSize);
    }
    
    public SheetWriter writeSheet(int sheetIndex, String sheetName) {
        int currentSize = sheetWriterList.size();
        if (sheetIndex < currentSize) {
            SheetWriter sheetWriter = sheetWriterList.get(sheetIndex);
            if (sheetWriter.isTemp()) {
                workbook.setSheetName(sheetIndex, sheetName);
                sheetWriter = sheetWriter.resetSheet(workbook.getSheetAt(sheetIndex));
            }
            return sheetWriter;
        } else {
            for (int i = currentSize; i <= sheetIndex; ++i) {
                if (i < sheetIndex) {
                    sheetWriterList.add(new SheetWriter(true, workbook.createSheet(String.format(DEFAULT_SHEET_NAME, i)), excelVersion));
                } else {
                    sheetWriterList.add(new SheetWriter(false, workbook.createSheet(sheetName), excelVersion));
                }
            }
            return sheetWriterList.get(sheetIndex);
        }
    }
    
    public void export(String filename, HttpServletResponse response) {
        try {
            String encodeFilename = encodeFileName(filename);
            response.setHeader("Content-disposition", "attachment; filename=" + encodeFilename + "." + excelVersion.getSuffix());
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Pragma", "no-cache");
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                workbook.close();
                workbook = null;
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }
    
    public void export(OutputStream outputStream) {
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                workbook.close();
                workbook = null;
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }
    
    private String encodeFileName(String filename) throws IOException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return URLEncoder.encode(filename, "UTF-8");
        } else {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            return encodeFileName(request, filename);
        }
    }
    
    private String encodeFileName(HttpServletRequest request, String filename) throws IOException {
        filename = filename.replace("\n", "");
        filename = filename.replace("\r", "");
        if (request == null) {
            return URLEncoder.encode(filename, "UTF-8");
        } else {
            String userAgent = request.getHeader("User-Agent");
            String encodeFilename;
            if (StringUtils.isBlank(userAgent)) {
                encodeFilename = URLEncoder.encode(filename, "UTF-8");
            } else if (!userAgent.contains("MSIE") && !userAgent.contains("like Gecko")) {
                encodeFilename = "=?UTF-8?B?" + Base64.getEncoder().encodeToString(filename.getBytes(StandardCharsets.UTF_8)) + "?=";
            } else {
                encodeFilename = URLEncoder.encode(filename, "UTF-8");
            }
            
            return encodeFilename;
        }
    }
    
}
