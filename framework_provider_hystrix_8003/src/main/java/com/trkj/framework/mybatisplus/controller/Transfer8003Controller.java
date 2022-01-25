package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.Transfer8003Service;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 调动 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class Transfer8003Controller {
    @Autowired
    private Transfer8003Service transferService;

    /**
     * 根据审批类型的调动/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectTransferAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", transferService.selectTransferAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndTransferAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", transferService.selectEndTransferAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTransfer")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsTransfer(@RequestBody TransferDetailsVo transferDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectDetailsTransfer(transferDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody TransferDetailsVo transferDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     *  点击异动查询所有部门
     * @param
     * @return
     */
    @GetMapping("/selectDeptList")
    @HystrixCommand(fallbackMethod = "selectDeptListHystrix")
    public  Object selectDeptAll(){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.selectDeptAll());
        return map1;
    }
    //备选
    public  Object selectDeptListHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有异动记录
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransferRecord")
    public Object selectTransferRecord(@RequestBody Transfer8003Vo transferVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectTransferRecord(transferVo));
        return map1;
    }

    /**
     * 添加调动 添加三个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer3")
    public int SubmitTransfer3(@RequestBody Transfer8003Vo transferVo){
        return  transferService.SubmitTransfer3(transferVo);
    }

    /**
     * 添加调动 添加两个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer2")
    public int SubmitTransfer2(@RequestBody Transfer8003Vo transferVo){
        return  transferService.SubmitTransfer2(transferVo);
    }

    /**
     * 添加调动 添加一个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer1")
    @HystrixCommand(fallbackMethod = "SubmitTransfer1ExamineHystixGet")
    public Object SubmitTransfer1(@RequestBody Transfer8003Vo transferVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.SubmitTransfer1(transferVo));
        return map1;
    }

    public Object SubmitTransfer1ExamineHystixGet(@RequestBody Transfer8003Vo transferVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据部门名称查询该部门是否有部门经理
     * @param staff
     * @return
     */
    @PostMapping("selectDeptPost")
    @HystrixCommand(fallbackMethod = "selectDeptPostExamineHystixGet")
    public Object selectDeptPost(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", transferService.selectDeptPost(staff));
        return map1;
    }
    public Object selectDeptPostExamineHystixGet(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
