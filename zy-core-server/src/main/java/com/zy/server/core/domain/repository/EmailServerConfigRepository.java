package com.zy.server.core.domain.repository;

import com.zy.server.core.domain.entity.email.EmailServerConfig;

/**
 * fileName: EmailServerConfigRepository
 * create: 2021-5-29 14:23
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public interface EmailServerConfigRepository {
    /**
     * 通过 id 查询 email 服务主机连接配置
     *
     * @param id 配置 ID
     * @return 连接配置
     */
    EmailServerConfig getEmailServerConfigById(Long id);
}
