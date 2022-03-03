package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Interview;
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
     * 面试淘汰
     * @param interviewVo
     * @return
     */
    IPage<InterviewVo> selectInterviewOut(InterviewVo interviewVo);

    /**
     * 面试通过录用
     * @param
     * @return
     */
    Integer EmployStaff(Employment employment);

    /**
     * 修改面试到录用
     * @param
     * @return
     */
    int InterviewHire(Interview interview);

    /**
     * 开始面试（待面试）
     * @param
     * @return
     */
    int BeginBy(Interview interview);

    /**
     * 淘汰（待面试）
     * @param
     * @return
     */
    int GiveUp(Interview interview);

    /**
     * 面试通过（面试中）
     * @param
     * @return
     */
    int PassInterview(Interview interview);

    /**
     * 安排复试（面试中）
     * @param
     * @return
     */
    int TheSecondInterview(Interview interview);

    /**
     * 淘汰（面试中）
     * @param
     * @return
     */
    int GiveUp2(Interview interview);

    /**
     * 复试通过
     * @param
     * @return
     */
    int secondInterviewPass(Interview interview);

    /**
     * 淘汰（复试中）
     * @param
     * @return
     */
    int GiveUp3(Interview interview);

    /**
     * 淘汰（面试通过）
     * @param
     * @return
     */
    int GiveUp4(Interview interview);
}
