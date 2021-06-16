package com.zy.boot.core.exception;

import com.zy.boot.email.exception.EmailSendException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * fileName: GlobalExceptionHandler
 * create: 2021-6-16 21:35
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Order(-1)
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(EmailSendException.class)
    public ResponseEntity<Object> handleException(EmailSendException e) {
        LOG.error("code: {},\n message: {},\n oth: {}", e.getCode(), e.getMessage(), e.getCause());
        return ResponseEntity.ok(e.getCode() + e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        LOG.error("message: {},\n oth: {}", e.getMessage(), e.getCause());
        return ResponseEntity.ok(e.getMessage());
    }
}
