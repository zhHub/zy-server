package com.zy.server.core.infra.excel;

import org.apache.poi.ss.usermodel.Row;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName: RowWriter
 * create: 2021-5-27 22:42
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class RowWriter {
    
    private final Row row;
    
    private final Map<Integer, CellWriter> cellWriterMap;
    
    public RowWriter(Row row) {
        this.row = row;
        this.cellWriterMap = new HashMap<>();
    }
    
    public Row getRow() {
        return row;
    }
    
    public CellWriter writeCell(int cellIndex) {
        if (cellWriterMap.containsKey(cellIndex)) {
            return cellWriterMap.get(cellIndex);
        } else {
            CellWriter cellWriter = new CellWriter(row.createCell(cellIndex));
            cellWriterMap.put(cellIndex, cellWriter);
            return cellWriter;
        }
    }
}
