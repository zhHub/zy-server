package com.zy.server.core.domain.repository;

import java.util.HashMap;

/**
 * fileName: EmailTemplateRepository
 * create: 2021-5-30 3:05
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public interface EmailTemplateRepository {
    /**
     * 组装模板邮件内容
     *
     * @param templateCode 模板 code
     * @param templateMap  模板替换内容
     * @return 模板邮件内容
     */
    String assemblyTemplateText(String templateCode, HashMap<String, String> templateMap);
}
