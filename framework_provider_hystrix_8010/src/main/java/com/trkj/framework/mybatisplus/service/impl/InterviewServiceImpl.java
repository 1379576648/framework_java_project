package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.mybatisplus.mapper.EmploymentMapper;
import com.trkj.framework.mybatisplus.mapper.InterviewMapper;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, InterviewVo> implements InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;
    @Autowired
    private EmploymentMapper employmentMapper;
    /**
     * 面试通过查询
     * @param
     * @return
     */
    @Override
    public IPage<InterviewVo> selectInterviewPass(InterviewVo interviewVo) {
        Page<InterviewVo> page = new Page<>(interviewVo.getCurrentPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INTERVIEW_STATE",2);
        return interviewMapper.selectInterviewPass(page,queryWrapper);
    }

    @Override
    public Integer EmployStaff(Employment employment) {
        Employment employment1=new Employment();
        employment1.setEmploymentState(employment.getEmploymentState());
        employment1.setResumeId(employment.getResumeId());
        employment1.setRemarks(employment.getRemarks());
        employment1.setEmploymentSalary(employment.getEmploymentSalary());
        //employment1.setWaiveReason(employment.getWaiveReason());
        employment1.setEmploymentHireDate(new Date());
        return employmentMapper.insert(employment1);
    }
}
