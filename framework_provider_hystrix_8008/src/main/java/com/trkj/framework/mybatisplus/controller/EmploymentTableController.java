package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.util.Fuse8008Util;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 录用表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@RestController
public class EmploymentTableController {
    @Autowired
    private EmploymentTableService employmentTableService;

    @Autowired
    private Fuse8008Util fuse8008Util;
    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectpage")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String ,Object> selecthirepage(@RequestBody HireVo hireVo) {
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectpage(hireVo));
        return map1;
    }
    //备选方案
    public Map<String,Object> hystixGet(@RequestBody HireVo hireVo) {
        return fuse8008Util.main();
    }


    /**
     * 查询已录用放弃入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectabandon")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String ,Object> selectabandon(@RequestBody HireVo hireVo) {
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectabandon(hireVo));
        return map1;
    }
    //备选方案
    public Map<String,Object> hystixGet2(@RequestBody HireVo hireVo) {
        return fuse8008Util.main();
    }

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String ,Object> selectwork(@RequestBody WorkVo workVo) {
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectwork(workVo));
        return map1;
    }
    //备选方案
    public Map<String,Object> hystixGet3(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String ,Object> selectWorkAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectWorkAll(workVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet4(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    @PostMapping("/selectpost")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String ,Object> selectpost(@RequestBody FullVo fullVo) {
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectpost(fullVo));
        return map1;
    }
    //备选方案
    public Map<String,Object> hystixGet5(@RequestBody FullVo fullVo) {
        return fuse8008Util.main();
    }

    /**
     * 添加员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    @HystrixCommand(fallbackMethod = "hystixGet6")
    public Map<String ,Object> insertStaff(@RequestBody HireVo hireVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",employmentTableService.insertStaff(hireVo));
        return map1;
    }
    //备选方案
    public Map<String,Object> hystixGet6(@RequestBody HireVo hireVo) {
        return fuse8008Util.main();
    }

    /**
     * 修改录用状态为已入职
     * @param
     * @return
     */
    @PutMapping("updateEmploymentState")
    @HystrixCommand(fallbackMethod = "updateEmploymentStateHystrix")
    public Map<String,Object> updateEmploymentState(@RequestBody EmploymentTable employmentId){
        employmentId.setEmploymentState(1L);
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.updateEmploymentState(employmentId));
        return map1;
    }

    //备选方案
    public Map<String,Object> updateEmploymentStateHystrix(@RequestBody EmploymentTable employmentId) {
        return fuse8008Util.main();
    }

    /**
     * 修改录用状态为已放弃以及放弃原因
     * @param employmentId
     * @return
     */
    @PutMapping("/updateEmploymentStateAndWaiveReasonInt")
    @HystrixCommand(fallbackMethod = "updateEmploymentStateAndWaiveReasonIntHystrix")
    public Map<String,Object> updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentId){
        employmentId.setEmploymentState(2L);
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.updateEmploymentStateAndWaiveReasonInt(employmentId));
        return map1;
    }

    //备选方案
    public Map<String,Object> updateEmploymentStateAndWaiveReasonIntHystrix(@RequestBody EmploymentTable employmentId) {
        return fuse8008Util.main();
    }

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryAll")
    @HystrixCommand(fallbackMethod = "hystixGet7")
    public Map<String ,Object> selectGloryAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectGloryAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet7(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishAll")
    @HystrixCommand(fallbackMethod = "hystixGet8")
    public Map<String ,Object> selectPunishAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectPunishAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet8(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationAll")
    @HystrixCommand(fallbackMethod = "hystixGet9")
    public Map<String ,Object> selectEducationAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectEducationAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet9(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkOne")
    @HystrixCommand(fallbackMethod = "hystixGet10")
    public Map<String ,Object> selectWorkOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectWorkOne(workVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet10(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }
}

