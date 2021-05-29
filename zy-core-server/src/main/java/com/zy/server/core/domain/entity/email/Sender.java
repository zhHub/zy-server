package com.zy.server.core.domain.entity.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * fileName: Sender
 * create: 2021-5-29 16:46
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "发件人")
public class Sender {
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    
    @ApiModelProperty(value = "用户名")
    private String username;
    
    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;
    
    @ApiModelProperty(value = "密码")
    private String password;
    
    @ApiModelProperty(value = "用户邮箱配置 ID")
    private Long emailServiceId;
}
