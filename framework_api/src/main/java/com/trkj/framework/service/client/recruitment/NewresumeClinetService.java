package com.trkj.framework.service.client.recruitment;

import com.trkj.framework.service.client.fallbackfactory.NewresumeClinetServiceFallbackfactory;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author TanWei
 */
@FeignClient(value = "REGISTER-8010/provider", fallbackFactory = NewresumeClinetServiceFallbackfactory.class)
public interface NewresumeClinetService {
    /**
     * 新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectResume")
    Object queryResume(@RequestBody ResumeVo resumeVo);


    /**
     * 全部简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectAllresume")
    Object queryAll(@RequestBody ResumeVo resumeVo);

    /**
     * 候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectCandidate")
    Object queryCandidate(@RequestBody ResumeVo resumeVo);

    /**
     * 淘汰库
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectEliminate")
    Object queryEliminate(@RequestBody ResumeVo resumeVo);

    /**
     * 招聘计划查询
     * @param recruitmentVo
     * @return
     */
    @PostMapping("/selectRecruitment")
    Object queryRecruitment(@RequestBody RecruitmentVo recruitmentVo);

    /**
     * 面试通过查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewPass")
    Object queryInterviewPass(@RequestBody InterviewVo interviewVo);


    /**
     * 面试候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    Object queryInterviewCandidate(@RequestBody ResumeVo resumeVo);

    /**
     * 已邀约
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInvite")
    Object queryInvite(@RequestBody ResumeVo resumeVo);

}
