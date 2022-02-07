package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Classes;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 112729
 */
@RestController
public class ClassesController {
    @Autowired
    private CheckingService checkingService;

    /**
     * 查询所有班次方案
     * @param classes
     * @return
     */
    @PostMapping("/selectClassesAll")
    public AjaxResponse selectClassesAll(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.selectClassesAll(classes));
    }

    /**
     * 添加班次方案
     * @param classes
     * @return
     */
    @PostMapping("/submitFormClasses")
    public AjaxResponse submitFormClasses(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.submitFormClasses(classes));
    }

    /**
     * 查询班次方案
     * @param classes
     * @return
     */
    @PostMapping("/inquireClasses")
    public AjaxResponse inquireClasses(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.inquireClasses(classes));
    }

    /**
     * 删除班次方案
     * @param classes
     * @return
     */
    @PostMapping("/deleteClasses")
    public AjaxResponse deleteClasses(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.deleteClasses(classes));
    }

    /**
     * 查询所有班次方案1
     * @param classes
     * @return
     */
    @PostMapping("/selectClasses")
    public AjaxResponse selectClasses(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.selectClasses(classes));
    }

    /**
     * 修改班次方案状态(启用)
     * @param classes
     * @return
     */
    @PostMapping("/updateClassesState")
    public AjaxResponse updateClassesState(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.updateClassesState(classes));
    }

    /**
     * 修改班次方案状态(禁用)
     * @param classes
     * @return
     */
    @PostMapping("/updateClassesStateTwo")
    public AjaxResponse updateClassesStateTwo(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.updateClassesStateTwo(classes));
    }

    /**
     * 根据班次编号去查询班次方案
     * @param classes
     * @return
     */
    @PostMapping("/selectClassesByID")
    public AjaxResponse selectClassesByID(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.selectClassesByID(classes));
    }

    /**
     * 修改班次方案
     * @param classes
     * @return
     */
    @PostMapping("/updateClasses")
    public AjaxResponse updateClasses(@RequestBody Classes classes) {
        return AjaxResponse.success(checkingService.updateClasses(classes));
    }
}
