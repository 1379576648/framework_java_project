package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.service.EvectionRecordService;
import com.trkj.framework.mybatisplus.service.ReissueCardRecordService;
import com.trkj.framework.util.Fuse8004Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 补打卡记录 前端控制器
 *
 * @author 112729
 */
@RestController
public class ReissueCardRecordController {
    @Autowired
    private ReissueCardRecordService reissueCardRecordService;
    @Autowired
    private Fuse8004Util fuse8004Util;
    /**
     * 根据员工名称查询出补打卡记录
     *
     * @param card
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    @HystrixCommand(fallbackMethod = "selectReissueCardRecordAllHystixGet")
    public Map<String, Object> selectReissueCardRecordAll(@RequestBody Card card) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", reissueCardRecordService.selectReissueCardRecordAll(card));
        return map1;
    }

    public Map<String, Object> selectReissueCardRecordAllHystixGet(@RequestBody Card card) {
        return fuse8004Util.main();
    }

    /**
     * 删除补打卡记录
     *
     * @param card
     * @return
     */
    @PostMapping("/deleteCard")
    @HystrixCommand(fallbackMethod = "deleteCardHystixGet")
    public Map<String, Object> deleteCard(@RequestBody Card card) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", reissueCardRecordService.deleteCard(card));
        return map1;
    }

    public Map<String, Object> deleteCardHystixGet(@RequestBody Card card) {
        return fuse8004Util.main();
    }
}
