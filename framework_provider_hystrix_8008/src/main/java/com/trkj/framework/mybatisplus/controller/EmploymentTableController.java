package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
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

    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectpage")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selecthirepage(@RequestBody HireVo hireVo) {
        System.out.println("11111111111111111111111");
        System.out.println(hireVo);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectpage(hireVo));
        return map1;
    }
    // 备选方案
    public Object HystixGet(@RequestBody HireVo hireVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /**
     * 查询已录用放弃入职的员工
     * @param hireVo
     * @return
     */
    @PostMapping("/selectabandon")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectabandon(@RequestBody HireVo hireVo) {
        System.out.println("11111111111111111111111");
        System.out.println(hireVo);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectabandon(hireVo));
        return map1;
    }
    // 备选方案
    public Object HystixGet2(@RequestBody HireVo hireVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectwork")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectwork(@RequestBody WorkVo workVo) {
        System.out.println("11111111111111111111111");
        System.out.println(workVo);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectwork(workVo));
        return map1;
    }
    // 备选方案
    public Object HystixGet3(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkAll")
    @HystrixCommand(fallbackMethod = "HystixGet4")
    public Object selectWorkAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectWorkAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet4(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    @PostMapping("/selectpost")
    @HystrixCommand(fallbackMethod = "HystixGet5")
    public Object selectpost(@RequestBody FullVo fullVo) {
        System.out.println("11111111111111111111111");
        System.out.println(fullVo);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",employmentTableService.selectpost(fullVo));
        return map1;
    }
    // 备选方案
    public Object HystixGet5(@RequestBody FullVo fullVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 添加员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    @HystrixCommand(fallbackMethod = "HystixGet6")
    public Object insertStaff(@RequestBody HireVo hireVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",employmentTableService.insertStaff(hireVo));
        return map1;
    }
    //备选方案
    public Object HystixGet6(@RequestBody HireVo hireVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改录用状态为已入职
     * @param
     * @return
     */
    @PutMapping("updateEmploymentState")
    public int updateEmploymentState(@RequestBody EmploymentTable employmentId){
        employmentId.setEmploymentState(1L);
        final var i = employmentTableService.updateEmploymentState(employmentId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 修改录用状态为已放弃以及放弃原因
     * @param employmentId
     * @return
     */
    @PutMapping("/updateEmploymentStateAndWaiveReasonInt")
    public int updateEmploymentStateAndWaiveReasonInt(@RequestBody EmploymentTable employmentId){
        employmentId.setEmploymentState(2L);
        employmentId.setWaiveReason(employmentId.getWaiveReason());
        final var i = employmentTableService.updateEmploymentStateAndWaiveReasonInt(employmentId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryAll")
    @HystrixCommand(fallbackMethod = "HystixGet7")
    public Object selectGloryAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectGloryAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet7(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishAll")
    @HystrixCommand(fallbackMethod = "HystixGet8")
    public Object selectPunishAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectPunishAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet8(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectEducationAll")
    @HystrixCommand(fallbackMethod = "HystixGet9")
    public Object selectEducationAll(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectEducationAll(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet9(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @PostMapping("/selectWorkOne")
    @HystrixCommand(fallbackMethod = "HystixGet10")
    public Object selectWorkOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", employmentTableService.selectWorkOne(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet10(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
    @GetMapping("/two")
    public Object two(){
        return "two";
    }
}

