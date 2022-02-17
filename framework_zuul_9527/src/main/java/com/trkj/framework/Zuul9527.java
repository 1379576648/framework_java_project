package com.trkj.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 周刘奇
 */
@SpringBootApplication
@EnableCircuitBreaker    //Hystrix Dashboard必须加
@EnableHystrixDashboard//展示熔断器仪表盘
@EnableZuulProxy    //网关映射 注解
@EnableDiscoveryClient
public class Zuul9527 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul9527.class, args);
    }
}
