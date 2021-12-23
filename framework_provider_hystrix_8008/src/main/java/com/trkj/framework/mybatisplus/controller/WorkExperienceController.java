package com.trkj.framework.mybatisplus.controller;


import com.trkj.framework.entity.mybatisplus.staff_workvo;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/mybatisplus/workExperience")
public class WorkExperienceController {


    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping("/staff_workSelect")
    @ResponseBody
    public List<staff_workvo> staff_workSelect(){
        List<staff_workvo> list =workExperienceService.staffSelect();
        return list;
    }

}

