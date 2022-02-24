package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.MonthlySalary;
import com.trkj.framework.entity.mybatisplus.RecruitmentPlan;
import com.trkj.framework.vo.RecruitmentVo;

import java.util.List;

/**
 * @author TanWei
 */
public interface RecruitmentPlanService {
    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    List<RecruitmentPlan> selectPlan();

    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    List<Dept> selectDeptName1();

    /**
     * 查询部门职位名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    List<DeptPost> selectDeptPostName1();

    /**
     * 查询月薪范围（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    List<MonthlySalary> selectMonthlySalary();
}
