package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Education;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.service.EducationService;
import com.trkj.framework.mybatisplus.service.PunishService;
import com.trkj.framework.util.Fuse8008Util;
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

    @Autowired
    private Fuse8008Util fuse8008Util;

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationOne")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public  Map<String, Object> selectEducationOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", educationService.selectEducationOne(workVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public  Map<String, Object> insertEducation(@RequestBody Education education){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",educationService.insertEducation(education));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet2(@RequestBody Education education) {
        return fuse8008Util.main();
    }

    /**
     * 修改教育经历
     * @param educationId
     * @return
     */
    @PutMapping("/updateEducation")
    @HystrixCommand(fallbackMethod = "updateEducationHystrix")
    public  Map<String, Object> updateEducation(@RequestBody Education educationId){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",educationService.updateEducation(educationId));
        return map1;

    }

    //备选方案
    public Map<String,Object> updateEducationHystrix(@RequestBody Education educationId) {
        return fuse8008Util.main();
    }

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public  Map<String, Object> deleteEducation(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",educationService.deleteEducation(list));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet3(@RequestBody ArrayList<Integer> list) {
        return fuse8008Util.main();
    }

}

