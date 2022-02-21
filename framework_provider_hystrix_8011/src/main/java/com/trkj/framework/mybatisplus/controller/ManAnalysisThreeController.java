package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.ManAnalysisThreeService;
import com.trkj.framework.util.Fuse8011Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */
@RestController
public class ManAnalysisThreeController {
    @Autowired
    private ManAnalysisThreeService service;

    @Autowired
    private Fuse8011Util fuse8011Util;
    /**
     * 员工性别查询
     * @return
     */
    @GetMapping("/selectStaffSex")
    @HystrixCommand(fallbackMethod = "selectStaffSexHystrix")
    public Object querySex(){
        Map<String, Object>map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",service.selectStaffSex());
        return map;
    }

    public Map<String,Object> selectStaffSexHystrix(){
        return fuse8011Util.main();
    }

}
