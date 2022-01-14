package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    /**
     * 面试通过查询
     * @param
     * @return
     */
    @PostMapping("/selectInterviewPass")
    @HystrixCommand(fallbackMethod = "HystrixInterviewPass")
    public Object queryInterviewPass(@RequestBody InterviewVo interviewVo){
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
    public Object HystrixInterviewPass(@RequestBody InterviewVo interviewVo){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}
