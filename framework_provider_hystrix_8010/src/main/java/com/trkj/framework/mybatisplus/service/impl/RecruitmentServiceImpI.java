package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.MonthlySalary;
import com.trkj.framework.entity.mybatisplus.RecruitmentPlan;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.RecruitmentService;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 牛蛙
 */
@Service
public class RecruitmentServiceImpI extends ServiceImpl<RecruitmentMapper, RecruitmentVo> implements RecruitmentService {
    @Autowired
    private RecruitmentMapper recruitmentMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptpostMapper deptpostMapper;

    @Autowired
    private MonthlySalaryMapper monthlySalaryMapper;

    @Autowired
    private RecruitmentPlanMapper recruitmentPlanMapper;
    /**
     * 招聘计划查询
     * @param
     * @return
     */
    @Override
    public IPage<RecruitmentVo> selectRecruitment(RecruitmentVo recruitmentVo) {
        Page<RecruitmentVo> page=new Page<>(recruitmentVo.getCurrentPage(),recruitmentVo.getPagesize());
        return recruitmentMapper.selectRecruitment(page);
    }

    /**
     * 新增招聘计划
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addRecruitmentPlan(RecruitmentVo recruitmentVo) throws ArithmeticException  {
        Dept dept = deptMapper.selectOne(new QueryWrapper<Dept>().eq("DEPT_NAME",recruitmentVo.getDeptName()));
        DeptPost deptPost = deptpostMapper.selectOne(new QueryWrapper<DeptPost>().eq("POST_NAME",recruitmentVo.getPostName()));
        MonthlySalary monthlySalary= monthlySalaryMapper.selectOne(new QueryWrapper<MonthlySalary>().eq("MONTHLY_SALARY_STAR",recruitmentVo.getMonthlySalaryStar()).eq("MONTHLY_SALARY_END",recruitmentVo.getMonthlySalaryEnd()));
        RecruitmentPlan recruitmentPlan = new RecruitmentPlan();
        if (dept!=null){
            recruitmentPlan.setDeptId(dept.getDeptId());
        }
        if (deptPost!=null){
            recruitmentPlan.setDeptPostId(deptPost.getDeptPostId());
        }
        if (monthlySalary!=null){
            recruitmentPlan.setRecruitmentPlanSalaryId(monthlySalary.getMonthlySalaryId());
        }
        recruitmentPlan.setRecruitmentPlanName(recruitmentVo.getRecruitmentPlanName());
        recruitmentPlan.setEducationName(recruitmentVo.getEducationName());
        recruitmentPlan.setRecruitmentPlanNumber(recruitmentVo.getRecruitmentPlanNumber());
        recruitmentPlan.setRecruitmentPlanStartTime(recruitmentVo.getRecruitmentPlanStartTime());
        recruitmentPlan.setRecruitmentPlanEndTime(recruitmentVo.getRecruitmentPlanEndTime());
        int i = recruitmentPlanMapper.insert(recruitmentPlan);
        if (i == 1){
            return "成功";
        }else {
            throw new ArithmeticException("失败");
        }
    }


}
