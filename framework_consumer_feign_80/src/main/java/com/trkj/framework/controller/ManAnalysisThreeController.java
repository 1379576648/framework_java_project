package com.trkj.framework.controller;

import com.trkj.framework.service.client.statistics.StatisticsClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author TanWei
 */
@RestController
public class ManAnalysisThreeController {
    @Autowired
    private StatisticsClinetService service=null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    @GetMapping("/selectStaffSex")
    public AjaxResponse querySex(){
        Map<String, Object> map = (Map<String, Object>) service.querySex();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

}
