package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 简历表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-23
 */
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    //新简历
    @GetMapping("/selectResume")
    @HystrixCommand(fallbackMethod = "HystixResume")
    public Object queryResume(@RequestParam("currenPage") int currenPage,@RequestParam("pagesize") int pagesize){
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succed",resumeService.selectPageVo(page));
        return map;
    }


    //备选方案
    public Object HystixResume(@RequestParam("currenPage") int currenPage,@RequestParam("pagesize") int pagesize){
        Page<Resume> page = new Page<>(currenPage, pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succed","服务发生雪崩");
        return map;
    }

    // 全部简历
    @GetMapping("/selectAllresume")
    @HystrixCommand(fallbackMethod = "HystixResume")
    public Object queryAll(@RequestParam("currenPage") int currenPage,@RequestParam("pagesize") int pagesize){
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succed",resumeService.selectAll(page));
        return map;
    }
}








