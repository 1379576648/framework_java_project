package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 112729
 */
@RestController
public class LeaveRecordController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据员工名称查询请假记录
     *
     * @param leave
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    @ApiOperation(value = "根据员工名称查询请假记录", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectLeaveRecordAll")
    public AjaxResponse selectLeaveRecordAll(@RequestBody Leave leave) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectLeaveRecordAll(leave);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除请假记录
     *
     * @param leave
     * @return
     */
    @PostMapping("/deleteLeave")
    @ApiOperation(value = "删除请假记录", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteLeave")
    public AjaxResponse deleteLeave(@RequestBody Leave leave) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteLeave(leave);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 开始加班
     *
     * @param leave
     * @return
     */
    @PostMapping("/updateBeginLeave")
    @ApiOperation(value = "开始加班", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateBeginLeave")
    public AjaxResponse updateBeginOverTime(@RequestBody Leave leave) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateBeginLeave(leave);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 结束加班
     *
     * @param leave
     * @return
     */
    @PostMapping("/updateEndLeave")
    @ApiOperation(value = "结束加班", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateEndLeave")
    public AjaxResponse updateEndLeave(@RequestBody Leave leave) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateEndLeave(leave);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
