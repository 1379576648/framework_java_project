package com.trkj.framework.service.client.hire;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.HireClientServiceFallbackfactory;
import com.trkj.framework.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8008/provider", fallbackFactory = HireClientServiceFallbackfactory.class)
public interface HireClientService {

    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping ("/selectpage")
    Object selecthirepage(@RequestBody HireVo hireVo);

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectabandon")
    Object selectabandon(@RequestBody HireVo hireVo);

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    Object selectwork(@RequestBody WorkVo workVo);

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    @PostMapping("/selectpost")
    Object selectpost(@RequestBody FullVo fullVo);

    /**
     * 新增员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    Object insertStaff(@RequestBody HireVo hireVo);

    /**
     * 修改录用状态
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentState")
    Object updateEmploymentState(@RequestBody EmploymentTable employmentTable);

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentStateAndWaiveReasonInt")
    Object updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentTable);

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    Object selectStaff(@RequestBody StaffVo staffVo);

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    Object selectStaffAll(@RequestBody StaffVo staffVo);

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    Object selectQuit(@RequestBody StaffQuitVo staffQuitVo);

    /**
     * 查询调动
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    Object selectTransfer(@RequestBody TransferVo transferVo);

    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    @PutMapping("/updateStaff")
    Object updateStaff(@RequestBody Staff staff);

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffTwo")
    Object updateStaffTwo(@RequestBody Staff staff);

    /**
     * 查询所有的员工名称
     * @return
     */
     @PostMapping("/selectStaffName")
    Object selectStaffName();

    /**
     * 查询所有的部门名称
     * @return
     */
    @PostMapping("/selectSect")
    Object selectSect();

    /**
     * 查询所有的职位名称
     * @return
     */
    @PostMapping("/selectJob")
    Object selectJob();

    /**
     * 根据名称查询部门名称和职位名称
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectTransferByName")
    Object selectTransferByName(@RequestBody TransferTwoVo transferTwoVo);

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    Object selectWorkAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryAll")
    Object selectGloryAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishAll")
    Object selectPunishAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationAll")
    Object selectEducationAll(@RequestBody WorkVo workVo);

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    @PostMapping("/insertWorkExperience")
    Object insertWorkExperience(@RequestBody WorkExperience workExperience);

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkOne")
    Object selectWorkOne(@RequestBody WorkVo workVo);

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
    @PutMapping("/updateWork")
    Object updateWork(@RequestBody WorkExperience workExperience);

    /**
     * 删除工作经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWork")
    Object deleteWork(@RequestBody ArrayList<Integer> list);

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryOne")
    Object selectGloryOne(@RequestBody WorkVo workVo);

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    @PostMapping("/insertGlory")
    Object insertGlory(@RequestBody Glory glory);

    /**
     * 修改奖励
     * @param glory
     * @return
     */
    @PutMapping("/updateGlory")
    Object updateGlory(@RequestBody Glory glory);

    /**
     * 删除奖励
     * @param list
     * @return
     */
    @DeleteMapping("/deleteGlory")
    Object deleteGlory(@RequestBody ArrayList<Integer> list);

    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishOne")
    Object selectPunishOne(@RequestBody WorkVo workVo);

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    Object insertPunish(@RequestBody Punish punish);

    /**
     * 修改惩罚
     * @param punish
     * @return
     */
    @PutMapping("/updatePunish")
    Object updatePunish(@RequestBody Punish punish);

    /**
     * 删除惩罚
     * @param list
     * @return
     */
    @DeleteMapping("/deletePunish")
    Object deletePunish(@RequestBody ArrayList<Integer> list);

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationOne")
    Object selectEducationOne(@RequestBody WorkVo workVo);

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    Object insertEducation(@RequestBody Education education);

    /**
     * 修改教育经历
     * @param education
     * @return
     */
    @PutMapping("/updateEducation")
    Object updateEducation(@RequestBody Education education);

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    Object deleteEducation(@RequestBody ArrayList<Integer> list);

    /**
     * 根据员工姓名查询调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/selectTransferAlls")
    Object selectTransferAlls(@RequestBody Transfer transfer);

    /**
     * 添加调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/insertTransfer")
    Object insertTransfer(@RequestBody Transfer transfer);

    /**
     * 修改调动后的部门
     * @param dept
     * @return
     */
    @PutMapping("/updateDeptName")
    Object updateDeptName(@RequestBody Dept dept);

    /**
     * 修改调动后的职位
     * @param deptPost
     * @return
     */
    @PutMapping("/updateDeptPostName")
    Object updateDeptPostName(@RequestBody DeptPost deptPost);

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    Object selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo);

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    @PostMapping("/insertWorker")
    Object insertWorker(@RequestBody FullVo fullVo);

    /**
     * 修改员工状态为正式
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffState")
    Object updateStaffState(@RequestBody Staff staff);

    /**
     * 添加离职
     * @param quit
     * @return
     */
    @PostMapping("/insertQuit")
    Object insertQuit(@RequestBody Quit quit);

    /**
     * 修改员工状态为离职
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffStateTwo")
    Object updateStaffStateTwo(@RequestBody Staff staff);

    /**
     * 修改转正日期
     * @param staff
     * @return
     */
    @PutMapping("/updateWorkerDate")
    Object updateWorkerDate(@RequestBody Staff staff);

    /**
     * 快转正名单
     * @param fullVo
     * @return
     */
    @PostMapping("/selectQuick")
    Object selectQuick(@RequestBody FullVo fullVo);

    /**
     * 统计快要转正名单
     * @return
     */
    @PostMapping("/countByStaffState")
    Object countByStaffState();

    /**
     * 转正已生效
     * @param fullVo
     * @return
     */
    @PostMapping("/selectStateOne")
    Object selectStateOne(@RequestBody FullVo fullVo);

    /**
     * 统计转正已生效
     * @return
     */
    @PostMapping("/countStateOne")
    Object countStateOne();

    /**
     * 统计试用期人员
     * @return
     */
    @PostMapping("/countStateTwo")
    Object countStateTwo();
}

