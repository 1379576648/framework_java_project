package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Interview;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.util.Fuse8010Util;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @Autowired
    private Fuse8010Util fuse8010Util;

    /**
     * 面试通过查询
     * @param
     * @return
     */
    @PostMapping("/selectInterviewPass")
    @HystrixCommand(fallbackMethod = "hystrixInterviewPass")
    public Map<String, Object> queryInterviewPass(@RequestBody InterviewVo interviewVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",interviewService.selectInterviewPass(interviewVo));
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> hystrixInterviewPass(@RequestBody InterviewVo interviewVo){
       return fuse8010Util.main();
    }

    /**
     * 待面试查询
     * @param
     * @return
     */
    @PostMapping("/selectForInterview")
    @HystrixCommand(fallbackMethod = "hystrixForInterview")
    public Map<String, Object> selectForInterview(@RequestBody InterviewVo interviewVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",interviewService.selectForInterview(interviewVo));
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> hystrixForInterview(@RequestBody InterviewVo interviewVo){
        return fuse8010Util.main();
    }

    /**
     * 面试中查询
     * @param
     * @return
     */
    @PostMapping("/selectInInterview")
    @HystrixCommand(fallbackMethod = "hystrixInInterview")
    public Map<String, Object> selectInInterview(@RequestBody InterviewVo interviewVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",interviewService.selectInInterview(interviewVo));
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> hystrixInInterview(@RequestBody InterviewVo interviewVo){
        return fuse8010Util.main();
    }

    /**
     * 复试中查询
     * @param
     * @return
     */
    @PostMapping("/selectSecondInterview")
    @HystrixCommand(fallbackMethod = "hystrixSecondInterview")
    public Map<String, Object> selectSecondInterview(@RequestBody InterviewVo interviewVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",interviewService.selectSecondInterview(interviewVo));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> hystrixSecondInterview(@RequestBody InterviewVo interviewVo){
        return fuse8010Util.main();
    }

    /**
     * 面试淘汰查询
     * @param
     * @return
     */
    @PostMapping("/selectInterviewOut")
    @HystrixCommand(fallbackMethod = "hystrixSelectInterviewOut")
    public Map<String, Object> selectInterviewOut(@RequestBody InterviewVo interviewVo){
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",interviewService.selectInterviewOut(interviewVo));
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> hystrixSelectInterviewOut(@RequestBody InterviewVo interviewVo){
        return fuse8010Util.main();
    }

    /**
     * 添加录用数据
     * @param
     * @return
     */
    @PostMapping("/EmployStaff")
    @HystrixCommand(fallbackMethod = "employStaffHystrix")
    public Map<String, Object>  employStaff(@RequestBody Employment employment){
        Map<String, Object>map = new HashMap<>(2);
        map.put("state",200);
        map.put("succeed",interviewService.EmployStaff(employment));
        return map;
    }
    /**
     * 备选方案
     * @param
     * @return
     */
    public Map<String, Object> employStaffHystrix(@RequestBody Employment employment){
        return fuse8010Util.main();
    }

    /**
     * 修改面试到录用
     * @param
     * @return
     */
    @PutMapping("/InterviewHire")
    @HystrixCommand(fallbackMethod = "HystrixInterviewHire")
    public Map<String, Object> InterviewHire(@RequestBody Interview interview) {
        interview.setInterviewState(5);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.InterviewHire(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixInterviewHire(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }


    /**
     * 开始面试
     * @param
     * @return
     */
    @PutMapping("/BeginBy")
    @HystrixCommand(fallbackMethod = "HystrixBeginBy")
    public Map<String, Object> BeginBy(@RequestBody Interview interview) {
        interview.setInterviewState(1);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.BeginBy(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixBeginBy(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 淘汰（待面试）
     * @param
     * @return
     */
    @PutMapping("/GiveUp")
    @HystrixCommand(fallbackMethod = "HystrixGiveUp")
    public Map<String, Object> GiveUp(@RequestBody Interview interview) {
        interview.setInterviewState(5);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.GiveUp(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixGiveUp(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }


    /**
     * 面试通过（面试中）
     * @param
     * @return
     */
    @PutMapping("/PassInterview")
    @HystrixCommand(fallbackMethod = "HystrixPassInterview")
    public Map<String, Object> PassInterview(@RequestBody Interview interview) {
        interview.setInterviewState(2);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.PassInterview(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixPassInterview(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 安排复试（面试中）
     * @param
     * @return
     */
    @PutMapping("/TheSecondInterview")
    @HystrixCommand(fallbackMethod = "HystrixTheSecondInterview")
    public Map<String, Object> TheSecondInterview(@RequestBody Interview interview) {
        interview.setInterviewState(3);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.TheSecondInterview(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixTheSecondInterview(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 淘汰（面试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp2")
    @HystrixCommand(fallbackMethod = "HystrixGiveUp2")
    public Map<String, Object> GiveUp2(@RequestBody Interview interview) {
        interview.setInterviewState(5);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.GiveUp2(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixGiveUp2(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 复试通过
     * @param
     * @return
     */
    @PutMapping("/secondInterviewPass")
    @HystrixCommand(fallbackMethod = "HystrixSecondInterviewPass")
    public Map<String, Object> secondInterviewPass(@RequestBody Interview interview) {
        interview.setInterviewState(2);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.secondInterviewPass(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixSecondInterviewPass(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 淘汰（复试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp3")
    @HystrixCommand(fallbackMethod = "HystrixGiveUp3")
    public Map<String, Object> GiveUp3(@RequestBody Interview interview) {
        interview.setInterviewState(5);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.GiveUp3(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixGiveUp3(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }

    /**
     * 淘汰（面试通过）
     * @param
     * @return
     */
    @PutMapping("/GiveUp4")
    @HystrixCommand(fallbackMethod = "HystrixGiveUp4")
    public Map<String, Object> GiveUp4(@RequestBody Interview interview) {
        interview.setInterviewState(5);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", interviewService.GiveUp3(interview));
        return map1;
    }

    //备选方案
    public Map<String, Object> HystrixGiveUp4(@RequestBody Interview interview) {
        return fuse8010Util.main();
    }
}
