package com.trkj.framework.service.client.recruitment;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Interview;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.service.client.fallbackfactory.NewresumeClinetServiceFallbackfactory;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
     * 待面试查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectForInterview")
    Map<String,Object> selectForInterview(@RequestBody InterviewVo interviewVo);

    /**
     * 面试中查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInInterview")
    Map<String,Object> selectInInterview(@RequestBody InterviewVo interviewVo);

    /**
     * 待面试查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectSecondInterview")
    Map<String,Object> selectSecondInterview(@RequestBody InterviewVo interviewVo);

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
     * 面试淘汰查询
     * @param interviewVo
     * @return
     */
    @PostMapping("/selectInterviewOut")
    Map<String,Object> selectInterviewOut(@RequestBody InterviewVo interviewVo);

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


    /**
     * 查询部门名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptName1")
    Map<String, Object>  selectDeptName1();


    /**
     * 查询部门职位名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectDeptPostName1")
    Map<String, Object>  selectDeptPostName1();

    /**
     * 查询部门职位名称（新增招聘计划下拉列表框）
     * @param
     * @return
     */
    @PostMapping("/selectMonthlySalary")
    Map<String, Object>  selectMonthlySalary();

    /**
     * 新增招聘计划
     * @param
     * @return
     */
    @PostMapping("/addRecruitmentPlan")
    Map<String,Object> addRecruitmentPlan(@RequestBody RecruitmentVo recruitmentVo);

    /**
     * 设为候选人
     * @param
     * @return
     */
    @PutMapping("/SetCandidate")
    Map<String, Object> SetCandidate(@RequestBody Resume resume);

    /**
     * 转入淘汰库（新简历）
     * @param
     * @return
     */
    @PutMapping("/Obsolete")
    Map<String, Object> Obsolete(@RequestBody Resume resume);

    /**
     * 设为面试候选人
     * @param
     * @return
     */
    @PutMapping("/InterviewCcandidate")
    Map<String, Object> InterviewCcandidate(@RequestBody Resume resume);

    /**
     * 转入淘汰库（候选人）
     * @param
     * @return
     */
    @PutMapping("/HObsolete")
    Map<String, Object> HObsolete(@RequestBody Resume resume);

    /**
     * 邀约面试（面试候选人）
     * @param
     * @return
     */
    @PutMapping("/OfferInterview")
    Map<String, Object> OfferInterview(@RequestBody Resume resume);

    /**
     * 淘汰放弃（面试候选人）
     * @param
     * @return
     */
    @PutMapping("/Abandon")
    Map<String, Object> Abandon(@RequestBody Resume resume);

    /**
     * 修改面试到录用
     * @param
     * @return
     */
    @PutMapping("/InterviewHire")
    Map<String, Object> InterviewHire(@RequestBody Interview interview);

    /**
     * 面试签到
     * @param
     * @return
     */
    @PostMapping("/InterviewSign")
    Map<String, Object> InterviewSign(@RequestBody Resume resume);

    /**
     * 开始面试
     * @param
     * @return
     */
    @PutMapping("/BeginBy")
    Map<String, Object> BeginBy(@RequestBody Interview interview);

    /**
     * 淘汰（待面试）
     * @param
     * @return
     */
    @PutMapping("/GiveUp")
    Map<String, Object> GiveUp(@RequestBody Interview interview);

    /**
     * 面试通过（面试中）
     * @param
     * @return
     */
    @PutMapping("/PassInterview")
    Map<String, Object> PassInterview(@RequestBody Interview interview);

    /**
     * 安排复试（面试中）
     * @param
     * @return
     */
    @PutMapping("/TheSecondInterview")
    Map<String, Object> TheSecondInterview(@RequestBody Interview interview);

    /**
     * 淘汰（面试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp2")
    Map<String, Object> GiveUp2(@RequestBody Interview interview);

    /**
     * 复试通过
     * @param
     * @return
     */
    @PutMapping("/secondInterviewPass")
    Map<String, Object> secondInterviewPass(@RequestBody Interview interview);

    /**
     * 淘汰（复试中）
     * @param
     * @return
     */
    @PutMapping("/GiveUp3")
    Map<String, Object> GiveUp3(@RequestBody Interview interview);

    /**
     * 淘汰（面试通过）
     * @param
     * @return
     */
    @PutMapping("/GiveUp4")
    Map<String, Object> GiveUp4(@RequestBody Interview interview);
}
