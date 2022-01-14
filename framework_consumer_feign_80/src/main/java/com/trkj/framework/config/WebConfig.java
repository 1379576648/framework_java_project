//package com.trkj.framework.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
//@Slf4j
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Resource
//    private TokenInterceptor tokenInterceptor ;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        log.debug("注册TokenInterceptor");
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
//    }
//}