package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/registerLog")
public class RegisterLogController {
    @Autowired
    private SystemClinetService systemClinetService =null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    @ApiOperation(value = "登录日志分页查询",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/selectRegisterLogAll")
    public AjaxResponse selectRegisterLogAll( @RequestBody  RegisterLog registerLog){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectRegisterLogAll(registerLog);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 复选删除登录日志
     * @param list
     * @return
     */
    @DeleteMapping("/checkRegisterLogDelete")
    @ApiOperation(value = "复选删除登录日志",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/checkRegisterLogDelete")
    public AjaxResponse checkDelete(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.checkDelete(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 清除时间段登录日志
     * @return
     */
    @DeleteMapping("/emptyRegisterLogList")
    @ApiOperation(value = "清除时间段登录日志",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/emptyRegisterLogList")
    public AjaxResponse emptyList(@RequestBody RegisterLog registerLog){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.emptyList(registerLog);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
 }
