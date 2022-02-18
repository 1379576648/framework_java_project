package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Classes;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
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
    public AjaxResponse updateClasses(@RequestBody Classes classes) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateClasses(classes);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
