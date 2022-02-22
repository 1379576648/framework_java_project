package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Archive;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.MonthStatisticsService;
import com.trkj.framework.util.Fuse8004Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 考勤月统计 前端控制器
 *
 * @author 112729
 */
@RestController
public class MonthStatisticsController {

    @Autowired
    private MonthStatisticsService monthStatisticsService;
    @Autowired
    private Fuse8004Util fuse8004Util;

    /**
     * 查询所有员工的考勤状态次数
     *
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffNameAll")
    @HystrixCommand(fallbackMethod = "selectStaffNameAllHystixGet")
    public Map<String, Object> selectStaffNameAll(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", monthStatisticsService.selectStaffNameAll(staff));
        return map1;
    }

    public Map<String, Object> selectStaffNameAllHystixGet(@RequestBody Staff staff) {
        return fuse8004Util.main();
    }

    /**
     * 添加归档表
     *
     * @param staff
     * @return
     */
    @PostMapping("/archivedData")
    @HystrixCommand(fallbackMethod = "archivedDataHystixGet")
    public Map<String, Object> archivedData(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", monthStatisticsService.archivedData(staff));
        return map1;
    }

    public Map<String, Object> archivedDataHystixGet(@RequestBody Staff staff) {
        return fuse8004Util.main();
    }

    /**
     * 查询所有考勤归档
     * @param archive
     * @return
     */
    @PostMapping("/selectArchiveAll")
    @HystrixCommand(fallbackMethod = "selectArchiveAllHystixGet")
    public Map<String, Object> selectArchiveAll(@RequestBody Archive archive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", monthStatisticsService.selectArchiveAll(archive));
        return map1;
    }

    public Map<String, Object> selectArchiveAllHystixGet(@RequestBody Archive archive) {
        return fuse8004Util.main();
    }

    /**
     * 根据名称查询考勤归档
     * @param archive
     * @return
     */
    @PostMapping("/selectArchiveByName")
    public Map<String, Object> selectArchiveByName(@RequestBody Archive archive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", monthStatisticsService.selectArchiveByName(archive));
        return map1;
    }

    /**
     * 根据名称查询考勤归档分页
     * @param archive
     * @return
     */
    @PostMapping("/selectArchiveByNameAndIPage")
    public Map<String, Object> selectArchiveByNameAndIPage(@RequestBody Archive archive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", monthStatisticsService.selectArchiveByNameAndIPage(archive));
        return map1;
    }
}
