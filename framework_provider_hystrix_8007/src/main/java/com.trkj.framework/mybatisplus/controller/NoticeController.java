package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.service.NoticeService;
import io.swagger.models.auth.In;
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

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/selectDeptList")
    @HystrixCommand(fallbackMethod = "selectDeptListHystrix")
    public  Object selectDeptList(){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectDeptList());
        return map1;
    }
    //备选
    public  Object selectDeptListHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    @HystrixCommand(fallbackMethod = "insertNoticeHystrix")
    public Object insertNotice(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.insertNotice(notice));
        return map1;
    }
    //备选方案
    public Object insertNoticeHystrix(@RequestBody Notice notice){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     *查询当前公告绑定的部门
     * @param id
     * @return
     */
    @GetMapping("/selectPossessDeptList")
    @HystrixCommand(fallbackMethod = "selectPossessDeptListHystrix")
    public Object selectPossessDeptList(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectPossessDeptList(id));
        return map1;
    }
    //备选方案
    public Object selectPossessDeptListHystrix(@RequestParam("id") Integer id){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/updateNotice")
    @HystrixCommand(fallbackMethod = "updateNoticeHystrix")
    public Object updateNotice(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.updateNotice(notice));
        return map1;
    }
    //备选方案
    public Object updateNoticeHystrix(@RequestBody Notice notice){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 已看公告人员
     * @param id
     * @return
     */
    @GetMapping("/peropleNoticeViewed")
    @HystrixCommand(fallbackMethod = "peropleNoticeViewedHystrix")
    public Object peropleNoticeViewed(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.peropleNoticeViewed(id));
        return map1;
    }
    //备选方案
    public Object peropleNoticeViewedHystrix(@RequestParam("id") Integer id){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
    /***
     * 未看公告人员
     * @param id
     * @return
     */
    @GetMapping("/unseenNoticePerson")
    @HystrixCommand(fallbackMethod = "unseenNoticePersonHystrix")
    public Object unseenNoticePerson(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.unseenNoticePerson(id));
        return map1;
    }
    //备选方案
    public Object unseenNoticePersonHystrix(@RequestParam("id") Integer id){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}

