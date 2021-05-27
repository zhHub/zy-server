package com.zy.server.core.infra.excel;

import org.apache.poi.ss.usermodel.Cell;

/**
 * fileName: CellWriter
 * create: 2021-5-27 22:42
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class CellWriter {
    /**
     * 单元格
     */
    private final Cell cell;
    
    public CellWriter(Cell cell) {
        this.cell = cell;
    }
    
    /**
     * 获取单元格
     *
     * @return 单元格
     */
    public Cell getCell() {
        return cell;
    }
}
