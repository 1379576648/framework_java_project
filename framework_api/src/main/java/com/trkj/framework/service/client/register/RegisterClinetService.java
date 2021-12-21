package com.trkj.framework.service.client.register;

import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author 周刘奇
 */
@FeignClient(value = "REGISTER-8001/provider", fallbackFactory = RegisterClinetServiceFallbackfactory.class)
public interface RegisterClinetService {
    /***
     * 登录接口
     * @param map
     * @return
     */
    @PostMapping("/register")
    public Object register(@RequestBody Map<String, Object> map);
}
