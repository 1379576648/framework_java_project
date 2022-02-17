package com.trkj.framework;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 周刘奇
 */
@SpringBootApplication
/*
 在服务启动后自动注册到Eureka中
 */
@EnableEurekaClient
/*
 * 服务发现~
 */
@EnableDiscoveryClient
/*
添加对熔断的支持
 */
@EnableCircuitBreaker
@EnableCaching
public class ProviderHystrix8007 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8007.class, args);
    }

    /*
    增加一个servlet
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        return servletRegistrationBean;
    }
}
