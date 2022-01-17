package com.trkj.framework.jpa.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.distinguish.service.MethodService;
import com.trkj.framework.entity.jpa.RegisterLogEntity;
import com.trkj.framework.entity.jpa.StaffEntity;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.jpa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private MethodService methodService;

    /***
     * 人脸登录
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    @HystrixCommand(fallbackMethod = "registerHystrix")
    public Object register(@RequestBody Map<String, Object> map) throws Exception {
        //初始化储藏
        Map<String, Object> map1 = new HashMap<>(2);
        //初始化状态码
        map1.put("state", 200);
        //人脸识别状态
        Map<String, Object> map2 = methodService.faceSelect(String.valueOf(map.get("base")));
        //如果成功等于空
        if (map2.get("成功") == null) {
            //存入失败的结果
            map1.put("error", map2.get("失败"));
        } else {
            //存入到map
            map.put("成功", map2.get("成功"));
            StaffEntity staff = staffService.staffId(map);
            //返回员工信息
            map1.put("succeed", staff);
            //如果员工不为空
            if (staff != null) {
                //返回菜单列表
                map1.put("menuList", staffService.menuList(staff.getStaffId()));
            }

        }
        return map1;
    }

    //备选方法
    public Object registerHystrix(@RequestBody Map<String, Object> map) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 使用手机号码以及密码进行登录
     * @param map
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestBody Map<String, Object> map) throws InterruptedException {
        try {
            //初始化储藏
            Map<String, Object> map1 = new HashMap<>(2);
            //状态码
            map1.put("state", 200);
            StaffEntity staffEntity = staffService.findStaffByPhoneAndPass(map);
            //成功结果
            map1.put("succeed", staffEntity);
            if (staffEntity != null) {
                if (staffEntity.getError() == null) {
                    Thread.sleep(1000);
                    map1.put("menuList", staffService.menuList(staffEntity.getStaffId()));
                } else {
                    map1.put("menuList", "");
                }
            } else {
                map1.put("menuList", "");
            }
            return map1;

        } catch (Exception e) {
            Map<String, Object> map1 = new HashMap<>(2);
            map1.put("state", 300);
            map1.put("info", "服务发生雪崩");
            return map1;
        }
    }

}
