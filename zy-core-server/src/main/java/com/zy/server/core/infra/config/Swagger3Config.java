package com.zy.server.core.infra.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * fileName: Swagger3Config
 * create: 2021-5-24 23:17
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {
    
    private final ProjectConfiguration projectConfiguration;
    
    @Autowired
    public Swagger3Config(ProjectConfiguration projectConfiguration) {
        this.projectConfiguration = projectConfiguration;
    }
    
    
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        
    }
    
    private ApiInfo apiInfo() {
        
        return new ApiInfoBuilder()
                .title("Swagger接口文档")
                .description(projectConfiguration.getDescription())
                .contact(
                        new Contact(projectConfiguration.getName(),
                                projectConfiguration.getUrl(),
                                projectConfiguration.getEmail())
                )
                .version(projectConfiguration.getVersion())
                .build();
        
    }
}
