package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Travel;
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
public class EvectionRecordController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据员工名称查询出差记录
     *
     * @param travel
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    @ApiOperation(value = "根据员工名称查询出差记录", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectEvectionRecordAll")
    public AjaxResponse selectEvectionRecordAll(@RequestBody Travel travel) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectEvectionRecordAll(travel);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除出差记录
     *
     * @param travel
     * @return
     */
    @PostMapping("/deleteEvection")
    @ApiOperation(value = "删除出差记录", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteEvection")
    public AjaxResponse deleteEvection(@RequestBody Travel travel) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteEvection(travel);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 开始出差
     *
     * @param travel
     * @return
     */
    @PostMapping("/updateBeginTravel")
    @ApiOperation(value = "开始出差", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateBeginTravel")
    public AjaxResponse updateBeginOverTime(@RequestBody Travel travel) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateBeginTravel(travel);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 结束出差
     *
     * @param travel
     * @return
     */
    @PostMapping("/updateEndTravel")
    @ApiOperation(value = "结束出差", notes = "考勤模块", httpMethod = "POST", nickname = "修改", produces = "/updateEndTravel")
    public AjaxResponse updateEndLeave(@RequestBody Travel travel) {
        Map<String, Object> map = (Map<String, Object>) checkingService.updateEndTravel(travel);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
