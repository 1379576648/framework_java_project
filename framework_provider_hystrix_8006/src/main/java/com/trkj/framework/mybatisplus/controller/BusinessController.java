package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Business;
import com.trkj.framework.mybatisplus.service.BusinessService;
import com.trkj.framework.util.Fuse8006Util;
import com.trkj.framework.vo.BusinessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 查询出差方案
     * @param businessVo
     * @return
     */
    @PostMapping("/selectBusiness")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Map<String,Object> selectBusiness(@RequestBody BusinessVo businessVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",businessService.selectBusiness(businessVo));
        return map1;
    }

    public Map<String,Object> HystixGet(@RequestBody BusinessVo businessVo){
        return fuse8006Util.main();
    }

    /**
     * 添加出差方案
     *
     * @param business
     * @return
     */
    @PostMapping("/insertBusiness")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> insertBusiness(@RequestBody Business business) {
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", businessService.insertBusiness(business));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet2(@RequestBody Business business) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为禁用
     *
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessState")
    @HystrixCommand(fallbackMethod = "updateBusinessStateHystixGet")
    public Map<String, Object> updateBusinessState(@RequestBody Business business) {
        business.setBusinessState(1);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", businessService.updateBusinessState(business));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateBusinessStateHystixGet(@RequestBody Business business) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为启用
     *
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessStateTwo")
    @HystrixCommand(fallbackMethod = "updateBusinessStateTwoHystixGet")
    public Map<String, Object> updateBusinessStateTwo(@RequestBody Business business) {
        business.setBusinessState(0);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", businessService.updateBusinessStateTwo(business));
        return map1;

    }

    //备选方案
    public Map<String, Object> updateBusinessStateTwoHystixGet(@RequestBody Business business) {
        return fuse8006Util.main();
    }

    /**
     * 删除出差方案
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteBusiness/{id}")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> deleteBusiness(@PathVariable("id") Integer id) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", businessService.deleteBusiness(id));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet3(@PathVariable("id") Integer id) {
        return fuse8006Util.main();
    }

    /**
     * 根据id查询出差方案
     * @param business
     * @return
     */
    @PostMapping("/selectBusinessAll")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> selectBusinessAll(@RequestBody Business business){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", businessService.selectBusinessAll(business));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet4(@RequestBody Business business){
        return fuse8006Util.main();
    }

    /**
     * 修改出差方案
     * @param business
     * @return
     */
    @PutMapping("/updateBusiness")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String, Object> updateBusiness(@RequestBody Business business){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", businessService.updateBusiness(business));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet5(@RequestBody Business business){
        return fuse8006Util.main();
    }

}
