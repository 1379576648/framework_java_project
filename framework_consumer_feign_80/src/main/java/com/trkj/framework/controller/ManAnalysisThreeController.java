package com.trkj.framework.controller;

import com.trkj.framework.service.client.statistics.StatisticsClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author TanWei
 */
@RestController
public class ManAnalysisThreeController {
    @Autowired
    private StatisticsClinetService service=null;

    @GetMapping("/selectStaffSex")
    public AjaxResponse querySex(){
            return AjaxResponse.success(service.querySex());
    }

}
