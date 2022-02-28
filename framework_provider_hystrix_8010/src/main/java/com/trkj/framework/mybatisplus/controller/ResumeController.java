package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.RecruitmentPlan;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.trkj.framework.util.Fuse8010Util;
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

    @Autowired
    private Fuse8010Util fuse8010Util;

    /**
     * 新简历查询
     *
     * @param
     * @return
     */
    @PostMapping("/selectResume")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Map<String, Object> queryResume(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectPageVo(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixGet(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }


    /**
     * 全部简历
     * @param
     * @return
     */
    @PostMapping("/selectAllresume")
    @HystrixCommand(fallbackMethod = "hystrixResume")
    public Map<String, Object> queryAll(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectAll(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixResume(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }


    /**
     * 候选人
     *
     * @param
     * @return
     */
    @PostMapping("/selectCandidate")
    @HystrixCommand(fallbackMethod = "hystrixCandidate")
    public Map<String, Object> queryCandidate(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectCandidate(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixCandidate(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }


    /**
     * 淘汰库
     *
     * @param
     * @return
     */
    @PostMapping("/selectEliminate")
    @HystrixCommand(fallbackMethod = "hystrixEliminate")
    public Map<String, Object> queryEliminate(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectEliminate(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixEliminate(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }

    /**
     * 面试候选人
     *
     * @param
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    @HystrixCommand(fallbackMethod = "hystrixInterviewCandidate")
    public Map<String, Object> queryInterviewCandidate(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectInterviewCandidate(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixInterviewCandidate(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }

    /**
     * 已邀约
     *
     * @param
     * @return
     */
    @PostMapping("/selectInvite")
    @HystrixCommand(fallbackMethod = "hystrixInvite")
    public Map<String, Object> queryInvite(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("state", 200);
        map.put("succeed", resumeService.selectInvite(resumeVo));
        return map;
    }

    /**
     * 备选方案
     *
     * @param
     * @return
     */
    public Map<String, Object> hystrixInvite(@RequestBody ResumeVo resumeVo) {
        return fuse8010Util.main();
    }

    /**
     * 新增简历
     * @param
     * @return
     */
    @PostMapping("/addResume")
    @HystrixCommand(fallbackMethod = "hystrixAddResume")
    public Map<String, Object>  addResume(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = new HashMap<>(2);
        map.put("state",200);
        try {
            map.put("succeed",resumeService.addResume(resumeVo));
        }catch (ArithmeticException e) {
            map.put("info", e.getMessage());
        }
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object>  hystrixAddResume(@RequestBody ResumeVo resumeVo){
        return fuse8010Util.main();
    }


    /**
     * 设为候选人
     * @param
     * @return
     */
    @PutMapping("/SetCandidate")
    @HystrixCommand(fallbackMethod = "HystrixSetCandidate")
    public Map<String, Object> SetCandidate(@RequestBody Resume resume) {
        resume.setResumeZt(1);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", resumeService.SetCandidate(resume));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixSetCandidate(@RequestBody Resume resume) {
        return fuse8010Util.main();
    }

    /**
     * 转入淘汰库
     * @param
     * @return
     */
    @PutMapping("/Obsolete")
    @HystrixCommand(fallbackMethod = "HystrixObsolete")
    public Map<String, Object> Obsolete(@RequestBody Resume resume) {
        resume.setResumeZt(2);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", resumeService.Obsolete(resume));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixObsolete(@RequestBody Resume resume) {
        return fuse8010Util.main();
    }

    /**
     * 设为面试候选人
     *
     * @param
     * @return
     */
    @PutMapping("/InterviewCcandidate")
    @HystrixCommand(fallbackMethod = "HystrixInterviewCcandidate")
    public Map<String, Object> InterviewCcandidate(@RequestBody Resume resume) {
        resume.setResumeZt(3);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", resumeService.InterviewCcandidate(resume));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixInterviewCcandidate(@RequestBody Resume resume) {
        return fuse8010Util.main();
    }

    /**
     * 转入淘汰库（候选人）
     * @param
     * @return
     */
    @PutMapping("/HObsolete")
    @HystrixCommand(fallbackMethod = "HystrixHObsolete")
    public Map<String, Object> HObsolete(@RequestBody Resume resume) {
        resume.setResumeZt(2);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", resumeService.HObsolete(resume));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixHObsolete(@RequestBody Resume resume) {
        return fuse8010Util.main();
    }

    /**
     * 邀约面试（面试候选人）
     * @param
     * @return
     */
    @PutMapping("/OfferInterview")
    @HystrixCommand(fallbackMethod = "HystrixOfferInterview")
    public Map<String, Object> OfferInterview(@RequestBody Resume resume) {
        resume.setResumeZt(4);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", resumeService.OfferInterview(resume));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixOfferInterview(@RequestBody Resume resume) {
        return fuse8010Util.main();
    }


}








