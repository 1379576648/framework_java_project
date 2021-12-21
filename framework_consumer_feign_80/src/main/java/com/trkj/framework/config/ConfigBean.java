package com.trkj.framework.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    //IRule
    //RoundRobinRule轮询
    //RandomRule随机
    //AvailabilityFilteringRule:会先过滤掉，跳闸，访问故障的服务~,对剩下的进行轮询~
    //RetryRule：会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
    @Bean
    public IRule myRule() {
        return new AvailabilityFilteringRule();
    }
}
