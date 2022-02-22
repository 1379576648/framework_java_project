package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/EmployStaff")
    public Object employStaff(@RequestBody Employment employment){
        Map<String,Object> map = (Map<String, Object>) newresumeClinetService.employStaff(employment);
        return AjaxResponse.success(carryTokenUtil.main(map));}
}
