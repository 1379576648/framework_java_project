package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.mybatisplus.mapper.InterviewMapper;
import com.trkj.framework.mybatisplus.service.InterviewService;
import com.trkj.framework.vo.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, InterviewVo> implements InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;

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
        return null;
    }
}
