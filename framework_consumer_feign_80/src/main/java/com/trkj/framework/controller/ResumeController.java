package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    @PostMapping("/selectResume")
    private Object queryResume(@RequestBody ResumeVo resumeVo){
        return newresumeClinetService.queryResume(resumeVo);
    }

    @PostMapping("/selectAllresume")
    private Object queryAll(@RequestBody ResumeVo resumeVo){
        return newresumeClinetService.queryAll(resumeVo);
    }

    @PostMapping("/selectCandidate")
    private Object queryCandidate(@RequestBody ResumeVo resumeVo){
        return newresumeClinetService.queryCandidate(resumeVo);
    }

    @PostMapping("/selectEliminate")
    private Object queryEliminate(@RequestBody ResumeVo resumeVo){
        return newresumeClinetService.queryEliminate(resumeVo);
    }
}
