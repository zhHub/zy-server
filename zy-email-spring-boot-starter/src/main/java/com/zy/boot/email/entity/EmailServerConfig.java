package com.zy.boot.email.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * fileName: EmailServerConfig
 * create: 2021-5-29 14:16
 * description: email服务主机连接配置
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailServerConfig {
    
    /**
     * 配置 ID
     */
    private Long id;
    
    /**
     * 配置名称
     */
    private String emailServiceName;
    
    /**
     * 服务主机地址
     */
    private String emailServiceHost;
    
    /**
     * 服务端口
     */
    private Integer emailServicePort;
    
    /**
     * 服务协议
     */
    private String emailServiceProtocol;
    
    /**
     * 默认编码
     */
    private String emailServiceDefaultEncoding;
}
