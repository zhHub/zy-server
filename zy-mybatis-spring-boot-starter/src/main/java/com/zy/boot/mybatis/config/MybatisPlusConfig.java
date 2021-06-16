package com.zy.boot.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * fileName: MybatisPlusConfig
 * create: 2021-6-13 15:05
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Configuration
@MapperScan("com.zy.**.infra.mapper")
public class MybatisPlusConfig {
}
