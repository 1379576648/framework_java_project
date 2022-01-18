package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Education;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.service.EducationService;
import com.trkj.framework.mybatisplus.service.PunishService;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 受教育经历表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class EducationController {

    @Autowired
    private EducationService educationService;

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationOne")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectEducationOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", educationService.selectEducationOne(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object insertEducation(@RequestBody Education education){
        return educationService.insertEducation(education);
    }

    //备选方案
    public Object HystixGet2(@RequestBody Education education){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改教育经历
     * @param educationId
     * @return
     */
    @PutMapping("/updateEducation")
    public Object updateEducation(@RequestBody Education educationId){
        //开始时间
        educationId.setEducationStartTime(educationId.getEducationStartTime());
        //结束时间
        educationId.setEducationEndTime(educationId.getEducationEndTime());
        //学校名称
        educationId.setEducationStudentname(educationId.getEducationStudentname());
        //所属专业
        educationId.setEducationMajor(educationId.getEducationMajor());
        final var i = educationService.updateEducation(educationId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }

    }

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object deleteEducation(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",educationService.deleteEducation(list));
        return map1;
    }

    //备选方案
    public Object HystixGet3(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

