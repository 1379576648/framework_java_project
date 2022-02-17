package com.trkj.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author 周刘奇
 */
//Ribbon 和Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = {"com.trkj.framework.service.client"})
//在服务启动后自动注册到Eureka中
@EnableEurekaClient
//开启缓存
@EnableCaching
public class ConsumerFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80.class, args);
    }
}
