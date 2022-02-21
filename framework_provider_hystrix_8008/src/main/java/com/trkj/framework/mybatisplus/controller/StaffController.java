package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.trkj.framework.util.Fuse8008Util;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private Fuse8008Util fuse8008Util;

    /**
     * 查询员工花名册
     *
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    @HystrixCommand(fallbackMethod = "selectStaffHystrix")
    public Map<String, Object> selectStaff(@RequestBody StaffVo staffVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.selectStaff(staffVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> selectStaffHystrix(@RequestBody StaffVo staffVo) {
        return fuse8008Util.main();
    }

    /**
     * 根据id查询员工信息
     *
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    @HystrixCommand(fallbackMethod = "selectStaffAllHystrix")
    public Map<String, Object> selectStaffAll(@RequestBody StaffVo staffVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", staffService.selectStaffAll(staffVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> selectStaffAllHystrix(@RequestBody StaffVo staffVo) {
        return fuse8008Util.main();
    }

    /**
     * 查询历史花名册
     *
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    @HystrixCommand(fallbackMethod = "selectQuitHystrix")
    public Map<String, Object> selectQuit(@RequestBody StaffQuitVo staffQuitVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.selectQuit(staffQuitVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> selectQuitHystrix(@RequestBody StaffQuitVo staffQuitVo) {
        return fuse8008Util.main();
    }


    /**
     * 修改员工信息
     *
     * @param staffId
     * @return
     */
    @PutMapping("/updateStaff")
    @HystrixCommand(fallbackMethod = "updateStaffHystrix")
    public Map<String, Object> updateStaff(@RequestBody Staff staffId) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.updateStaff(staffId));
        return map1;

    }

    //备选方案
    public Map<String, Object> updateStaffHystrix(@RequestBody Staff staffId) {
        return fuse8008Util.main();
    }

    /**
     * 修改员工信息2
     *
     * @param staffId
     * @return
     */
    @PutMapping("/updateStaffTwo")
    @HystrixCommand(fallbackMethod = "updateStaffTwoHystrix")
    public Map<String, Object> updateStaffTwo(@RequestBody Staff staffId) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.updateStaffTwo(staffId));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateStaffTwoHystrix(@RequestBody Staff staffId) {
        return fuse8008Util.main();
    }

    /**
     * 修改员工状态为正式
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffState")
    @HystrixCommand(fallbackMethod = "updateStaffStateHystrix")
    public Map<String, Object> updateStaffState(@RequestBody Staff staff) {
        staff.setStaffState(1L);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.updateStaffState(staff));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateStaffStateHystrix(@RequestBody Staff staff) {
        return fuse8008Util.main();
    }

    /**
     * 修改员工状态为离职
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffStateTwo")
    @HystrixCommand(fallbackMethod = "updateStaffStateTwoHystrix")
    public Map<String, Object> updateStaffStateTwo(@RequestBody Staff staff) {
        staff.setStaffState(2L);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.updateStaffState(staff));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateStaffStateTwoHystrix(@RequestBody Staff staff) {
        return fuse8008Util.main();
    }

    /**
     * 修改转正日期
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateWorkerDate")
    @HystrixCommand(fallbackMethod = "updateWorkerDateHystix")
    public Map<String, Object> updateWorkerDate(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.updateWorkerDate(staff));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateWorkerDateHystix(@RequestBody Staff staff) {
        return fuse8008Util.main();
    }

    /**
     * 快转正名单
     *
     * @param fullVo
     * @return
     */
    @PostMapping("/selectQuick")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> selectQuick(@RequestBody FullVo fullVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.selectQuick(fullVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet4(@RequestBody FullVo fullVo) {
        return fuse8008Util.main();
    }

    /**
     * 统计快转正名单
     *
     * @param
     * @return
     */
    @PostMapping("/countByStaffState")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String, Object> countByStaffState() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countByStaffState());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet5() {
        return fuse8008Util.main();
    }

    /**
     * 转正已生效
     *
     * @param fullVo
     * @return
     */
    @PostMapping("/selectStateOne")
    @HystrixCommand(fallbackMethod = "hystixGet6")
    public Map<String, Object> selectStateOne(@RequestBody FullVo fullVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.selectStateOne(fullVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet6(@RequestBody FullVo fullVo) {
        return fuse8008Util.main();
    }

    /**
     * 统计转正已生效
     *
     * @return
     */
    @PostMapping("/countStateOne")
    @HystrixCommand(fallbackMethod = "hystixGet7")
    public Map<String, Object> countStateOne() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateOne());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet7() {
        return fuse8008Util.main();
    }

    /**
     * 统计试用期人员
     *
     * @return
     */
    @PostMapping("/countStateTwo")
    @HystrixCommand(fallbackMethod = "hystixGet8")
    public Map<String, Object> countStateTwo() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateTwo());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet8() {
        return fuse8008Util.main();
    }

    /**
     * 本月离职
     *
     * @return
     */
    @PostMapping("/countStateThree")
    @HystrixCommand(fallbackMethod = "hystixGet9")
    public Map<String, Object> countStateThree() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateThree());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet9() {
        return fuse8008Util.main();
    }

    /**
     * 正式
     *
     * @return
     */
    @PostMapping("/countStateFour")
    @HystrixCommand(fallbackMethod = "hystixGet10")
    public Map<String, Object> countStateFour() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateFour());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet10() {
        return fuse8008Util.main();
    }

    /**
     * 试用
     *
     * @return
     */
    @PostMapping("/countStateFive")
    @HystrixCommand(fallbackMethod = "hystixGet11")
    public Map<String, Object> countStateFive() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateFive());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet11() {
        return fuse8008Util.main();
    }

    /**
     * 本月新入职
     *
     * @return
     */
    @PostMapping("/countStateSix")
    @HystrixCommand(fallbackMethod = "hystixGet12")
    public Map<String, Object> countStateSix() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", staffService.countStateSix());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet12() {
        return fuse8008Util.main();
    }


}

