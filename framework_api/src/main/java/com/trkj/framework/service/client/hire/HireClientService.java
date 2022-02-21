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
import java.util.Map;

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
    Map<String,Object> selecthirepage(@RequestBody HireVo hireVo);

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectabandon")
    Map<String,Object> selectabandon(@RequestBody HireVo hireVo);

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    Map<String,Object> selectwork(@RequestBody WorkVo workVo);

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    @PostMapping("/selectpost")
    Map<String,Object> selectpost(@RequestBody FullVo fullVo);

    /**
     * 新增员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    Map<String,Object> insertStaff(@RequestBody HireVo hireVo);

    /**
     * 修改录用状态
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentState")
    Map<String,Object> updateEmploymentState(@RequestBody EmploymentTable employmentTable);

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentStateAndWaiveReasonInt")
    Map<String,Object> updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentTable);

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    Map<String,Object> selectStaff(@RequestBody StaffVo staffVo);

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    Map<String,Object> selectStaffAll(@RequestBody StaffVo staffVo);

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    Map<String,Object> selectQuit(@RequestBody StaffQuitVo staffQuitVo);

    /**
     * 查询调动
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    Map<String,Object> selectTransfer(@RequestBody TransferVo transferVo);

    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    @PutMapping("/updateStaff")
    Map<String,Object> updateStaff(@RequestBody Staff staff);

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffTwo")
    Map<String,Object> updateStaffTwo(@RequestBody Staff staff);

    /**
     * 查询所有的员工名称
     * @return
     */
     @PostMapping("/selectStaffName")
    Map<String,Object> selectStaffName();

    /**
     * 查询所有的部门名称
     * @return
     */
    @PostMapping("/selectSect")
    Map<String,Object> selectSect();

    /**
     * 查询所有的职位名称
     * @return
     */
    @PostMapping("/selectJob")
    Map<String,Object> selectJob();

    /**
     * 根据名称查询部门名称和职位名称
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectTransferByName")
    Map<String,Object> selectTransferByName(@RequestBody TransferTwoVo transferTwoVo);

    /**
     * 根据部门查询部门职位
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectPostName")
    Map<String, Object> selectPostName(@RequestBody TransferTwoVo transferTwoVo);

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    Map<String,Object> selectWorkAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryAll")
    Map<String,Object> selectGloryAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishAll")
    Map<String,Object> selectPunishAll(@RequestBody WorkVo workVo);

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationAll")
    Map<String,Object> selectEducationAll(@RequestBody WorkVo workVo);

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    @PostMapping("/insertWorkExperience")
    Map<String,Object> insertWorkExperience(@RequestBody WorkExperience workExperience);

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkOne")
    Map<String,Object> selectWorkOne(@RequestBody WorkVo workVo);

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
    @PutMapping("/updateWork")
    Map<String,Object> updateWork(@RequestBody WorkExperience workExperience);

    /**
     * 删除工作经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWork")
    Map<String,Object> deleteWork(@RequestBody ArrayList<Integer> list);

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryOne")
    Map<String,Object> selectGloryOne(@RequestBody WorkVo workVo);

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    @PostMapping("/insertGlory")
    Map<String,Object> insertGlory(@RequestBody Glory glory);

    /**
     * 修改奖励
     * @param glory
     * @return
     */
    @PutMapping("/updateGlory")
    Map<String,Object> updateGlory(@RequestBody Glory glory);

    /**
     * 删除奖励
     * @param list
     * @return
     */
    @DeleteMapping("/deleteGlory")
    Map<String,Object> deleteGlory(@RequestBody ArrayList<Integer> list);

    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishOne")
    Map<String,Object> selectPunishOne(@RequestBody WorkVo workVo);

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    Map<String,Object> insertPunish(@RequestBody Punish punish);

    /**
     * 修改惩罚
     * @param punish
     * @return
     */
    @PutMapping("/updatePunish")
    Map<String,Object> updatePunish(@RequestBody Punish punish);

    /**
     * 删除惩罚
     * @param list
     * @return
     */
    @DeleteMapping("/deletePunish")
    Map<String,Object> deletePunish(@RequestBody ArrayList<Integer> list);

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationOne")
    Map<String,Object> selectEducationOne(@RequestBody WorkVo workVo);

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @PostMapping("/insertEducation")
    Map<String,Object> insertEducation(@RequestBody Education education);

    /**
     * 修改教育经历
     * @param education
     * @return
     */
    @PutMapping("/updateEducation")
    Map<String,Object> updateEducation(@RequestBody Education education);

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteEducation")
    Map<String,Object> deleteEducation(@RequestBody ArrayList<Integer> list);

    /**
     * 根据员工姓名查询调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/selectTransferAlls")
    Map<String,Object> selectTransferAlls(@RequestBody Transfer transfer);

    /**
     * 添加调动记录
     * @param transfer
     * @return
     */
    @PostMapping("/insertTransfer")
    Map<String,Object> insertTransfer(@RequestBody Transfer transfer);

    /**
     * 修改调动后的部门
     * @param staff
     * @return
     */
    @PutMapping("/updateDeptName")
    Map<String,Object> updateDeptName(@RequestBody Staff staff);

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    Map<String,Object> selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo);

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    @PostMapping("/insertWorker")
    Map<String,Object> insertWorker(@RequestBody FullVo fullVo);

    /**
     * 修改员工状态为正式
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffState")
    Map<String,Object> updateStaffState(@RequestBody Staff staff);

    /**
     * 添加离职
     * @param quit
     * @return
     */
    @PostMapping("/insertQuit")
    Map<String,Object> insertQuit(@RequestBody Quit quit);

    /**
     * 修改员工状态为离职
     * @param staff
     * @return
     */
    @PutMapping("/updateStaffStateTwo")
    Map<String,Object> updateStaffStateTwo(@RequestBody Staff staff);

    /**
     * 修改转正日期
     * @param staff
     * @return
     */
    @PutMapping("/updateWorkerDate")
    Map<String,Object> updateWorkerDate(@RequestBody Staff staff);

    /**
     * 快转正名单
     * @param fullVo
     * @return
     */
    @PostMapping("/selectQuick")
    Map<String,Object> selectQuick(@RequestBody FullVo fullVo);

    /**
     * 统计快要转正名单
     * @return
     */
    @PostMapping("/countByStaffState")
    Map<String,Object> countByStaffState();

    /**
     * 转正已生效
     * @param fullVo
     * @return
     */
    @PostMapping("/selectStateOne")
    Map<String,Object> selectStateOne(@RequestBody FullVo fullVo);

    /**
     * 统计转正已生效
     * @return
     */
    @PostMapping("/countStateOne")
    Map<String,Object> countStateOne();

    /**
     * 统计试用期人员
     * @return
     */
    @PostMapping("/countStateTwo")
    Map<String,Object> countStateTwo();

    /**
     * 本月离职
     * @return
     */
    @PostMapping("/countStateThree")
    Map<String,Object> countStateThree();

    /**
     * 正式
     * @return
     */
    @PostMapping("/countStateFour")
    Map<String,Object> countStateFour();

    /**
     * 试用
     * @return
     */
    @PostMapping("/countStateFive")
    Map<String,Object> countStateFive();

    /**
     * 本月新入职
     * @return
     */
    @PostMapping("/countStateSix")
    Map<String,Object> countStateSix();
}

