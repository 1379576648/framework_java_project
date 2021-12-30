package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    @GetMapping("/selectResume")
    private Object queryResume(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize){
        return newresumeClinetService.queryResume(currenPage,pagesize);
    }

    @GetMapping("/selectAllresume")
    private Object queryAll(@RequestParam("currenPage") int currenPage,@RequestParam("pagesize") int pagesize){
        return newresumeClinetService.queryAll(currenPage,pagesize);
    }
}
