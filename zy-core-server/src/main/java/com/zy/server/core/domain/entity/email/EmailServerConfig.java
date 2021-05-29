package com.zy.server.core.domain.entity.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "email服务主机连接配置")
public class EmailServerConfig {
    
    @ApiModelProperty(value = "配置 ID")
    private Long id;
    
    @ApiModelProperty(value = "配置名称")
    private String emailServiceName;
    
    @ApiModelProperty(value = "服务主机地址")
    private String emailServiceHost;
    
    @ApiModelProperty(value = "服务端口")
    private Integer emailServicePort;
    
    @ApiModelProperty(value = "服务协议")
    private String emailServiceProtocol;
    
    @ApiModelProperty(value = "默认编码")
    private String emailServiceDefaultEncoding;
}
