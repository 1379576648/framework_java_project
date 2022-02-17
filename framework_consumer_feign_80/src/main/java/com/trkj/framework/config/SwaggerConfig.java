package com.trkj.framework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig implements WebMvcConfigurer {

//    @Resource
//    private TokenInterceptor tokenInterceptor ;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trkj.framework.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("框架项目")
                .description("Controller接口")
                .contact(new Contact("联系我们", "https://www.51i-star.net/login.html", "1379576648@qq.com"))
                .version("1.0")
                .build();
    }

    /***
     * 注册拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        log.debug("注册TokenInterceptor");
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
//    }

}