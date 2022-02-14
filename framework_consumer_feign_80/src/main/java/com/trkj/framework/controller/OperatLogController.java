package com.trkj.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.util.CarryTokenUtil;

import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/operatLog")
public class OperatLogController {
    @Autowired
    private SystemClinetService systemClinetService =null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /***
     * 操作日志分页查询
     * @param operatLog
     * @return
     */
    @PostMapping("/selectOperatLogAll")
    @ApiOperation(value = "操作日志分页查询",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/selectOperatLogAll")
    public AjaxResponse selectOperatLogAll(@RequestBody OperatLog operatLog){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectOperatLogAll(operatLog);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 复选删除操作日志
     * @param list
     * @return
     */
    @DeleteMapping("/checkOperatLogDelete")
    @ApiOperation(value = "复选删除操作日志",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/checkOperatLogDelete")
    public AjaxResponse checkOperatLogDelete(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.checkOperatLogDelete(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 清除时间段操作日志
     * @return
     */
    @DeleteMapping("/emptyOperatLogList")
    @ApiOperation(value = "清除时间段操作日志",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/emptyOperatLogList")
    public AjaxResponse emptyOperatLogList(@RequestBody OperatLog operatLog){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.emptyOperatLogList(operatLog);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
