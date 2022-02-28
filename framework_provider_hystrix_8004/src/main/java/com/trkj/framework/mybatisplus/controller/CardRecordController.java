package com.trkj.framework.mybatisplus.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import com.trkj.framework.util.Fuse8004Util;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 打卡记录 前端控制器
 *
 * @author 112729
 */
@RestController
public class CardRecordController {
    @Autowired
    private CardRecordService cardRecordService;
    @Autowired
    private Fuse8004Util fuse8004Util;

    /**
     * 根据员工名称查询打卡记录
     *
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    @HystrixCommand(fallbackMethod = "selectCardRecordAllHystixGet")
    public Map<String, Object> selectCardRecordAll(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardRecordService.selectCardRecordAll(cardRecord));
        return map1;
    }

    public Map<String, Object> selectCardRecordAllHystixGet(@RequestBody ClockRecord cardRecord) {
        return fuse8004Util.main();
    }

    /**
     * 删除打卡记录
     *
     * @param cardRecord
     * @return
     */
    @PostMapping("/deleteClock")
    @HystrixCommand(fallbackMethod = "deleteClockHystixGet")
    public Map<String, Object> deleteClock(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        try {
            map1.put("info", cardRecordService.deleteClock(cardRecord));
        } catch (ArithmeticException e) {
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> deleteClockHystixGet(@RequestBody ClockRecord cardRecord) {
        return fuse8004Util.main();
    }

    /**
     * 导入打卡记录
     *
     * @param
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/importCardRecord")
    // @HystrixCommand(fallbackMethod = "importCardRecordHystixGet")
    public Map<String, Object> importCardRecord(MultipartFile file) throws Exception {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方法1：通过javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应
        // List<ClockRecord> list = reader.readAll(ClockRecord.class);
        // 方法2：忽略表头，直接读取 弊端 写的太死 不方便
        List<List<Object>> list = reader.read(1);
        // 获取Excel表中的数据去数据库中查有无相同数据
        var integer = 0;
        for (List<Object> objects : list) {
            integer = cardRecordService.    selcetCardRecord(objects);
            for (int j = 0; j < integer; j++) {
                // insert =1,则代表数据库中有相同数据
                if (integer >= 1) {
                    integer = 100;
                    break;
                }
            }
            if (integer == 100) {
                break;
            }
        }
        if (integer == 100) {
            map1.put("info", "导入失败,该Excel表格中的数据与数据库中数据有重复");
            return map1;
        } else {
            List<ClockRecord> cardRecord = CollUtil.newArrayList();
            for (List<Object> row : list) {
                ClockRecord clockRecords = new ClockRecord();
                clockRecords.setStaffName(row.get(0).toString());
                clockRecords.setDeptName(row.get(1).toString());
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d1 = sdf2.parse(row.get(2).toString());
                Date d2 = sdf2.parse(row.get(3).toString());
                clockRecords.setMornClock(d1);
                clockRecords.setAfternoonClock(d2);
                clockRecords.setCheckState(row.get(4).toString());
                cardRecord.add(clockRecords);
            }
            map1.put("info", cardRecordService.importCardRecord(cardRecord));
            return map1;
        }
    }

    // public Map<String, Object> importCardRecordHystixGet(MultipartFile file) {
    //     return fuse8004Util.main();
    // }

    /**
     * 根据名称查询打卡记录
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAllByName")
    @HystrixCommand(fallbackMethod = "selectCardRecordAllByNameHystixGet")
    public Map<String, Object> selectCardRecordAllByName(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardRecordService.selectCardRecordAllByName(cardRecord));
        return map1;
    }

    public Map<String, Object> selectCardRecordAllByNameHystixGet(@RequestBody ClockRecord cardRecord) {
        return fuse8004Util.main();
    }
}
