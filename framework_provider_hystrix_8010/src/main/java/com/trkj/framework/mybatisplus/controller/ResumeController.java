package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 简历表 前端控制器
 * </p>
 *
 * @author 牛蛙
 * @since 2021-12-23
 */
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    //新简历
    @PostMapping("/selectResume")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object queryResume(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succed",resumeService.selectPageVo(resumeVo));
        return map;
    }
    // 备选方案
    public Object HystixGet(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    // 全部简历
    @PostMapping("/selectAllresume")
    @HystrixCommand(fallbackMethod = "HystixResume")
    public Object queryAll(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succed",resumeService.selectAll(resumeVo));
        return map;
    }
    // 备选方案
    public Object HystixResume(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    // 候选人
    @PostMapping("/selectCandidate")
    @HystrixCommand(fallbackMethod = "HystixCandidate")
    public Object queryCandidate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succed",resumeService.selectCandidate(resumeVo));
        return map;
    }
    // 备选方案
    public Object HystixCandidate(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    // 淘汰库
    @PostMapping("/selectEliminate")
    @HystrixCommand(fallbackMethod = "HystixEliminate")
    public Object queryEliminate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succed",resumeService.selectEliminate(resumeVo));
        return map;
    }
    // 备选方案
    public Object HystixEliminate(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}








