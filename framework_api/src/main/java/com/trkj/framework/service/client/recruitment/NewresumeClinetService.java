package com.trkj.framework.service.client.recruitment;

import com.trkj.framework.service.client.fallbackfactory.NewresumeClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8010/provider", fallbackFactory = NewresumeClinetServiceFallbackfactory.class)
public interface NewresumeClinetService {
    // 新简历
    @PostMapping("/selectResume")
    Object queryResume(@RequestBody ResumeVo resumeVo);

    // 全部简历
    @PostMapping("/selectAllresume")
    Object queryAll(@RequestBody ResumeVo resumeVo);

    // 候选人
    @PostMapping("/selectCandidate")
    Object queryCandidate(@RequestBody ResumeVo resumeVo);

    // 淘汰库
    @PostMapping("/selectEliminate")
    Object queryEliminate(@RequestBody ResumeVo resumeVo);

    // 招聘计划查询
    @PostMapping("/selectRecruitment")
    Object queryRecruitment(@RequestBody RecruitmentVo recruitmentVo);

    // 面试通过查询
    @PostMapping("/selectInterviewPass")
    Object queryInterviewPass(@RequestBody InterviewVo interviewVo);
}
