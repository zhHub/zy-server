package com.zy.server.core.infra.enums;

/**
 * fileName: ExcelVersion
 * create: 2021-5-27 22:38
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public enum ExcelVersion {
    /**
     * 2003
     */
    EXCEL_2003("xls", 65536),
    /**
     * 2007
     */
    EXCEL_2007("xlsx", 1048575);
    private final String suffix;
    private final int maxRowIndex;
    
    ExcelVersion(String suffix, int maxRowIndex) {
        this.suffix = suffix;
        this.maxRowIndex = maxRowIndex;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public int getMaxRowIndex() {
        return maxRowIndex;
    }
}
