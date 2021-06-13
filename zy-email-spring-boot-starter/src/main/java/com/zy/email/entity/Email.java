package com.zy.email.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * fileName: Email
 * create: 2021-5-29 21:25
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {
    /**
     * 发件人
     */
    private String from;
    
    /**
     * 收件人
     */
    private String[] to = new String[0];
    
    /**
     * 抄送人
     */
    private String[] cc = new String[0];
    
    /**
     * 密件抄送
     */
    private String[] bcc = new String[0];
    
    /**
     * 发送日期
     */
    private Date sentDate;
    
    /**
     * 邮件标题
     */
    private String subject;
    
    /**
     * 邮件内容
     */
    private String text;
    
    /**
     * 是否使用模板，默认否
     */
    private Boolean templateFlag = Boolean.FALSE;
    
    /**
     * 是否使用默认内容类型（“text/plain”）为HTML邮件应用内容类型 “text/html”,默认是
     */
    private Boolean htmlFlag = Boolean.TRUE;
    
    /**
     * HTML 模板标识 code
     */
    private String templateCode;
    
    /**
     * 模板内容
     */
    private Map<String, Object> templateMap = new HashMap<>();
    
    /**
     * 附件
     */
    private String[] attachmentPath = new String[0];
}
