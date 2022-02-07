package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
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
public class CardRecordController {
    @Autowired
    private CheckingService checkingService;

    /**
     * 根据员工名称查询打卡记录
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    public AjaxResponse selectCardRecordAll(@RequestBody ClockRecord cardRecord) {
        return AjaxResponse.success(checkingService.selectCardRecordAll(cardRecord));
    }

    /**
     * 删除打卡记录
     * @param cardRecord
     * @return
     */
    @PostMapping("/deleteClock")
    public AjaxResponse deleteClock(@RequestBody ClockRecord cardRecord) {
        return AjaxResponse.success(checkingService.deleteClock(cardRecord));
    }

    /**
     * 根据员工名称查询补打卡记录
     * @param card
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    public AjaxResponse selectReissueCardRecordAll(@RequestBody Card card) {
        return AjaxResponse.success(checkingService.selectReissueCardRecordAll(card));
    }

    /**
     * 删除补打卡记录
     * @param card
     * @return
     */
    @PostMapping("/deleteCard")
    public AjaxResponse deleteCard(@RequestBody Card card) {
        return AjaxResponse.success(checkingService.deleteCard(card));
    }
}
