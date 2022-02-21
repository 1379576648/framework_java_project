package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.loadtime.Aj;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HireController {
    @Autowired
    private HireClientService hireClientService =null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectpage")
    public AjaxResponse selecthirepage(@RequestBody HireVo hireVo) {
        Map<String, Object> map = (Map<String, Object>) hireClientService.selecthirepage(hireVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */

    @PostMapping("/selectabandon")
    public AjaxResponse selectabandon(@RequestBody HireVo hireVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectabandon(hireVo);
        return AjaxResponse.success(carryTokenUtil.main(map));

    }

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    public AjaxResponse selectwork(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectwork(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    public AjaxResponse selectWorkAll(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectWorkAll(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryAll")
    public AjaxResponse selectGloryAll(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectGloryAll(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishAll")
    public AjaxResponse selectPunishAll(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectPunishAll(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationAll")
    public AjaxResponse selectEducationAll(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectEducationAll(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询转正
     * @param fullVo
     * @return
     */

    @PostMapping("/selectpost")
    public AjaxResponse selectpost(@RequestBody FullVo fullVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectpost(fullVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 新增员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    public AjaxResponse insertStaff(@RequestBody HireVo hireVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.insertStaff(hireVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改录用表状态
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentState")
    public AjaxResponse updateEmploymentState(@RequestBody EmploymentTable employmentTable){
        Map<String, Object> map = (Map<String, Object>) hireClientService.updateEmploymentState(employmentTable);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @PutMapping("/updateEmploymentStateAndWaiveReasonInt")
    public AjaxResponse updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentTable){
        Map<String, Object> map = (Map<String, Object>) hireClientService.updateEmploymentStateAndWaiveReasonInt(employmentTable);
        return AjaxResponse.success(carryTokenUtil.main(map));

    }

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkOne")
    public AjaxResponse selectWorkOne(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectWorkOne(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryOne")
    public AjaxResponse selectGloryOne(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectGloryOne(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishOne")
    public AjaxResponse selectPunishOne(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectPunishOne(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationOne")
    public AjaxResponse selectEducationOne(@RequestBody WorkVo workVo){
        Map<String, Object> map = (Map<String, Object>) hireClientService.selectEducationOne(workVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


}
