package com.trkj.framework.controller;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecruitmentController {
    @Autowired
    private NewresumeClinetService newresumeClinetService=null;


    /**
     * 招聘计划查询
     * @param recruitmentVo
     * @return
     */
    @PostMapping("/selectRecruitment")
    private Object queryRecruitment(@RequestBody RecruitmentVo recruitmentVo){
        return AjaxResponse.success(newresumeClinetService.queryRecruitment(recruitmentVo));
    }
}
