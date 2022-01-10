package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/updateStaff")
    public AjaxResponse updateStaff(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaff(staff));
    }

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @PostMapping("/updateStaffTwo")
    public AjaxResponse updateStaffTwo(@RequestBody Staff staff){
        return AjaxResponse.success(hireClientService.updateStaffTwo(staff));
    }

}
