package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Interview;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.mapper.EmploymentMapper;
import com.trkj.framework.mybatisplus.mapper.Interview2Mapper;
import com.trkj.framework.mybatisplus.mapper.InterviewMapper;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, InterviewVo> implements InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;
    @Autowired
    private EmploymentMapper employmentMapper;
    @Autowired
    private Interview2Mapper interview2Mapper;
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
        if (interviewVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",interviewVo.getResumeName());
        }
        return interviewMapper.selectInterviewPass(page,queryWrapper);
    }

    /**
     * 待面试查询
     * @param
     * @return
     */
    @Override
    public IPage<InterviewVo> selectForInterview(InterviewVo interviewVo) {
        Page<InterviewVo> page = new Page<>(interviewVo.getCurrentPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INTERVIEW_STATE",0);
        if (interviewVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",interviewVo.getResumeName());
        }
        return interviewMapper.selectForInterview(page,queryWrapper);
    }

    /**
     * 面试中查询
     * @param
     * @return
     */
    @Override
    public IPage<InterviewVo> selectInInterview(InterviewVo interviewVo) {
        Page<InterviewVo> page = new Page<>(interviewVo.getCurrentPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INTERVIEW_STATE",1);
        if (interviewVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",interviewVo.getResumeName());
        }
        return interviewMapper.selectInInterview(page,queryWrapper);
    }

    /**
     * 复试中查询
     * @param
     * @return
     */
    @Override
    public IPage<InterviewVo> selectSecondInterview(InterviewVo interviewVo) {
        Page<InterviewVo> page = new Page<>(interviewVo.getCurrentPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INTERVIEW_STATE",3);
        if (interviewVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",interviewVo.getResumeName());
        }
        return interviewMapper.selectSecondInterview(page,queryWrapper);
    }

    /**
     * 面试淘汰查询
     * @param
     * @return
     */
    @Override
    public IPage<InterviewVo> selectInterviewOut(InterviewVo interviewVo) {
        Page<InterviewVo> page = new Page<>(interviewVo.getCurrentPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INTERVIEW_STATE",5);
        if (interviewVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",interviewVo.getResumeName());
        }
        return interviewMapper.selectInterviewOut(page,queryWrapper);
    }

    /**
     * 面试通过录用
     * @param
     * @return
     */
    @Override
    public Integer EmployStaff(Employment employment) {
        Employment employment1=new Employment();
        employment1.setEmploymentState(employment.getEmploymentState());
        employment1.setResumeId(employment.getResumeId());
        employment1.setRemarks(employment.getRemarks());
        employment1.setEmploymentSalary(employment.getEmploymentSalary());
        employment1.setEmploymentSalaryz(employment.getEmploymentSalaryz());
        //employment1.setWaiveReason(employment.getWaiveReason());
        employment1.setEmploymentHireDate(new Date());
        return employmentMapper.insert(employment1);
    }


    /**
     * 修改面试到录用
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int InterviewHire(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 开始面试（待面试）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int BeginBy(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 淘汰（待面试）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int GiveUp(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 面试通过（面试中）
     * @param
     * @return
     */
    @Override
    public int PassInterview(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 安排复试（面试中）
     * @param
     * @return
     */
    @Override
    public int TheSecondInterview(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 淘汰（面试中）
     * @param
     * @return
     */
    @Override
    public int GiveUp2(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 复试通过
     * @param
     * @return
     */
    @Override
    public int secondInterviewPass(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 淘汰（复试中）
     * @param
     * @return
     */
    @Override
    public int GiveUp3(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 淘汰（面试通过）
     * @param
     * @return
     */
    @Override
    public int GiveUp4(Interview interview) {
        int i = interview2Mapper.updateById(interview);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
}
