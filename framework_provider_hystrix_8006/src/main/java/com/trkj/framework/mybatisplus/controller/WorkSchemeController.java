package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.util.Fuse8006Util;
import com.trkj.framework.vo.WorkSchemeVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkSchemeController {

    @Autowired
    private WorkSchemeService workSchemeService;

    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 查询加班方案
     *
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo) {
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", workSchemeService.selectWorkScheme(workSchemeVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet(@RequestBody WorkSchemeVo workSchemeVo) {
        return fuse8006Util.main();
    }

    /**
     * 添加加班方案
     *
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> insertWorkScheme(@RequestBody WorkScheme workScheme) {
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", workSchemeService.insertWorkScheme(workScheme));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet2(@RequestBody WorkScheme workScheme) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为禁用
     *
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    @HystrixCommand(fallbackMethod = "updateWorkSchemeStateHystixGet")
    public Map<String, Object> updateWorkSchemeState(@RequestBody WorkScheme workScheme) {
        workScheme.setWorkschemeState(1);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workSchemeService.updateWorkSchemeState(workScheme));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateWorkSchemeStateHystixGet(@RequestBody WorkScheme workScheme) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为启用
     *
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    @HystrixCommand(fallbackMethod = "updateWorkSchemeStateTwoHystixGet")
    public Map<String, Object> updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme) {
        workScheme.setWorkschemeState(0);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workSchemeService.updateWorkSchemeStateTwo(workScheme));
        return map1;

    }

    //备选方案
    public Map<String, Object> updateWorkSchemeStateTwoHystixGet(@RequestBody WorkScheme workScheme) {
        return fuse8006Util.main();
    }

    /**
     * 删除加班方案
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteWorkScheme/{id}")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> deleteWorkScheme(@PathVariable("id") Integer id) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workSchemeService.deleteWorkScheme(id));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet3(@PathVariable("id") Integer id) {
        return fuse8006Util.main();
    }

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeAll")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> selectWorkSchemeAll(@RequestBody WorkScheme workScheme){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workSchemeService.selectWorkSchemeAll(workScheme));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet4(@RequestBody WorkScheme workScheme){
        return fuse8006Util.main();
    }

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkScheme")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String, Object> updateWorkScheme(@RequestBody WorkScheme workScheme){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workSchemeService.updateWorkScheme(workScheme));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet5(@RequestBody WorkScheme workScheme){
        return fuse8006Util.main();
    }

    /**
     * 根据部门名称查询有无方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeBydept")
    @HystrixCommand(fallbackMethod = "hystixGet6")
    public Map<String, Object> selectWorkSchemeBydept(@RequestBody WorkScheme workScheme){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workSchemeService.selectWorkSchemeBydept(workScheme));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet6(@RequestBody WorkScheme workScheme){
        return fuse8006Util.main();
    }

}
