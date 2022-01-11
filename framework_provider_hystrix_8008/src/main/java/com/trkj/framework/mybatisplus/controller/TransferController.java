package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.TransferService;
import com.trkj.framework.vo.TransferTwoVo;
import com.trkj.framework.vo.TransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 调动记录表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-10
 */
@RestController
public class TransferController {
    @Autowired
    private TransferService transferService;

    /**
     * 查询调动
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectTransfer(@RequestBody TransferVo transferVo){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",transferService.selectTransfer(transferVo));
        return map1;
    }
    // 备选方案
    public Object HystixGet(@RequestBody TransferVo transferVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询所有的员工姓名
     * @param
     * @return
     */
    @PostMapping("/selectStaffName")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectStaffName(){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectStaffName());
        System.out.println();
        return map1;
    }

    // 备选方案
    public Object HystixGet2(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询所有的部门名称
     * @return
     */
    @PostMapping("/selectSect")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDeptName(){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectSect());
        System.out.println();
        return map1;
    }

    // 备选方案
    public Object HystixGet3(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询所有的职位名称
     * @return
     */
    @PostMapping("/selectJob")
    @HystrixCommand(fallbackMethod = "HystixGet4")
    public Object selectJob(){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectJob());
        System.out.println();
        return map1;
    }

    // 备选方案
    public Object HystixGet4(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据名字查询部门名称和职位名称
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectTransferByName")
    @HystrixCommand(fallbackMethod = "HystixGet5")
    public Object selectTransferByName(@RequestBody TransferTwoVo transferTwoVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectTransferByName(transferTwoVo));
        System.out.println(transferTwoVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet5(@RequestBody TransferTwoVo transferTwoVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

