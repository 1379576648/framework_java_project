package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
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

}
