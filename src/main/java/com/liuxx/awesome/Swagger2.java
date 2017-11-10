package com.liuxx.awesome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类
 *
 * @author :liuxx
 * @date: 2017/11/10 17:16
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuxx.awesome.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot 整合Swagger2 构建 RESTful APIS")
                .description("（description）第一次使用，不知道会出现什么玩意")
                .termsOfServiceUrl("https://www.baidu.com")
                .contact("liuxx -email:mrl6140xuan@outlook.com")
                .version("0.1")
                .build();
    }
}
