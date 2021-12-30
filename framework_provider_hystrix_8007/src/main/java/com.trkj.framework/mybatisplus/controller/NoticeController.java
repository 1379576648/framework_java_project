package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.service.NoticeService;
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

    /**
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    @HystrixCommand(fallbackMethod = "selectNoticeAllHystrix")
    public Object selectNoticeAll(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectNoticeAll(notice));
        return  map1;
    }
    //备选方案
    public Object selectNoticeAllHystrix(@RequestBody Notice notice){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
    /**
     * 多选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    @HystrixCommand(fallbackMethod = "checkNoticeDeleteHystrix")
    public Object checkNoticeDelete(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.checkNoticeDelete(list));
        return map1;
    }

    //备选方案
    public Object checkNoticeDeleteHystrix(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

