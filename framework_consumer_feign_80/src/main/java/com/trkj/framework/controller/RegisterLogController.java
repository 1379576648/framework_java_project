package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.RegisterLogClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 13795
 */
@RestController
public class RegisterLogController {
    @Autowired
    private RegisterLogClinetService registerLogClinetService=null;

    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    public AjaxResponse selectRegisterLogAll( @RequestBody  RegisterLog registerLog){
        return AjaxResponse.success(registerLogClinetService.selectRegisterLogAll(registerLog)) ;
    }
}
