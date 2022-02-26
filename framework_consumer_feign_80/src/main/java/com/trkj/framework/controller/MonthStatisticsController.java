package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.Archive;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
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
     *
     * @param
     * @return
     */
    @PostMapping("/selectStaffNameAll")
    @ApiOperation(value = "查询所有员工除总裁", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectStaffNameAll")
    public AjaxResponse selectStaffNameAll(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectStaffNameAll(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加归档表
     *
     * @param
     * @return
     */
    @PostMapping("/archivedData")
    @ApiOperation(value = "添加归档表", notes = "考勤模块", httpMethod = "POST", nickname = "添加", produces = "/archivedData")
    public AjaxResponse archivedData(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.archivedData(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有所有考勤归档数据
     *
     * @param
     * @return
     */
    @PostMapping("/selectArchiveAll")
    @ApiOperation(value = "查询所有所有考勤归档数据", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectArchiveAll")
    public AjaxResponse selectArchiveAll(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveAll(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据
     *
     * @param
     * @return
     */
    @PostMapping("/selectArchiveByName")
    @ApiOperation(value = "根据名称查询考勤归档数据", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectArchiveByName")
    public AjaxResponse selectArchiveByName(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveByName(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据分页
     *
     * @param
     * @return
     */
    @PostMapping("/selectArchiveByNameAndIPage")
    @ApiOperation(value = "根据名称查询考勤归档数据分页", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectArchiveByNameAndIPage")
    public AjaxResponse selectArchiveByNameAndIPage(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveByNameAndIPage(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据分页
     *
     * @param
     * @return
     */
    @PostMapping("/selcetAttendanceRecord")
    @ApiOperation(value = "根据名称查询考勤归档数据分页", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selcetAttendanceRecord")

    public AjaxResponse selcetAttendanceRecord(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selcetAttendanceRecord(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有部门
     *
     * @param
     * @return
     */
    @PostMapping("/selectDeptAll")
    @ApiOperation(value = "查询所有部门", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectDeptAll")
    public AjaxResponse selectDeptAll() {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectDeptAll();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
