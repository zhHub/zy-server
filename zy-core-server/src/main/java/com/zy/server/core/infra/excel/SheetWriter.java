package com.zy.server.core.infra.excel;

import com.zy.server.core.infra.enums.ExcelVersion;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName: SheetWriter
 * create: 2021-5-27 22:41
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Getter
public class SheetWriter {
    private boolean temp;
    private SXSSFSheet sheet;
    private final ExcelVersion excelVersion;
    private final Map<Integer, RowWriter> rowWriterMap;
    
    public SheetWriter(boolean temp, Sheet sheet, ExcelVersion excelVersion) {
        this.temp = temp;
        this.sheet = (SXSSFSheet) sheet;
        this.excelVersion = excelVersion;
        rowWriterMap = new HashMap<>();
    }
    
    public SheetWriter resetSheet(Sheet sheet) {
        this.sheet = (SXSSFSheet) sheet;
        this.temp = false;
        return this;
    }
    
    public SXSSFSheet getSheet() {
        return sheet;
    }
    
    public RowWriter writeRow(int rowIndex) {
        if (rowWriterMap.containsKey(rowIndex)) {
            return rowWriterMap.get(rowIndex);
        } else {
            RowWriter rowWriter = new RowWriter(sheet.createRow(rowIndex));
            rowWriterMap.put(rowIndex, rowWriter);
            return rowWriter;
        }
    }
}
