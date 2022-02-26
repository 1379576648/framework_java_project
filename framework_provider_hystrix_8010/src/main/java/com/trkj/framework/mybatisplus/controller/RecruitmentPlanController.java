package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.RecruitmentPlanService;
import com.trkj.framework.util.Fuse8010Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TanWei
 */
@RestController
public class RecruitmentPlanController {
    @Autowired
    private RecruitmentPlanService service;

    @Autowired
    private Fuse8010Util fuse8010Util;

    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectPlan")
    @HystrixCommand(fallbackMethod = "hystrixPlan")
    public Map<String, Object> selectPlan(){
        Map<String , Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",service.selectPlan());
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public  Map<String, Object> hystrixPlan(){
        return fuse8010Util.main();
    }

    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptName1")
    @HystrixCommand(fallbackMethod = "hystrixDept")
    public Map<String, Object> selectDeptName1(){
        Map<String , Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",service.selectDeptName1());
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public  Map<String, Object> hystrixDept(){
        return fuse8010Util.main();
    }

    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptPostName1")
    @HystrixCommand(fallbackMethod = "hystrixDeptPostName")
    public Map<String, Object> selectDeptPostName1(){
        Map<String , Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",service.selectDeptPostName1());
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public  Map<String, Object> hystrixDeptPostName(){
        return fuse8010Util.main();
    }

    /**
     * 查询月薪范围（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectMonthlySalary")
    @HystrixCommand(fallbackMethod = "hystrixMonthlySalary")
    public Map<String, Object> selectMonthlySalary(){
        Map<String , Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",service.selectMonthlySalary());
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public  Map<String, Object> hystrixMonthlySalary(){
        return fuse8010Util.main();
    }
}
