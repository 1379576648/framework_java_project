package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Interview;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TanWei
 */
@RestController
public class ResumeController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectResume")
    private Object queryResume(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryResume(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /**
     * 全部简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectAllresume")
    private Object queryAll(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryAll(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /**
     * 候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectCandidate")
    private Object queryCandidate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryCandidate(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /**
     * 淘汰库
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectEliminate")
    private Object queryEliminate(@RequestBody ResumeVo resumeVo){
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryEliminate(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    private Object queryInterviewCandidate(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryInterviewCandidate(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 已邀约
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInvite")
    private Object queryInvite(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryInvite(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/addResume")
    private Object queryAddResume(@RequestBody ResumeVo resumeVo) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.queryAddResume(resumeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 设为候选人
     * @param resume
     * @return
     */
    @PutMapping("/SetCandidate")
    private Object SetCandidate(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.SetCandidate(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 转入淘汰库（新简历）
     * @param resume
     * @return
     */
    @PutMapping("/Obsolete")
    private Object Obsolete(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.Obsolete(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 设为面试候选人
     * @param resume
     * @return
     */
    @PutMapping("/InterviewCcandidate")
    private Object InterviewCcandidate(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.InterviewCcandidate(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 转入淘汰库（候选人）
     * @param resume
     * @return
     */
    @PutMapping("/HObsolete")
    private Object HObsolete(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.HObsolete(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 邀约面试（面试候选人）
     * @param
     * @return
     */
    @PutMapping("/OfferInterview")
    private Object OfferInterview(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.OfferInterview(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 淘汰放弃（面试候选人）
     * @param
     * @return
     */
    @PutMapping("/Abandon")
    private Object Abandon(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.Abandon(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改面试到录用
     * @param
     * @return
     */
    @PutMapping("/InterviewHire")
    private Object InterviewHire(@RequestBody Interview interview) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.InterviewHire(interview);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 面试签到
     * @param
     * @return
     */
    @PostMapping("/InterviewSign")
    private Object InterviewSign(@RequestBody Resume resume) {
        Map<String, Object> map = (Map<String, Object>) newresumeClinetService.InterviewSign(resume);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


}
