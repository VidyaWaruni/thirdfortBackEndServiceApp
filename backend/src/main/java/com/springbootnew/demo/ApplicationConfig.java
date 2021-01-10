package com.springbootnew.demo;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(regex(".*")).build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo metadata() {
        return new ApiInfoBuilder().title("Interview 2 - Thirdfort - Version 1").description("API For Notes Manipulation in MultiUser Environment - Backend Application Services" +
                "").contact("Vidya Wimalasooriya, Undegraduate").version("1.0").build();
    }
}