package com.zy.boot.email.exception;

/**
 * fileName: EmailSendException
 * create: 2021-6-16 21:22
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class EmailSendException extends RuntimeException {
    
    private final String code;
    
    private final String message;
    
    
    public EmailSendException() {
        this("邮件发送失败");
    }
    
    public EmailSendException(String message) {
        this("email.send.error", message);
    }
    
    public EmailSendException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
