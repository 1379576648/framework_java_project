package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Classes;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 112729
 */
@RestController
public class ClassesController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 查询所有班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/selectClassesAll")
    @ApiOperation(value = "查询所有班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectClassesAll")
    public AjaxResponse selectClassesAll(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectClassesAll(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/submitFormClasses")
    @ApiOperation(value = "添加班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "添加", produces = "/submitFormClasses")
    public AjaxResponse submitFormClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.submitFormClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/inquireClasses")
    @ApiOperation(value = "查询班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/inquireClasses")
    public AjaxResponse inquireClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.inquireClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/deleteClasses")
    @ApiOperation(value = "删除班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteClasses")
    public AjaxResponse deleteClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有班次方案1
     *
     * @param classes
     * @return
     */
    @PostMapping("/selectClasses")
    @ApiOperation(value = "查询所有班次方案1", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectClasses")
    public AjaxResponse selectClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改班次方案状态(启用)
     *
     * @param classes
     * @return
     */
    @PostMapping("/updateClassesState")
    @ApiOperation(value = "修改班次方案状态(启用)", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateClassesState")
    public AjaxResponse updateClassesState(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateClassesState(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改班次方案状态(禁用)
     *
     * @param classes
     * @return
     */
    @PostMapping("/updateClassesStateTwo")
    @ApiOperation(value = "修改班次方案状态(禁用)", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateClassesStateTwo")
    public AjaxResponse updateClassesStateTwo(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateClassesStateTwo(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据班次编号去查询班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/selectClassesByID")
    @ApiOperation(value = "根据班次编号去查询班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectClassesByID")
    public AjaxResponse selectClassesByID(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectClassesByID(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改班次方案
     *
     * @param classes
     * @return
     */
    @PostMapping("/updateClasses")
    @ApiOperation(value = "修改班次方案", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateClasses")
    public AjaxResponse updateClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
