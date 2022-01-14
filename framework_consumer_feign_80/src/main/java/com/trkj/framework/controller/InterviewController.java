package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TanWei
 */
@RestController
public class InterviewController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    /**
     * 面试通过查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewPass")
    public Object queryInterviewPass(@RequestBody InterviewVo interviewVo){
        return AjaxResponse.success(newresumeClinetService.queryInterviewPass(interviewVo));
    }
}
