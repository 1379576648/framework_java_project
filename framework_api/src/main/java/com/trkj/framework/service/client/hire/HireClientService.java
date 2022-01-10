package com.trkj.framework.service.client.hire;

import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.fallbackfactory.HireClientServiceFallbackfactory;
import com.trkj.framework.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8008/provider", fallbackFactory = HireClientServiceFallbackfactory.class)
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
    @PostMapping("/updateEmploymentState")
    Object updateEmploymentState(@RequestBody EmploymentTable employmentTable);

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @PostMapping("/updateEmploymentStateAndWaiveReasonInt")
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
    @PostMapping("/updateStaff")
    Object updateStaff(@RequestBody Staff staff);

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @PostMapping("/updateStaffTwo")
    Object updateStaffTwo(@RequestBody Staff staff);
}

