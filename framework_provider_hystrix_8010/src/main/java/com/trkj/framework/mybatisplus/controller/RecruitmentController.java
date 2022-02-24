package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.RecruitmentService;
import com.trkj.framework.util.Fuse8010Util;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 牛蛙
 */
@RestController
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private Fuse8010Util fuse8010Util;

    /**
     * 招聘计划查询
     * @param
     * @return
     */
    @PostMapping("/selectRecruitment")
    @HystrixCommand(fallbackMethod = "hystrixRecruitment")
    public  Map<String, Object>  queryRecruitment(@RequestBody RecruitmentVo recruitmentVo){
        Map<String , Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",recruitmentService.selectRecruitment(recruitmentVo));
        return map;
    }

    /**
     * 备选方案
     * @param
     * @return
     */
    public  Map<String, Object> hystrixRecruitment(@RequestBody RecruitmentVo recruitmentVo){
        return fuse8010Util.main();
    }


}
