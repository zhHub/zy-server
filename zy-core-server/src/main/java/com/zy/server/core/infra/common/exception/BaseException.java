package com.zy.server.core.infra.common.exception;

import com.zy.server.core.infra.constant.ExceptionCode;

/**
 * fileName: BaseException
 * create: 2021-5-26 21:03
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class BaseException extends RuntimeException {
    /**
     * 错误编码
     */
    private final String code;
    
    /**
     * 异常消息
     */
    private final String message;
    
    
    public BaseException(String message) {
        super(message);
        this.code = ExceptionCode.BASE_EXCEPTION;
        this.message = message;
    }
    
    
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    
    public BaseException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }
    
    /**
     * 获取异常消息
     */
    @Override
    public String getMessage() {
        return message;
    }
    
    public String getCode() {
        return code;
    }
}
