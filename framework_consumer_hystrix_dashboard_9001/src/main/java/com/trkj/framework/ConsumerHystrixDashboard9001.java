package com.trkj.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 周刘奇
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//开启监控
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard9001.class, args);
    }
}
