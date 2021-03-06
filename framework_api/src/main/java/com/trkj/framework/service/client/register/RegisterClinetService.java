package com.trkj.framework.service.client.register;

import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author 周刘奇
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8001/provider", fallbackFactory = RegisterClinetServiceFallbackfactory.class)
public interface RegisterClinetService {
    /***
     * 人脸识别登录
     * @param map
     * @return
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String, Object> map);

    /***
     * 账号密码登录
     * @param map
     * @return
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> map);
}
