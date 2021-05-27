package com.zy.server.core.infra.excel;

import com.zy.server.core.infra.enums.ExcelVersion;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * fileName: ExcelExample
 * create: 2021-5-27 23:12
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class ExcelExample {
    
    public void Excel() throws FileNotFoundException {
        ExcelWriter excelWriter = ExcelWriter.createExcel(ExcelVersion.EXCEL_2007,
                ExcelVersion.EXCEL_2007.getMaxRowIndex());
        SheetWriter test = excelWriter.writeSheet(0, "tesfffffffffffffffffffffffffffffffffffffffffft");
        RowWriter rowWriter = test.writeRow(0);
        CellWriter cellWriter = rowWriter.writeCell(0);
        cellWriter.getCell().setCellValue("tes啦啦啦啦啦了绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿t");
        File file = new File("D:/测试.xlsx");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            excelWriter.export(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new ExcelExample().Excel();
    }
}
