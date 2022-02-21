package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 考勤月统计 前端控制器
 *
 * @author 112729
 */
@RestController
public class MonthStatisticsController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 查询所有员工除总裁
     * @param
     * @return
     */
    @PostMapping("/selectStaffNameAll")
    public AjaxResponse selectStaffNameAll(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectStaffNameAll(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
