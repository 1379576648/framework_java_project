package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    // 新简历
    @PostMapping("/selectResume")
    private Object queryResume(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryResume(resumeVo));
    }

    // 全部简历
    @PostMapping("/selectAllresume")
    private Object queryAll(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryAll(resumeVo));
    }

    // 候选人
    @PostMapping("/selectCandidate")
    private Object queryCandidate(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryCandidate(resumeVo));
    }

    // 淘汰库
    @PostMapping("/selectEliminate")
    private Object queryEliminate(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryEliminate(resumeVo));
    }
}
