package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.RegisterLogClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

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

    /***
     * 复选删除
     * @param list
     * @return
     */
    @PostMapping("/checkDelete")
    public AjaxResponse checkDelete(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(registerLogClinetService.checkDelete(list));
    }

    /**
     * 清空数据
     * @return
     */
    @DeleteMapping("/emptyList")
    public AjaxResponse emptyList(){
        return AjaxResponse.success(registerLogClinetService.emptyList());
    }
 }
