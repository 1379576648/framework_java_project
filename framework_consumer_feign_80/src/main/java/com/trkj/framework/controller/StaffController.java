package com.trkj.framework.controller;

import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.StaffVo;
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


}
