package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 112729
 */
@RestController
public class CardRecordController {
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据员工名称查询打卡记录
     *
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    @ApiOperation(value = "根据员工名称查询打卡记录", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectCardRecordAll")
    public AjaxResponse selectCardRecordAll(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectCardRecordAll(cardRecord);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除打卡记录
     *
     * @param cardRecord
     * @return
     */
    @PostMapping("/deleteClock")
    @ApiOperation(value = "删除打卡记录", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteClock")
    public AjaxResponse deleteClock(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteClock(cardRecord);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称查询补打卡记录
     *
     * @param card
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    @ApiOperation(value = "根据员工名称查询补打卡记录", notes = "考勤模块", httpMethod = "POST", nickname = "查询", produces = "/selectReissueCardRecordAll")
    public AjaxResponse selectReissueCardRecordAll(@RequestBody Card card) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectReissueCardRecordAll(card);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除补打卡记录
     *
     * @param card
     * @return
     */
    @PostMapping("/deleteCard")
    @ApiOperation(value = "删除补打卡记录", notes = "考勤模块", httpMethod = "POST", nickname = "删除", produces = "/deleteCard")
    public AjaxResponse deleteCard(@RequestBody Card card) {
        Map<String, Object> map = (Map<String, Object>) checkingService.deleteCard(card);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 导入打卡记录
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/importCardRecord", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AjaxResponse importCardRecord(MultipartFile file) {
        Map<String, Object> map = (Map<String, Object>) checkingService.importCardRecord(file);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询当前用户打卡记录2
     *
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAllByName")
    @ApiOperation(value = "导入打卡记录", notes = "查询当前用户打卡记录2", httpMethod = "POST", nickname = "查询", produces = "/selectCardRecordAllByName")
    public AjaxResponse selectCardRecordAllByName(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map = (Map<String, Object>) checkingService.selectCardRecordAllByName(cardRecord);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


}
