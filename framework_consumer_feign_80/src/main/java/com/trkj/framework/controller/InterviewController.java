package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Interview;
import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author TanWei
 */
@RestController
public class InterviewController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;
    /**
     * 面试通过查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewPass")
    public Object queryInterviewPass(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.queryInterviewPass(interviewVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 待面试查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectForInterview")
    public Object selectForInterview(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.selectForInterview(interviewVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试中查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInInterview")
    public Object selectInInterview(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.selectInInterview(interviewVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 复试中查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectSecondInterview")
    public Object selectSecondInterview(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.selectSecondInterview(interviewVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试通过查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewOut")
    public Object selectInterviewOut(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.selectInterviewOut(interviewVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试通过录用
     * @param
     * @return
     */
    @PostMapping("/EmployStaff")
    public Object employStaff(@RequestBody Employment employment){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.employStaff(employment);
        return AjaxResponse.success(carryTokenUtil.main(map));}

    /**
     * 开始面试
     * @param
     * @return
     */
    @PutMapping("/BeginBy")
    private Object BeginBy(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.BeginBy(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 淘汰（待面试）
     * @param
     * @return
     */
    @PutMapping("/GiveUp")
    private Object GiveUp(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.GiveUp(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试通过（面试中）
     * @param
     * @return
     */
    @PutMapping("/PassInterview")
    private Object PassInterview(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.PassInterview(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 安排复试（面试中）
     * @param
     * @return
     */
    @PutMapping("/TheSecondInterview")
    private Object TheSecondInterview(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.TheSecondInterview(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 淘汰（面试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp2")
    private Object GiveUp2(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.GiveUp2(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 复试通过
     * @param
     * @return
     */
    @PutMapping("/secondInterviewPass")
    private Object secondInterviewPass(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.secondInterviewPass(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 淘汰（复试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp3")
    private Object GiveUp3(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.GiveUp3(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 淘汰（面试通过）
     * @param
     * @return
     */
    @PutMapping("/GiveUp4")
    private Object GiveUp4(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.GiveUp4(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
