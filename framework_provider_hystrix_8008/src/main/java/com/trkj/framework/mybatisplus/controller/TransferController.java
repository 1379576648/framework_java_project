package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Transfer;
import com.trkj.framework.mybatisplus.service.TransferService;
import com.trkj.framework.util.Fuse8008Util;
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


    @Autowired
    private Fuse8008Util fuse8008Util;

    /**
     * 查询调动
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransfer")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> selectTransfer(@RequestBody TransferVo transferVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", transferService.selectTransfer(transferVo));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet(@RequestBody TransferVo transferVo) {
        return fuse8008Util.main();
    }

    /**
     * 查询所有的员工姓名
     *
     * @param
     * @return
     */
    @PostMapping("/selectStaffName")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> selectStaffName() {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectStaffName());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet2() {
        return fuse8008Util.main();
    }

    /**
     * 查询所有的部门名称
     *
     * @return
     */
    @PostMapping("/selectSect")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> selectDeptName() {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectSect());
        System.out.println();
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet3() {
        return fuse8008Util.main();
    }
    /**
     * 根据名字查询部门名称和职位名称
     *
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectTransferByName")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String, Object> selectTransferByName(@RequestBody TransferTwoVo transferTwoVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectTransferByName(transferTwoVo));
        System.out.println(transferTwoVo);
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet5(@RequestBody TransferTwoVo transferTwoVo) {
        return fuse8008Util.main();
    }

    @PostMapping("/selectTransferAlls")
    @HystrixCommand(fallbackMethod = "hystixGet6")
    public Map<String, Object> selectTransferAlls(@RequestBody Transfer transfer) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectTransferAlls(transfer));
        System.out.println(transfer);
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet6(@RequestBody Transfer transfer) {
        return fuse8008Util.main();
    }

    /**
     * 添加调动记录
     *
     * @param transfer
     * @return
     */
    @PostMapping("/insertTransfer")
    @HystrixCommand(fallbackMethod = "hystixGet7")
    public Map<String, Object> inserTransfer(@RequestBody Transfer transfer) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", transferService.insertTransfer(transfer));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet7(@RequestBody Transfer transfer) {
        return fuse8008Util.main();
    }

    /**
     * 根据部门查询部门职位
     * @param transferTwoVo
     * @return
     */
    @PostMapping("/selectPostName")
    @HystrixCommand(fallbackMethod = "hystixGet8")
    public Map<String, Object> selectPostName(@RequestBody TransferTwoVo transferTwoVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectPostName(transferTwoVo));
        System.out.println(transferTwoVo);
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet8(@RequestBody TransferTwoVo transferTwoVo) {
        return fuse8008Util.main();
    }
}

