package com.zy.server.core.infra.common.result;

import com.zy.server.core.infra.common.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * fileName: Results
 * create: 2021-5-26 22:12
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class Results<T> extends ResponseEntity<T> {
    
    /**
     * 消息内容
     */
    private final String message;
    
    /**
     * 数据
     */
    private final T data;
    
    public Results(String message) {
        super(HttpStatus.OK);
        this.message = message;
        this.data = null;
    }
    
    public Results(String message, T data) {
        super(HttpStatus.OK);
        this.message = message;
        this.data = data;
    }
    
    
    /**
     * 成功返回
     *
     * @param message 消息内容
     * @param data    数据
     * @return 返回数据对象
     */
    public static <T> ResponseEntity<T> success(String message, T data) {
        return ResponseEntity.ok(data);
    }
    
    /**
     * 成功返回
     *
     * @param data 数据
     * @return 返回数据对象
     */
    public static <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.ok(data);
    }
    
    /**
     * 成功返回
     *
     * @return 返回数据对象
     */
    public static ResponseEntity<Void> success() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    /**
     * 失败返回
     *
     * @param message 消息内容
     * @param data    数据
     * @return 返回数据对象
     */
    public static <T> ResponseEntity<T> error(String message, T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
    }
    
    
    /**
     * 失败返回
     *
     * @param data 数据
     * @return 返回数据对象
     */
    public static <T> ResponseEntity<T> error(T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
    }
    
    /**
     * 失败返回
     *
     * @return 返回数据对象
     */
    public static ResponseEntity<Void> error() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    /**
     * 异常返回
     *
     * @param e BaseException
     * @return 返回数据对象
     */
    public static ResponseEntity<Results<String>> exception(BaseException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Results<String>(e.getMessage()));
    }
    
    /**
     * 异常返回
     *
     * @param e Exception
     * @return 返回数据对象
     */
    public static ResponseEntity<Results<String>> exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Results<String>(e.getMessage()));
    }
    
    public String getMessage() {
        return message;
    }
    
    public T getData() {
        return data;
    }
    
    @Override
    public String toString() {
        return "Results{" +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
