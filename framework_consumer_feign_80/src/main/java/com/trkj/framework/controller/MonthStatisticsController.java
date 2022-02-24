package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.Archive;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Dept;
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

    /**
     * 添加归档表
     * @param
     * @return
     */
    @PostMapping("/archivedData")
    public AjaxResponse archivedData(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.archivedData(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有所有考勤归档数据
     * @param
     * @return
     */
    @PostMapping("/selectArchiveAll")
    public AjaxResponse selectArchiveAll(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveAll(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据
     * @param
     * @return
     */
    @PostMapping("/selectArchiveByName")
    public AjaxResponse selectArchiveByName(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveByName(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据分页
     * @param
     * @return
     */
    @PostMapping("/selectArchiveByNameAndIPage")
    public AjaxResponse selectArchiveByNameAndIPage(@RequestBody Archive archive) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectArchiveByNameAndIPage(archive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询考勤归档数据分页
     * @param
     * @return
     */
    @PostMapping("/selcetAttendanceRecord")
    public AjaxResponse selcetAttendanceRecord(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selcetAttendanceRecord(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有部门
     * @param
     * @return
     */
    @PostMapping("/selectDeptAll")
    public AjaxResponse selectDeptAll() {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectDeptAll();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
