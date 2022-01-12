package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.InterviewVo;

public interface InterviewService extends IService<InterviewVo> {

    //面试通过
    IPage<InterviewVo> selectInterviewPass(InterviewVo interviewVo);


}
