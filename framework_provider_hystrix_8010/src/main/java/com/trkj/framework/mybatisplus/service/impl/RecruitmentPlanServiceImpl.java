package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.MonthlySalary;
import com.trkj.framework.entity.mybatisplus.RecruitmentPlan;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.DeptpostMapper;
import com.trkj.framework.mybatisplus.mapper.MonthlySalaryMapper;
import com.trkj.framework.mybatisplus.mapper.RecruitmentPlanMapper;
import com.trkj.framework.mybatisplus.service.RecruitmentPlanService;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TanWei
 */
@Service
public class RecruitmentPlanServiceImpl implements RecruitmentPlanService {
    @Autowired
    private RecruitmentPlanMapper mapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptpostMapper deptpostMapper;

    @Autowired
    private MonthlySalaryMapper monthlySalaryMapper;
    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    @Override
    public List<RecruitmentPlan> selectPlan() {
        return mapper.selectList(new QueryWrapper<RecruitmentPlan>());
    }

    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @Override
    public List<Dept> selectDeptName1() {
        return deptMapper.selectList(new QueryWrapper<Dept>());
    }

    /**
     * 查询部门职位名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @Override
    public List<DeptPost> selectDeptPostName1() {
        return deptpostMapper.selectList(new QueryWrapper<DeptPost>());
    }

    /**
     * 查询月薪范围（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @Override
    public List<MonthlySalary> selectMonthlySalary() {
        return monthlySalaryMapper.selectList(new QueryWrapper<MonthlySalary>());
    }
}
