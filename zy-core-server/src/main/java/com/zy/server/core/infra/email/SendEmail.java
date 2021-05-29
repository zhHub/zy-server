package com.zy.server.core.infra.email;

import com.zy.server.core.domain.entity.email.EmailServerConfig;
import com.zy.server.core.domain.entity.email.Sender;
import com.zy.server.core.domain.repository.EmailServerConfigRepository;
import com.zy.server.core.infra.constant.EmailConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * fileName: SendEmail
 * create: 2021-5-29 16:43
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Component
public class SendEmail {
    /**
     * 日志打印
     */
    private static final Logger LOG = LoggerFactory.getLogger(SendEmail.class);
    
    @Value("${spring.mail.username}")
    private String username;
    
    private final JavaMailSender javaMailSender;
    private final EmailServerConfigRepository emailServerConfigRepository;
    
    
    @Autowired
    public SendEmail(JavaMailSender javaMailSender, EmailServerConfigRepository emailServerConfigRepository) {
        this.javaMailSender = javaMailSender;
        this.emailServerConfigRepository = emailServerConfigRepository;
    }
    
    
    /**
     * 根据发件人配置邮件发送客户端
     *
     * @param sender 发件人（可以为 null）
     * @return 邮件发送客户端
     */
    private synchronized JavaMailSender configurationJavaMailSenderImpl(Sender sender) {
        if (sender == null
                || StringUtils.compareIgnoreCase(sender.getUsername(), username) == 0
                || StringUtils.compareIgnoreCase(sender.getUserEmail(), username) == 0) {
            // 未传入发件人 or 发件人用户名与系统默认一致 or 发件人邮箱与系统默认一致 则返回默认
            return javaMailSender;
        }
        // 根据用户信息查询配置信息
        EmailServerConfig config = emailServerConfigRepository.getEmailServerConfigById(sender.getEmailServiceId());
        JavaMailSenderImpl javaMailSenderImpl = (JavaMailSenderImpl) javaMailSender;
        if (config == null) {
            // 不存在配置，使用默认163邮箱配置
            javaMailSenderImpl.setProtocol(EmailConstants.Email163.PROTOCOL);
            javaMailSenderImpl.setHost(EmailConstants.Email163.HOST);
            javaMailSenderImpl.setPort(EmailConstants.Email163.PORT);
            javaMailSenderImpl.setDefaultEncoding(EmailConstants.Email163.DEFAULT_ENCODING);
        } else {
            // 根据用户的配置设置新邮箱
            javaMailSenderImpl.setProtocol(config.getEmailServiceProtocol());
            javaMailSenderImpl.setHost(config.getEmailServiceHost());
            javaMailSenderImpl.setPort(config.getEmailServicePort());
            javaMailSenderImpl.setDefaultEncoding(config.getEmailServiceDefaultEncoding());
        }
        // 设置邮箱认证信息
        javaMailSenderImpl.setUsername(sender.getUsername());
        javaMailSenderImpl.setPassword(sender.getPassword());
        // 返回当前用户实现
        return javaMailSenderImpl;
    }
    
    /**
     * 发送邮件
     *
     * @param sender            发件人
     * @param simpleMailMessage 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, SimpleMailMessage simpleMailMessage) {
        try {
            configurationJavaMailSenderImpl(sender).send(simpleMailMessage);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件
     *
     * @param sender             发件人
     * @param simpleMailMessages 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, SimpleMailMessage... simpleMailMessages) {
        try {
            configurationJavaMailSenderImpl(sender).send(simpleMailMessages);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件
     *
     * @param sender      发件人
     * @param mimeMessage 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, MimeMessage mimeMessage) {
        try {
            configurationJavaMailSenderImpl(sender).send(mimeMessage);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件
     *
     * @param sender       发件人
     * @param mimeMessages 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, MimeMessage... mimeMessages) {
        try {
            configurationJavaMailSenderImpl(sender).send(mimeMessages);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件
     *
     * @param sender                发件人
     * @param mimeMessagePreparator 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, MimeMessagePreparator mimeMessagePreparator) {
        try {
            configurationJavaMailSenderImpl(sender).send(mimeMessagePreparator);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件
     *
     * @param sender                 发件人
     * @param mimeMessagePreparators 邮件内容
     * @return 发送结果
     */
    public boolean sendEmail(Sender sender, MimeMessagePreparator... mimeMessagePreparators) {
        try {
            configurationJavaMailSenderImpl(sender).send(mimeMessagePreparators);
            LOG.info(EmailConstants.SUCCESS_MESSAGE);
        } catch (MailException e) {
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
        return true;
    }
}
