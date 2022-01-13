package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
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


    /**
     * 新简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectResume")
    private Object queryResume(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryResume(resumeVo));
    }


    /**
     * 全部简历
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectAllresume")
    private Object queryAll(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryAll(resumeVo));
    }


    /**
     * 候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectCandidate")
    private Object queryCandidate(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryCandidate(resumeVo));
    }


    /**
     * 淘汰库
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectEliminate")
    private Object queryEliminate(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(newresumeClinetService.queryEliminate(resumeVo));
    }

    /**
     * 面试候选人
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInterviewCandidate")
    private Object queryInterviewCandidate(@RequestBody ResumeVo resumeVo) {
        return AjaxResponse.success(newresumeClinetService.queryInterviewCandidate(resumeVo));
    }

    /**
     * 已邀约
     * @param resumeVo
     * @return
     */
    @PostMapping("/selectInvite")
    private Object queryInvite(@RequestBody ResumeVo resumeVo) {
        return AjaxResponse.success(newresumeClinetService.queryInvite(resumeVo));
    }
}
