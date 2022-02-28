package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.MoneyPigeonhole;
import com.trkj.framework.mybatisplus.service.MoneyPigeonholeService;
import com.trkj.framework.util.Fuse8006Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MoneyPigeonholeController {
    @Autowired
    private MoneyPigeonholeService moneyPigeonholeService;
    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 查询未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/selectMoney")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Map<String,Object> selectMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",moneyPigeonholeService.selectMoney(moneyPigeonhole));
        return map1;
    }

    // 备选方案
    public Map<String,Object> HystixGet(@RequestBody MoneyPigeonhole moneyPigeonhole){
        return fuse8006Util.main();
    }

    /**
     * 统计未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/countMoney")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> countMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",moneyPigeonholeService.countMoney(moneyPigeonhole));
        return map1;
    }

    //备选方案
    public  Map<String, Object> hystixGet2(@RequestBody MoneyPigeonhole moneyPigeonhole){
        return fuse8006Util.main();
    }

    /**
     * 查询已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/selectMoneys")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Map<String,Object> selectMoneys(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",moneyPigeonholeService.selectMoneys(moneyPigeonhole));
        return map1;
    }

    // 备选方案
    public Map<String,Object> HystixGet3(@RequestBody MoneyPigeonhole moneyPigeonhole){
        return fuse8006Util.main();
    }

    /**
     * 统计已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/countMoneys")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> countMoneys(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",moneyPigeonholeService.countMoneys(moneyPigeonhole));
        return map1;
    }

    //备选方案
    public  Map<String, Object> hystixGet4(@RequestBody MoneyPigeonhole moneyPigeonhole) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为已归档
     * @param moneyPigeonhole
     * @return
     */
    @PutMapping("/updateMoney")
    @HystrixCommand(fallbackMethod = "updateMoneyHystix")
    public Map<String,Object> updateMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        //修改状态为已归档
        moneyPigeonhole.setMoneyPigeonholeState(1);
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",moneyPigeonholeService.updateMoney(moneyPigeonhole));
        return map1;
    }
    // 备选方案
    public Map<String,Object> updateMoneyHystix(@RequestBody MoneyPigeonhole moneyPigeonhole){
        return fuse8006Util.main();
    }
}

