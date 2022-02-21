package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
     * 查询所有员工除总裁
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


}
