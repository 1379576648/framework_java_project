package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 112729
 */
@RestController
public class EvectionRecordController {
    @Autowired
    private CheckingService checkingService;

    /**
     * 根据员工名称查询出差记录
     * @param travel
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    public AjaxResponse selectEvectionRecordAll(@RequestBody Travel travel) {
        return AjaxResponse.success(checkingService.selectEvectionRecordAll(travel));
    }

    /**
     * 删除出差记录
     * @param travel
     * @return
     */
    @PostMapping("/deleteEvection")
    public AjaxResponse deleteEvection(@RequestBody Travel travel) {
        return AjaxResponse.success(checkingService.deleteEvection(travel));
    }
}
