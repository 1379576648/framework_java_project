package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.mybatisplus.service.QuitService;
import com.trkj.framework.util.Fuse8003Util;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 离职 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class QuitController {
    @Autowired
    private QuitService quitService;
    @Autowired
    private Fuse8003Util fuse8003Util;
    /**
     * 根据审批类型的离职/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectQuitAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Map<String, Object> selectQuitAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", quitService.selectQuitAll(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet1(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndQuitAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Map<String, Object> selectEndQuitAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", quitService.selectEndQuitAll(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet2(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsQuit")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Map<String, Object> selectDetailsQuit(@RequestBody QuitDetailsVo quitDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", quitService.selectDetailsQuit(quitDetailsVo));
        return map1;
    }

    public Map<String, Object> HystixGet3(@RequestBody QuitDetailsVo quitDetailsVo) {
        return fuse8003Util.main();
    }

    /**
     * 根据员工名称是否有离职记录
     *
     * @param quitDetailsVo
     * @return
     */
    @PostMapping("/selectDimissionRecord")
    @HystrixCommand(fallbackMethod = "selectDimissionRecordHystixGet")
    public Map<String, Object> selectDimissionRecord(@RequestBody QuitDetailsVo quitDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", quitService.selectDimissionRecord(quitDetailsVo));
        return map1;
    }

    public Map<String, Object> selectDimissionRecordHystixGet(@RequestBody QuitDetailsVo quitDetailsVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加离职 添加三个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave3")
    @HystrixCommand(fallbackMethod = "submitToLeave3ExamineHystixGet")
    public Map<String, Object> submitToLeave3(@RequestBody QuitVo quitVo) throws ArithmeticException{
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", quitService.submitToLeave3(quitVo));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToLeave3ExamineHystixGet(@RequestBody QuitVo quitVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加离职 添加两个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave2")
    @HystrixCommand(fallbackMethod = "submitToLeave2ExamineHystixGet")
    public Map<String, Object> submitToLeave2(@RequestBody QuitVo quitVo) throws ArithmeticException{
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", quitService.submitToLeave2(quitVo));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToLeave2ExamineHystixGet(@RequestBody QuitVo quitVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加离职 添加一个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave1")
    @HystrixCommand(fallbackMethod = "submitToLeave1ExamineHystixGet")
    public Map<String, Object> submitToLeave1(@RequestBody QuitVo quitVo) throws ArithmeticException{
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", quitService.submitToLeave1(quitVo));
        }catch (ArithmeticException e){
            map1.put("info",e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToLeave1ExamineHystixGet(@RequestBody QuitVo quitVo) {
        return fuse8003Util.main();
    }
}
