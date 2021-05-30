package com.zy.server.core.domain.repository;

import com.zy.server.core.domain.entity.email.Email;

/**
 * fileName: EmailRepository
 * create: 2021-5-29 21:41
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public interface EmailRepository {
    /**
     * 发送邮件
     *
     * @param email 发送邮件信息
     * @return 发送结果
     */
    boolean sendSimpleEmail(Email email);
    
    /**
     * 发送邮件
     *
     * @param email 发送邮件信息
     * @return 发送结果
     */
    boolean sendMimeMessageEmail(Email email);
}
