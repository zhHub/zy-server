package com.zy.generator.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * fileName: GeneratorConfig
 * create: 2021-7-18 12:46
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Configuration
@MapperScan("com.zy.**.infra.mapper")
@ComponentScan("com.zy.generator")
public class GeneratorConfig {


}
