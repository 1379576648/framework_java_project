package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.util.Fuse8010Util;
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

    public Map<String, Object> employStaffHystrix(@RequestBody Employment employment){
        return fuse8010Util.main();
    }
}
