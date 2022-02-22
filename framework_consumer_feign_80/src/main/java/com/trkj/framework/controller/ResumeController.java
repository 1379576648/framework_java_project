package com.trkj.framework.controller;

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
}
