package com.trkj.framework.mybatisplus.controller;

import com.trkj.framework.mybatisplus.service.ManAnalysisThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */
@RestController
public class ManAnalysisThreeController {
    @Autowired
    private ManAnalysisThreeService service;

    /**
     * 员工性别查询
     * @return
     */
    @GetMapping("/selectStaffSex")
    public Object querySex(){
        return service.selectStaffSex();
    }



}
