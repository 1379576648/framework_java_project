package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HireController {
    @Autowired
    private HireClientService hireClientService =null;

    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectpage")
    public AjaxResponse selecthirepage(@RequestBody HireVo hireVo) {
        return AjaxResponse.success(hireClientService.selecthirepage(hireVo));
    }

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */

    @PostMapping("/selectabandon")
    public AjaxResponse selectabandon(@RequestBody HireVo hireVo){
        return AjaxResponse.success(hireClientService.selectabandon(hireVo));

    }

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    public AjaxResponse selectwork(@RequestBody WorkVo workVo){
        return AjaxResponse.success(hireClientService.selectwork(workVo));
    }

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    public AjaxResponse selectWorkAll(@RequestBody WorkVo workVo){
        return AjaxResponse.success(hireClientService.selectWorkAll(workVo));
    }

    /**
     * 查询转正
     * @param fullVo
     * @return
     */

    @PostMapping("/selectpost")
    public AjaxResponse selectpost(@RequestBody FullVo fullVo){
        return AjaxResponse.success(hireClientService.selectpost(fullVo));

    }

    /**
     * 新增员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    public AjaxResponse insertStaff(@RequestBody HireVo hireVo){
        return AjaxResponse.success(hireClientService.insertStaff(hireVo));
    }

    /**
     * 修改录用表状态
     * @param employmentTable
     * @return
     */
    @PostMapping("/updateEmploymentState")
    public AjaxResponse updateEmploymentState(@RequestBody EmploymentTable employmentTable){
        return AjaxResponse.success(hireClientService.updateEmploymentState(employmentTable));
    }

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @PostMapping("/updateEmploymentStateAndWaiveReasonInt")
    public AjaxResponse updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentTable){
        return AjaxResponse.success(hireClientService.updateEmploymentStateAndWaiveReasonInt(employmentTable));

    }


}
