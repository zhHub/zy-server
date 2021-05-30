package com.zy.server.core.infra.repository.impl;

import com.zy.server.core.domain.repository.EmailTemplateRepository;
import com.zy.server.core.infra.mapper.EmailTemplateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * fileName: EmailTemplateRepositoryImpl
 * create: 2021-5-30 3:05
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Repository
public class EmailTemplateRepositoryImpl implements EmailTemplateRepository {
    
    private static final Logger LOG = LoggerFactory.getLogger(EmailTemplateRepositoryImpl.class);
    
    private final EmailTemplateMapper emailTemplateMapper;
    
    @Autowired
    public EmailTemplateRepositoryImpl(EmailTemplateMapper emailTemplateMapper) {
        this.emailTemplateMapper = emailTemplateMapper;
    }
    
    /**
     * 组装模板邮件内容
     *
     * @param templateCode 模板 code
     * @param templateMap  模板替换内容
     * @return 模板邮件内容
     */
    @Override
    public String assemblyTemplateText(String templateCode, HashMap<String, String> templateMap) {
        // TODO: [张建元 18143774515@163.com 2021-5-30 17:03] 邮件模板部分
        return null;
    }
}
