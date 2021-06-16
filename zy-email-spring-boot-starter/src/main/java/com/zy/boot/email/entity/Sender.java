package com.zy.boot.email.entity;

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
public class Sender {
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 用户邮箱
     */
    private String userEmail;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 用户邮箱配置
     */
    private EmailServerConfig emailServerConfig;
}
