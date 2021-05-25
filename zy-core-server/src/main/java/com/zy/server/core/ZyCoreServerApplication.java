package com.zy.server.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * fileName: ZyCoreServerApplication
 * create: 2021-5-24 21:33
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@EnableConfigurationProperties
@SpringBootApplication
public class ZyCoreServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZyCoreServerApplication.class, args);
    }
    
}
