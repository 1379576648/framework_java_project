package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.vo.InterviewVo;

public interface InterviewService extends IService<InterviewVo> {

    /**
     * 面试通过
     * @param interviewVo
     * @return
     */
    IPage<InterviewVo> selectInterviewPass(InterviewVo interviewVo);

    /**
     * 待面试
     * @param interviewVo
     * @return
     */
    IPage<InterviewVo> selectForInterview(InterviewVo interviewVo);

    /**
     * 面试中
     * @param interviewVo
     * @return
     */
    IPage<InterviewVo> selectInInterview(InterviewVo interviewVo);

    /**
     * 复试中
     * @param interviewVo
     * @return
     */
    IPage<InterviewVo> selectSecondInterview(InterviewVo interviewVo);

    /**
     * 面试通过录用
     * @param
     * @return
     */
    Integer EmployStaff(Employment employment);


}
