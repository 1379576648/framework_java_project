package com.trkj.framework.service.client.recruitment;

import com.trkj.framework.service.client.fallbackfactory.NewresumeClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8010/provider", fallbackFactory = NewresumeClinetServiceFallbackfactory.class)
public interface NewresumeClinetService {
    @PostMapping("/selectResume")
    Object queryResume(@RequestBody ResumeVo resumeVo);

    @PostMapping("/selectAllresume")
    Object queryAll(@RequestBody ResumeVo resumeVo);

    @PostMapping("/selectCandidate")
    Object queryCandidate(@RequestBody ResumeVo resumeVo);

    @PostMapping("/selectEliminate")
    Object queryEliminate(@RequestBody ResumeVo resumeVo);

    @PostMapping("/selectRecruitment")
    Object queryRecruitment(@RequestBody RecruitmentVo recruitmentVo);
}
