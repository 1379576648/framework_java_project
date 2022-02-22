package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.mybatisplus.service.NoticeService;
import com.trkj.framework.util.Fuse8002Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private Fuse8002Util fuse8002Util;
    /**
     * 通过员工编号查询公告信息
     * @param integer
     * @return
     */
    @GetMapping("/selectNoticeStaffId/{id}")
    @HystrixCommand(fallbackMethod = "selectNoticeStaffIdHystrix")
    public Map<String,Object> selectNoticeStaffId(@PathVariable("id") Integer integer){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectNoticeStaffId(integer));
        return  map1;
    }
    //备选方案
    public Map<String,Object> selectNoticeStaffIdHystrix(@PathVariable("id") Integer integer){
        return fuse8002Util.main();
    }
    /**
     * 通过公告编号修改公告员工状态
     * @param integer1
     * @param integer2
     * @return
     */
    @PutMapping("/updateNoticeOrId/{id1}/{id2}")
    @HystrixCommand(fallbackMethod = "updateNoticeOrIdHystrix")
    public Map<String,Object> updateNoticeOrId(@PathVariable("id1") Integer integer1,@PathVariable("id2") Integer integer2){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.updateNoticeOrId(integer1,integer2));
        return map1;
    }

    //备选方案
    public Map<String,Object> updateNoticeOrIdHystrix(@PathVariable("id1") Integer integer1,@PathVariable("id2") Integer integer2){
        return fuse8002Util.main();
    }
}

