package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class StaffController {
    @Autowired
    private HireClientService hireClientService = null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 查询员工花名册
     *
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    public AjaxResponse selectStaff(@RequestBody StaffVo staffVo) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectStaff(staffVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询员工信息
     *
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    public AjaxResponse selectStaffAll(@RequestBody StaffVo staffVo) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectStaffAll(staffVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询历史花名册
     *
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    public AjaxResponse selectQuit(@RequestBody StaffQuitVo staffQuitVo) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectQuit(staffQuitVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询调动
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    public AjaxResponse selectTransfer(@RequestBody TransferVo transferVo) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectTransfer(transferVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改员工信息
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaff")
    public AjaxResponse updateStaff(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.updateStaff(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改员工信息2
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffTwo")
    public AjaxResponse updateStaffTwo(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.updateStaffTwo(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有的员工名称
     *
     * @return
     */
    @PostMapping("/selectStaffName")
    public AjaxResponse selectStaffName() {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectStaffName();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有的部门名称
     *
     * @return
     */
    @PostMapping("/selectSect")
    public AjaxResponse selectSect() {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectSect();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询所有的职位名称
     *
     * @return
     */
    @PostMapping("/selectJob")
    public AjaxResponse selectJob() {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectJob();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据名称查询部门名称和职位名称
     *
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectTransferByName")
    public AjaxResponse selectTransferByName(@RequestBody TransferTwoVo transferTwoVo) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.selectTransferByName(transferTwoVo);
        return AjaxResponse.success(carryTokenUtil.main(map));

    }

    /**
     * 根据部门查询部门职位
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectPostName")
    public AjaxResponse selectPostName(@RequestBody TransferTwoVo transferTwoVo){
        Map<String, Object> map = hireClientService.selectPostName(transferTwoVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加工作经历
     *
     * @param workExperience
     * @return
     */
    @PostMapping("/insertWorkExperience")
    public AjaxResponse insertWorkExperience(@RequestBody WorkExperience workExperience) {
        Map<String,Object> map = (Map<String, Object>)hireClientService.insertWorkExperience(workExperience);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改工作经历
     *
     * @param workExperience
     * @return
     */
    @PutMapping("/updateWork")
    public AjaxResponse updateWork(@RequestBody WorkExperience workExperience) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.updateWork(workExperience);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除工作经历
     *
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWork")
    public AjaxResponse deleteWork(@RequestBody ArrayList<Integer> list) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.deleteWork(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加奖励
     *
     * @param glory
     * @return
     */
    @PostMapping("/insertGlory")
    public AjaxResponse insertGlory(@RequestBody Glory glory) {
        Map<String,Object> map = (Map<String, Object>) hireClientService.insertGlory(glory);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改奖励
     *
     * @param glory
     * @return
     */
    @PutMapping("/updateGlory")
    public AjaxResponse updateGlory(@RequestBody Glory glory) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateGlory(glory);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除奖励
     *
     * @param list
     * @return
     */
    @DeleteMapping("/deleteGlory")
    public AjaxResponse deleteGlory(@RequestBody ArrayList<Integer> list) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.deleteGlory(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加惩罚
     *
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    public AjaxResponse insertPunish(@RequestBody Punish punish) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.insertPunish(punish);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改惩罚
     *
     * @param punish
     * @return
     */
    @PutMapping("/updatePunish")
    public AjaxResponse updatePunish(@RequestBody Punish punish) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.updatePunish(punish);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除惩罚
     *
     * @param list
     * @return
     */
    @DeleteMapping("/deletePunish")
    public AjaxResponse deletePunish(@RequestBody ArrayList<Integer> list) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.deletePunish(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加教育经历
     *
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    public AjaxResponse insertEducation(@RequestBody Education education) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.insertEducation(education);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改惩罚
     *
     * @param education
     * @return
     */
    @PutMapping("/updateEducation")
    public AjaxResponse updateEducation(@RequestBody Education education) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateEducation(education);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除教育经历
     *
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    public AjaxResponse deleteEducation(@RequestBody ArrayList<Integer> list) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.deleteEducation(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工姓名查询调动记录
     *
     * @param transfer
     * @return
     */
    @PostMapping("/selectTransferAlls")
    public AjaxResponse selectTransferAlls(@RequestBody Transfer transfer) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.selectTransferAlls(transfer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调动记录
     *
     * @param transfer
     * @return
     */
    @PostMapping("/insertTransfer")
    public AjaxResponse insertTransfer(@RequestBody Transfer transfer) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.insertTransfer(transfer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改调动后的部门
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateDeptName")
    public AjaxResponse updateDeptName(@RequestBody Staff staff) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateDeptName(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询奖励和惩罚
     *
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    public AjaxResponse selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.selectPunishGlory(punishGloryVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加转正
     *
     * @param fullVo
     * @return
     */
    @PostMapping("/insertWorker")
    public AjaxResponse insertWorker(@RequestBody FullVo fullVo) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.insertWorker(fullVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改员工状态为正式
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffState")
    public AjaxResponse updateStaffState(@RequestBody Staff staff) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateStaffState(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加离职
     *
     * @param quit
     * @return
     */
    @PostMapping("/insertQuit")
    public AjaxResponse insertQuit(@RequestBody Quit quit) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.insertQuit(quit);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改员工状态为离职
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffStateTwo")
    public AjaxResponse updateStaffStateTwo(@RequestBody Staff staff) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateStaffStateTwo(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改转正日期
     *
     * @param staff
     * @return
     */
    @PutMapping("/updateWorkerDate")
    public AjaxResponse updateWorkerDate(@RequestBody Staff staff) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.updateWorkerDate(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 快转正名单
     *
     * @param fullVo
     * @return
     */
    @PostMapping("/selectQuick")
    public AjaxResponse selectQuick(@RequestBody FullVo fullVo) {
        Map<String,Object> map = (Map<String, Object>) hireClientService.selectQuick(fullVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计快要转正的名单
     *
     * @return
     */
    @PostMapping("/countByStaffState")
    public AjaxResponse countByStaffState() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countByStaffState();
        return AjaxResponse.success(carryTokenUtil.main(map));}

    /**
     * 转正已生效
     *
     * @param fullVo
     * @return
     */
    @PostMapping("/selectStateOne")
    public AjaxResponse selectStateOne(@RequestBody FullVo fullVo) {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.selectStateOne(fullVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计转正已生效
     *
     * @return
     */
    @PostMapping("/countStateOne")
    public AjaxResponse countStateOne() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateOne();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计试用期人员
     *
     * @return
     */
    @PostMapping("/countStateTwo")
    public AjaxResponse countStateTwo() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateTwo();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 本月离职
     *
     * @return
     */
    @PostMapping("/countStateThree")
    public AjaxResponse countStateThree() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateThree();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 正式
     *
     * @return
     */
    @PostMapping("/countStateFour")
    public AjaxResponse countStateFour() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateFour();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 试用
     *
     * @return
     */
    @PostMapping("/countStateFive")
    public AjaxResponse countStateFive() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateFive();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 本月新入职
     *
     * @return
     */
    @PostMapping("/countStateSix")
    public AjaxResponse countStateSix() {
        Map<String,Object> map = (Map<String, Object>)  hireClientService.countStateSix();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
