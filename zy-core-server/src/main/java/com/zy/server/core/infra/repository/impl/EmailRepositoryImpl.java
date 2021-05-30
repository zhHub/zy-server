package com.zy.server.core.infra.repository.impl;

import com.zy.server.core.domain.entity.email.Email;
import com.zy.server.core.domain.entity.email.Sender;
import com.zy.server.core.domain.repository.EmailRepository;
import com.zy.server.core.domain.repository.EmailTemplateRepository;
import com.zy.server.core.domain.repository.SenderRepository;
import com.zy.server.core.infra.constant.EmailConstants;
import com.zy.server.core.infra.email.SendEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * fileName: EmailRepositoryImpl
 * create: 2021-5-29 21:41
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Repository
public class EmailRepositoryImpl implements EmailRepository {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(EmailRepositoryImpl.class);
    /**
     * bean
     */
    private final JavaMailSender javaMailSender;
    private final SendEmail sendEmail;
    private final SenderRepository senderRepository;
    private final EmailTemplateRepository emailTemplateRepository;
    
    @Autowired
    public EmailRepositoryImpl(JavaMailSender javaMailSender,
                               SendEmail sendEmail,
                               SenderRepository senderRepository,
                               EmailTemplateRepository emailTemplateRepository) {
        this.javaMailSender = javaMailSender;
        this.sendEmail = sendEmail;
        this.senderRepository = senderRepository;
        this.emailTemplateRepository = emailTemplateRepository;
    }
    
    /**
     * 发送邮件
     *
     * @param email 发送邮件信息
     * @return 发送结果
     */
    @Override
    public boolean sendSimpleEmail(Email email) {
        // 获取发件人信息
        Sender sender = senderRepository.getSenderByFrom(email.getFrom());
        // 构造邮件消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置发件人
        simpleMailMessage.setFrom(sender.getUserEmail());
        // 设置收件人
        simpleMailMessage.setTo(email.getTo());
        // 设置抄送人
        simpleMailMessage.setCc(email.getCc());
        // 设置密件抄送人
        simpleMailMessage.setBcc(email.getBcc());
        // 设置邮件主题
        simpleMailMessage.setSubject(email.getSubject());
        // 获取邮件内容
        String text = email.getTemplateFlag() ?
                // 是模板邮件，获取模板，组装模板邮件内容
                emailTemplateRepository.assemblyTemplateText(email.getTemplateCode(), email.getTemplateMap()) :
                // 不是模板邮件，直接取邮件内容
                email.getText();
        // 设置邮件内容
        simpleMailMessage.setText(text);
        // 发送邮件
        return sendEmail.sendEmail(sender, simpleMailMessage);
    }
    
    /**
     * 发送邮件
     *
     * @param email 发送邮件信息
     * @return 发送结果
     */
    @Override
    public boolean sendMimeMessageEmail(Email email) {
        // 获取发件人信息
        Sender sender = senderRepository.getSenderByFrom(email.getFrom());
        // 构造邮件消息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            // 使用 MimeMessageHelper 提供对HTML文本内容，图像等内联元素和典型邮件附件的支持
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            // 设置发件人
            mimeMessageHelper.setFrom(sender.getUserEmail());
            // 设置收件人
            mimeMessageHelper.setTo(email.getTo());
            // 设置抄送人
            mimeMessageHelper.setCc(email.getCc());
            // 设置密件抄送人
            mimeMessageHelper.setBcc(email.getBcc());
            // 设置邮件主题
            mimeMessageHelper.setSubject(email.getSubject());
            // 获取邮件内容
            String text = email.getTemplateFlag() ?
                    // 是模板邮件，获取模板，组装模板邮件内容
                    emailTemplateRepository.assemblyTemplateText(email.getTemplateCode(), email.getTemplateMap()) :
                    // 不是模板邮件，直接取邮件内容
                    email.getText();
            // 设置邮件内容，默认开启 html 格式的内容
            mimeMessageHelper.setText(text, email.getHtmlFlag());
            // 设置邮件附件
            String[] attachmentPath = email.getAttachmentPath();
            if (attachmentPath != null && attachmentPath.length > 0) {
                // 存在附件，遍历所有附件
                for (String path : attachmentPath) {
                    // 读取附件
                    FileSystemResource file = new FileSystemResource(path);
                    // 截取附件名
                    String fileName = path.substring(path.lastIndexOf(File.separator));
                    // 添加所有附件至邮件
                    mimeMessageHelper.addAttachment(fileName, file);
                }
            }
            // 发送邮件，返回发送结果
            return sendEmail.sendEmail(sender, mimeMessage);
        } catch (MessagingException e) {
            // 构建邮件消息异常，返回发送失败
            LOG.error(EmailConstants.FAIL_MESSAGE + e.getMessage());
            return false;
        }
    }
}
