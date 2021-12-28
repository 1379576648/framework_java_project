package com.trkj.framework.service.client.system;

import com.trkj.framework.entity.mybatisplus.RegisterLog;

import com.trkj.framework.service.client.fallbackfactory.RegisterLogClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 13795
 */
@FeignClient(value = "REGISTER-8007/provider", fallbackFactory = RegisterLogClinetServiceFallbackfactory.class)
public interface RegisterLogClinetService {
    /***
     *  登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    public Object selectRegisterLogAll(@RequestBody  RegisterLog registerLog);
}
