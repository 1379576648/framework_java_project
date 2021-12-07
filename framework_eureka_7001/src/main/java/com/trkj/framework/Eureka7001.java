package com.trkj.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 周刘奇
 */
@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer服务端的启动类，可以接受别人注册进来
public class Eureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class, args);
    }
}
