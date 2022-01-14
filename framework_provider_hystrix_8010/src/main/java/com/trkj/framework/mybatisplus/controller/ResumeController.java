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

    /**
     * 新简历查询
     * @param
     * @return
     */
    @PostMapping("/selectResume")
    @HystrixCommand(fallbackMethod = "HystrixGet")
    public Object queryResume(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",resumeService.selectPageVo(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixGet(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /**
     * 全部简历
     * @param
     * @return
     */
    @PostMapping("/selectAllresume")
    @HystrixCommand(fallbackMethod = "HystrixResume")
    public Object queryAll(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",resumeService.selectAll(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixResume(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /**
     * 候选人
     * @param
     * @return
     */
    @PostMapping("/selectCandidate")
    @HystrixCommand(fallbackMethod = "HystrixCandidate")
    public Object queryCandidate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",resumeService.selectCandidate(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixCandidate(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /**
     * 淘汰库
     * @param
     * @return
     */
    @PostMapping("/selectEliminate")
    @HystrixCommand(fallbackMethod = "HystrixEliminate")
    public Object queryEliminate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",resumeService.selectEliminate(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixEliminate(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 面试候选人
     * @param
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    @HystrixCommand(fallbackMethod = "HystrixInterviewCandidate")
    public Object queryInterviewCandidate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",resumeService.selectInterviewCandidate(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixInterviewCandidate(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 已邀约
     * @param
     * @return
     */
    @PostMapping("/selectInvite")
    //@HystrixCommand(fallbackMethod = "HystrixInvite")
    public Object queryInvite(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",resumeService.selectInvite(resumeVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Object HystrixInvite(@RequestBody ResumeVo resumeVo){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}








