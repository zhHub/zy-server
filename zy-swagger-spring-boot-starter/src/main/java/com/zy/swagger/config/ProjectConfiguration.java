package com.zy.swagger.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * fileName: ProjectConfiguration
 * create: 2021-5-25 22:44
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Configuration
@ConfigurationProperties(prefix = "zy.project")
@ApiModel(value = "自定义配置")
public class ProjectConfiguration {
    @ApiModelProperty(value = "版本", example = "1.0.0")
    @Value("${zy.project.version}")
    private String version;
    
    @ApiModelProperty(value = "描述", example = "demo for spring boot")
    @Value("${zy.project.description}")
    private String description;
    
    @ApiModelProperty(value = "开发者", example = "zhang san")
    @Value("${zy.project.name}")
    private String name;
    
    @ApiModelProperty(value = "开发者邮箱", example = "zhangsan@163.com")
    @Value("${zy.project.email}")
    private String email;
    
    @ApiModelProperty(value = "开发者主页", example = "www.xx.com")
    @Value("${zy.project.url}")
    private String url;
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
}
