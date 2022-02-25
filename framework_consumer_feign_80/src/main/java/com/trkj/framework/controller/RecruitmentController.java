package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RecruitmentController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 招聘计划查询
     * @param recruitmentVo
     * @return
     */
    @PostMapping("/selectRecruitment")
    private Object queryRecruitment(@RequestBody RecruitmentVo recruitmentVo){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryRecruitment(recruitmentVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectPlan")
    private Object selectPlan(){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.selectPlan();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptName1")
    private Object selectDeptName1(){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.selectDeptName1();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询部门职位名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptPostName1")
    private Object selectDeptPostName1(){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.selectDeptPostName1();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询月薪范围（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectMonthlySalary")
    private Object selectMonthlySalary(){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.selectMonthlySalary();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
