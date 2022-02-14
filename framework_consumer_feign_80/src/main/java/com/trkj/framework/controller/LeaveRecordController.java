package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 112729
 */
@RestController
public class LeaveRecordController {
    @Autowired
    private CheckingService checkingService;

    /**
     * 根据员工名称查询请假记录
     * @param leave
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    public AjaxResponse selectLeaveRecordAll(@RequestBody Leave leave) {
        return AjaxResponse.success(checkingService.selectLeaveRecordAll(leave));
    }

    /**
     * 删除请假记录
     * @param leave
     * @return
     */
    @PostMapping("/deleteLeave")
    public AjaxResponse deleteLeave(@RequestBody Leave leave) {
        return AjaxResponse.success(checkingService.deleteLeave(leave));
    }

    /**
     * 开始加班
     * @param leave
     * @return
     */
    @PostMapping("/updateBeginLeave")
    public AjaxResponse updateBeginOverTime(@RequestBody Leave leave) {
        return AjaxResponse.success(checkingService.updateBeginLeave(leave));
    }

    /**
     * 结束加班
     * @param leave
     * @return
     */
    @PostMapping("/updateEndLeave")
    public AjaxResponse updateEndLeave(@RequestBody Leave leave) {
        return AjaxResponse.success(checkingService.updateEndLeave(leave));
    }
}
