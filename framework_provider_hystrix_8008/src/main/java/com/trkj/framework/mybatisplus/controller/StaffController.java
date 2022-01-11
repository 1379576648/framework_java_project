package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectStaff(@RequestBody StaffVo staffVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",staffService.selectStaff(staffVo));
        return map1;
    }

    // 备选方案
    public Object HystixGet(@RequestBody StaffVo staffVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaffAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectStaffAll(@RequestBody StaffVo staffVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", staffService.selectStaffAll(staffVo));
        System.out.println(staffVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet2(@RequestBody StaffVo staffVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    @PostMapping("/selectQuit")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectQuit(@RequestBody StaffQuitVo staffQuitVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",staffService.selectQuit(staffQuitVo));
        return map1;
    }

    // 备选方案
    public Object HystixGet3(@RequestBody StaffQuitVo staffQuitVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /**
     * 修改员工信息
     * @param staffId
     * @return
     */
    @PostMapping("/updateStaff")
    public Object updateStaff(@RequestBody Staff staffId){
         //出生日期
         staffId.setStaffBirthday(staffId.getStaffBirthday());
         //婚姻状态
        staffId.setStaffMarital(staffId.getStaffMarital());
        //学历
        staffId.setStaffEducation(staffId.getStaffEducation());
        //身份证
        staffId.setStaffIdentity(staffId.getStaffIdentity());
        //性别
        staffId.setStaffSex(staffId.getStaffSex());
        //政治面貌
        staffId.setStaffOutlook(staffId.getStaffOutlook());
        //户口所在地
        staffId.setStaffRegistered(staffId.getStaffRegistered());
        //毕业学校
        staffId.setStaffSchool(staffId.getStaffSchool());
        //银行卡号
        staffId.setStaffCredit(staffId.getStaffCredit());
        //血型
        staffId.setStaffBlood(staffId.getStaffBlood());
        //星座
        staffId.setStaffSign(staffId.getStaffSign());
        //年龄
        staffId.setStaffAge(staffId.getStaffAge());
        final var i = staffService.updateStaff(staffId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }

    }

    /**
     * 修改员工信息2
     * @param staffId
     * @return
     */
    @PostMapping("/updateStaffTwo")
    public Object updateStaffTwo(@RequestBody Staff staffId){
        //手机号
        staffId.setStaffPhone(staffId.getStaffPhone());
        //个人邮箱
        staffId.setStaffEmail(staffId.getStaffEmail());
        //微信
        staffId.setStaffWechat(staffId.getStaffWechat());
        //QQ
        staffId.setStaffQq(staffId.getStaffQq());
        //现住地址
        staffId.setStaffAddress(staffId.getStaffAddress());
        //紧急联系人
        staffId.setStaffEmergency(staffId.getStaffEmergency());
        final var i = staffService.updateStaffTwo(staffId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }



}

