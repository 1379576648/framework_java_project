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
}
