package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import com.trkj.framework.vo.WorkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/mybatisplus/workExperience")
public class WorkExperienceController {
//    @Autowired
//    private WorkExperienceService workExperienceService;
//
//    /**
//     * 查询工作经历
//     */
//    @GetMapping("/selectwork")
//    public Object selectwork(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
//        Page<WorkVo> page = new Page<>(currentPage,pagesize);
//        Map<String,Object> map = new HashMap<>();
//        map.put("state",200);
//        map.put("succeed",workExperienceService.selectwork(page));
//        return map;
//
//    }

}

