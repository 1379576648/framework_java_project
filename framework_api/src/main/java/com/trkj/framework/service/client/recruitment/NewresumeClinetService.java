package com.trkj.framework.service.client.recruitment;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.service.client.fallbackfactory.NewresumeClinetServiceFallbackfactory;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author TanWei
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8010/provider", fallbackFactory = NewresumeClinetServiceFallbackfactory.class)
public interface NewresumeClinetService {
    /**
     * 新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectResume")
    Map<String,Object> queryResume(@RequestBody ResumeVo resumeVo);


    /**
     * 全部简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectAllresume")
    Map<String,Object> queryAll(@RequestBody ResumeVo resumeVo);

    /**
     * 候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectCandidate")
    Map<String,Object> queryCandidate(@RequestBody ResumeVo resumeVo);

    /**
     * 淘汰库
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectEliminate")
    Map<String,Object> queryEliminate(@RequestBody ResumeVo resumeVo);

    /**
     * 招聘计划查询
     * @param recruitmentVo
     * @return
     */
    @PostMapping("/selectRecruitment")
    Map<String,Object> queryRecruitment(@RequestBody RecruitmentVo recruitmentVo);

    /**
     * 面试通过查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewPass")
    Map<String,Object> queryInterviewPass(@RequestBody InterviewVo interviewVo);


    /**
     * 面试候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    Map<String,Object> queryInterviewCandidate(@RequestBody ResumeVo resumeVo);

    /**
     * 已邀约
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInvite")
    Map<String,Object> queryInvite(@RequestBody ResumeVo resumeVo);

    /**
     * 添加录用数据
     * @param employment
     * @return
     */
    @PostMapping("/EmployStaff")
    Map<String,Object> employStaff(@RequestBody Employment employment);

    /**
     * 添加新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/addResume")
    Map<String,Object> queryAddResume(@RequestBody ResumeVo resumeVo);

    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectPlan")
    Map<String, Object>  selectPlan();
}
