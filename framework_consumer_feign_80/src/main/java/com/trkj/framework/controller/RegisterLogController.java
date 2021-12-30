package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author 13795
 */
@RestController
public class RegisterLogController {
    @Autowired
    private SystemClinetService systemClinetService =null;

    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    public AjaxResponse selectRegisterLogAll( @RequestBody  RegisterLog registerLog){
        return AjaxResponse.success(systemClinetService.selectRegisterLogAll(registerLog)) ;
    }

    /***
     * 复选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkRegisterLogDelete")
    public AjaxResponse checkDelete(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(systemClinetService.checkDelete(list));
    }

    /**
     * 清空数据
     * @return
     */
    @DeleteMapping("/emptyRegisterLogList")
    public AjaxResponse emptyList(){
        return AjaxResponse.success(systemClinetService.emptyList());
    }
 }
