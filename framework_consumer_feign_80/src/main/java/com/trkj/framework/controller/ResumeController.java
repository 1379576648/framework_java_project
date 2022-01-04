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

    @GetMapping("/selectAllresume")
    private Object queryAll(@RequestParam("currenPage") int currenPage,@RequestParam("pagesize") int pagesize){
        return newresumeClinetService.queryAll(currenPage,pagesize);
    }
}
