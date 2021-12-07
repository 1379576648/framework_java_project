package com.trkj.framework.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 配置类
public class MyBatisPlusConfig {
    //注册我们的乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //逻辑删除
    @Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }

    //SQL执行效率插件
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //ms 设置sql执行的最大时间，如果超过了则不执行
        performanceInterceptor.setMaxTime(100);
        //开启Sql格式化
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
