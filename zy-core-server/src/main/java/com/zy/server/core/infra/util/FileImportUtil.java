package com.zy.server.core.infra.util;

/**
 * fileName: FileImportUtil
 * create: 2021-5-27 21:50
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class FileImportUtil {
    public static final String PERIOD = "\\.";
    
    /**
     * 获取文件后缀，通过 "." 进行分割
     *
     * @param fileName 文件名
     * @return {null:fileName==null||文件名不包含 ".", suffix: other}
     */
    public static String getFileSuffixByPeriod(String fileName) {
        if (fileName != null) {
            String[] splits = fileName.split(PERIOD);
            if (splits.length <= 1) {
                return null;
            }
            return splits[splits.length - 1];
        }
        return null;
    }
}
