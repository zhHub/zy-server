package com.zy.server.core.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.server.core.domain.entity.email.EmailServerConfig;
import org.apache.ibatis.annotations.Param;

/**
 * fileName: EmailServerConfigMapper
 * create: 2021-5-29 14:25
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public interface EmailServerConfigMapper extends BaseMapper<EmailServerConfig> {
    /**
     * 通过 id 查询 email 服务主机连接配置
     *
     * @param id 配置 ID
     * @return 连接配置
     */
    EmailServerConfig getEmailServerConfigById(@Param("id") Long id);
}
