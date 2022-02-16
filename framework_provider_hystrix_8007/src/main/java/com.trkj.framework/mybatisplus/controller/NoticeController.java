package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.mybatisplus.service.NoticeService;
import com.trkj.framework.util.Fuse8007Util;
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
    private Fuse8007Util fuse8007Util;

    /**
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    @HystrixCommand(fallbackMethod = "selectNoticeAllHystrix")
    public Map<String,Object> selectNoticeAll(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectNoticeAll(notice));
        return  map1;
    }
    //备选方案
    public Map<String,Object> selectNoticeAllHystrix(@RequestBody Notice notice){
        return fuse8007Util.main();
    }
    /**
     * 多选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    @HystrixCommand(fallbackMethod = "checkNoticeDeleteHystrix")
    public Map<String,Object> checkNoticeDelete(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        try{
            map1.put("info",noticeService.checkNoticeDelete(list));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> checkNoticeDeleteHystrix(@RequestBody ArrayList<Integer> list){
        return fuse8007Util.main();
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
        return fuse8007Util.main();
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    @HystrixCommand(fallbackMethod = "insertNoticeHystrix")
    public Map<String,Object> insertNotice(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        try {
            map1.put("info",noticeService.insertNotice(notice));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }

        return map1;
    }
    //备选方案
    public Map<String,Object> insertNoticeHystrix(@RequestBody Notice notice){
        return fuse8007Util.main();
    }

    /***
     *查询当前公告绑定的部门
     * @param id
     * @return
     */
    @GetMapping("/selectPossessDeptList")
    @HystrixCommand(fallbackMethod = "selectPossessDeptListHystrix")
    public Map<String,Object> selectPossessDeptList(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.selectPossessDeptList(id));
        return map1;
    }
    //备选方案
    public Map<String,Object> selectPossessDeptListHystrix(@RequestParam("id") Integer id){
        return fuse8007Util.main();
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/updateNotice")
    @HystrixCommand(fallbackMethod = "updateNoticeHystrix")
    public Map<String,Object> updateNotice(@RequestBody Notice notice){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        try {
            map1.put("info",noticeService.updateNotice(notice));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }
        return map1;
    }
    //备选方案
    public Map<String,Object> updateNoticeHystrix(@RequestBody Notice notice){
        return fuse8007Util.main();
    }

    /***
     * 已看公告人员
     * @param id
     * @return
     */
    @GetMapping("/peropleNoticeViewed")
    @HystrixCommand(fallbackMethod = "peropleNoticeViewedHystrix")
    public Map<String,Object> peropleNoticeViewed(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.peropleNoticeViewed(id));
        return map1;
    }
    //备选方案
    public Map<String,Object> peropleNoticeViewedHystrix(@RequestParam("id") Integer id){
        return fuse8007Util.main();
    }
    /***
     * 未看公告人员
     * @param id
     * @return
     */
    @GetMapping("/unseenNoticePerson")
    @HystrixCommand(fallbackMethod = "unseenNoticePersonHystrix")
    public Map<String,Object> unseenNoticePerson(@RequestParam("id") Integer id){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",noticeService.unseenNoticePerson(id));
        return map1;
    }
    //备选方案
    public Map<String,Object> unseenNoticePersonHystrix(@RequestParam("id") Integer id){
        return fuse8007Util.main();
    }
}

