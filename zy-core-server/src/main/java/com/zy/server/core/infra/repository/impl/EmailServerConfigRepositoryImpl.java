package com.zy.server.core.infra.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.server.core.domain.entity.email.EmailServerConfig;
import com.zy.server.core.domain.repository.EmailServerConfigRepository;
import com.zy.server.core.infra.mapper.EmailServerConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * fileName: EmailServerConfigRepositoryImpl
 * create: 2021-5-29 14:23
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Repository
public class EmailServerConfigRepositoryImpl extends ServiceImpl<EmailServerConfigMapper, EmailServerConfig>
        implements EmailServerConfigRepository {
    
    private final EmailServerConfigMapper emailServerConfigMapper;
    
    @Autowired
    public EmailServerConfigRepositoryImpl(EmailServerConfigMapper emailServerConfigMapper) {
        this.emailServerConfigMapper = emailServerConfigMapper;
    }
    
    /**
     * 通过 id 查询 email 服务主机连接配置
     *
     * @param id 配置 ID
     * @return 连接配置
     */
    @Override
    public EmailServerConfig getEmailServerConfigById(Long id) {
        return emailServerConfigMapper.getEmailServerConfigById(id);
    }
}
