package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OverTimeController {
    @Autowired
    private CheckingService checkingService;

    /**
     * 根据员工名称查询加班记录
     * @param overtimeask
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    public AjaxResponse selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask) {
        return AjaxResponse.success(checkingService.selectOverTimeRecordAll(overtimeask));
    }

    /**
     * 删除打卡记录
     * @param overtimeask
     * @return
     */
    @PostMapping("/deleteOverTime")
    public AjaxResponse deleteOverTime(@RequestBody Overtimeask overtimeask) {
        return AjaxResponse.success(checkingService.deleteOverTime(overtimeask));
    }
}
