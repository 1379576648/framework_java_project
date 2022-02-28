package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class OverTimeController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据员工名称查询加班记录
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    @ApiOperation(value = "根据员工名称查询加班记录", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectOverTimeRecordAll")
    public AjaxResponse selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectOverTimeRecordAll(overtimeask);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除加班记录
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/deleteOverTime")
    @ApiOperation(value = "删除加班记录", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteOverTime")
    public AjaxResponse deleteOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteOverTime(overtimeask);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 开始加班
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/updateBeginOverTime")
    @ApiOperation(value = "开始加班", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateBeginOverTime")
    public AjaxResponse updateBeginOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateBeginOverTime(overtimeask);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 结束加班
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/updateEndOverTime")
    @ApiOperation(value = "结束加班", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateEndOverTime")
    public AjaxResponse updateEndOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateEndOverTime(overtimeask);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

}
