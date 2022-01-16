package com.trkj.framework.service.client.hire;

import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
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
}

