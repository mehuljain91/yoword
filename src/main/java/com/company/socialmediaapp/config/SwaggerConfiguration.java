package com.company.socialmediaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 *
 * @author mehul jain
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
    @Bean
    public Docket yowordApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Yoword API")
                .version("1.0")
                .description("API for Yoword Application")
                .contact(new Contact("Mehul Jain", "http://example.com", "xyz@email.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
