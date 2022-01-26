package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StaffController {
    @Autowired
    private HireClientService hireClientService = null;

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    public AjaxResponse selectStaff(@RequestBody StaffVo staffVo){
        return AjaxResponse.success(hireClientService.selectStaff(staffVo));
    }

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    public AjaxResponse selectStaffAll(@RequestBody StaffVo staffVo){
        return AjaxResponse.success(hireClientService.selectStaffAll(staffVo));
    }

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    public AjaxResponse selectQuit(@RequestBody StaffQuitVo staffQuitVo){
        return AjaxResponse.success(hireClientService.selectQuit(staffQuitVo));
    }

    /**
     * 查询调动
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    public AjaxResponse selectTransfer(@RequestBody TransferVo transferVo){
        return AjaxResponse.success(hireClientService.selectTransfer(transferVo));
    }

    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    @PutMapping("/updateStaff")
    public AjaxResponse updateStaff(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaff(staff));
    }

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffTwo")
    public AjaxResponse updateStaffTwo(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaffTwo(staff));
    }

    /**
     * 查询所有的员工名称
     * @return
     */
     @PostMapping("/selectStaffName")
    public AjaxResponse selectStaffName(){
        return AjaxResponse.success(hireClientService.selectStaffName());
     }

    /**
     * 查询所有的部门名称
     * @return
     */
     @PostMapping("/selectSect")
    public AjaxResponse selectSect(){
         return AjaxResponse.success(hireClientService.selectSect());
     }

    /**
     * 查询所有的职位名称
     * @return
     */
    @PostMapping("/selectJob")
    public AjaxResponse selectJob(){
         return AjaxResponse.success(hireClientService.selectJob());
     }

    /**
     * 根据名称查询部门名称和职位名称
     * @param transferTwoVo
     * @return
     */
     @PostMapping("/selectTransferByName")
    public AjaxResponse selectTransferByName(@RequestBody TransferTwoVo transferTwoVo){
        return AjaxResponse.success(hireClientService.selectTransferByName(transferTwoVo));

     }

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
     @PostMapping("/insertWorkExperience")
    public AjaxResponse insertWorkExperience(@RequestBody WorkExperience workExperience){
         return AjaxResponse.success(hireClientService.insertWorkExperience(workExperience));
     }

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
     @PutMapping("/updateWork")
    public AjaxResponse updateWork(@RequestBody WorkExperience workExperience){
         return AjaxResponse.success(hireClientService.updateWork(workExperience));
     }

    /**
     * 删除工作经历
     * @param list
     * @return
     */
     @DeleteMapping("/deleteWork")
    public AjaxResponse deleteWork(@RequestBody ArrayList<Integer> list){
         return AjaxResponse.success(hireClientService.deleteWork(list));
     }

    /**
     * 添加奖励
     * @param glory
     * @return
     */
     @PostMapping("/insertGlory")
    public AjaxResponse insertGlory(@RequestBody Glory glory){
         return AjaxResponse.success(hireClientService.insertGlory(glory));
     }

    /**
     * 修改奖励
     * @param glory
     * @return
     */
     @PutMapping("/updateGlory")
    public AjaxResponse updateGlory(@RequestBody Glory glory){
         return AjaxResponse.success(hireClientService.updateGlory(glory));
     }

    /**
     * 删除奖励
     * @param list
     * @return
     */
     @DeleteMapping("/deleteGlory")
    public AjaxResponse deleteGlory(@RequestBody ArrayList<Integer> list){
         return AjaxResponse.success(hireClientService.deleteGlory(list));
     }

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    public AjaxResponse insertPunish(@RequestBody Punish punish){
        return AjaxResponse.success(hireClientService.insertPunish(punish));
    }

    /**
     * 修改惩罚
     * @param punish
     * @return
     */
    @PutMapping("/updatePunish")
    public AjaxResponse updatePunish(@RequestBody Punish punish){
        return AjaxResponse.success(hireClientService.updatePunish(punish));
    }

    /**
     * 删除惩罚
     * @param list
     * @return
     */
        @DeleteMapping("/deletePunish")
    public AjaxResponse deletePunish(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(hireClientService.deletePunish(list));
    }

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    public AjaxResponse insertEducation(@RequestBody Education education){
        return AjaxResponse.success(hireClientService.insertEducation(education));
    }

    /**
     * 修改惩罚
     * @param education
     * @return
     */
    @PutMapping("/updateEducation")
    public AjaxResponse updateEducation(@RequestBody Education education){
        return AjaxResponse.success(hireClientService.updateEducation(education));
    }

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    public AjaxResponse deleteEducation(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(hireClientService.deleteEducation(list));
    }

    /**
     * 根据员工姓名查询调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/selectTransferAlls")
    public AjaxResponse selectTransferAlls(@RequestBody Transfer transfer){
        return AjaxResponse.success(hireClientService.selectTransferAlls(transfer));
    }

    /**
     * 添加调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/insertTransfer")
    public AjaxResponse insertTransfer(@RequestBody Transfer transfer){
        return AjaxResponse.success(hireClientService.insertTransfer(transfer));
    }

    /**
     * 修改调动后的部门
     * @param dept
     * @return
     */
    @PutMapping("/updateDeptName")
    public AjaxResponse updateDeptName(@RequestBody Dept dept){
        return AjaxResponse.success(hireClientService.updateDeptName(dept));
    }

    /**
     * 修改调动后的职位
     * @param deptPost
     * @return
     */
    @PutMapping("/updateDeptPostName")
    public AjaxResponse updateDeptPostName(@RequestBody DeptPost deptPost){
        return AjaxResponse.success(hireClientService.updateDeptPostName(deptPost));
    }

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    public AjaxResponse selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo){
        return AjaxResponse.success(hireClientService.selectPunishGlory(punishGloryVo));
    }

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    @PostMapping("/insertWorker")
    public AjaxResponse insertWorker(@RequestBody FullVo fullVo){
        return AjaxResponse.success(hireClientService.insertWorker(fullVo));
    }

    /**
     * 修改员工状态为正式
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffState")
    public AjaxResponse updateStaffState(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaffState(staff));
    }

    /**
     * 添加离职
     * @param quit
     * @return
     */
    @PostMapping("/insertQuit")
    public AjaxResponse insertQuit(@RequestBody Quit quit){
        return AjaxResponse.success(hireClientService.insertQuit(quit));
    }

    /**
     * 修改员工状态为离职
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffStateTwo")
    public AjaxResponse updateStaffStateTwo(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaffStateTwo(staff));
    }

    /**
     * 修改转正日期
     * @param staff
     * @return
     */
    @PutMapping("/updateWorkerDate")
    public AjaxResponse updateWorkerDate(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateWorkerDate(staff));
    }

    /**
     * 快转正名单
     * @param fullVo
     * @return
     */
    @PostMapping("/selectQuick")
    public AjaxResponse selectQuick(@RequestBody FullVo fullVo){
        return AjaxResponse.success(hireClientService.selectQuick(fullVo));
    }

    /**
     * 统计快要转正的名单
     * @return
     */
    @PostMapping("/countByStaffState")
    public AjaxResponse countByStaffState(){
        return AjaxResponse.success(hireClientService.countByStaffState());
    }

    /**
     * 转正已生效
     * @param fullVo
     * @return
     */
    @PostMapping("/selectStateOne")
    public AjaxResponse selectStateOne(@RequestBody FullVo fullVo){
        return AjaxResponse.success(hireClientService.selectStateOne(fullVo));
    }

    /**
     * 统计转正已生效
     * @return
     */
    @PostMapping("/countStateOne")
    public AjaxResponse countStateOne(){
        return AjaxResponse.success(hireClientService.countStateOne());
    }

    /**
     * 统计试用期人员
     * @return
     */
    @PostMapping("/countStateTwo")
    public AjaxResponse countStateTwo(){
        return AjaxResponse.success(hireClientService.countStateTwo());
    }
}
