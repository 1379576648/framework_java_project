package com.trkj.framework.jpa.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.distinguish.service.MethodService;
import com.trkj.framework.entity.jpa.RegisterLogEntity;
import com.trkj.framework.entity.jpa.StaffEntity;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.jpa.service.StaffService;
import com.trkj.framework.util.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /***
     * 人脸登录
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String, Object> map) throws Exception {
        try{
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
            map1.put("succeed", "账号或密码有误");
            //如果员工不为空
            if (staff != null) {
                //返回菜单列表
                if (staff.getStaffState().equals(2)){
                    map1.put("succeed", "离职用户,请联系管理员");
                }else{
                    map1.put("succeed", "成功");
                }
                map1.put("menuList", staffService.menuList(staff.getStaffId()));
                map1.put("token", jwtTokenUtil.generateToken(staff.getStaffName(),staff.getStaffId(),staffService.selectPostName(staff.getDeptPostId())));
                map1.put("info",staff);

            }

        }
        return map1;
        }catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map1 = new HashMap<>(2);
            map1.put("state", 300);
            map1.put("info", "服务器异常，请稍后再试");
            return map1;
        }
    }


    /***
     * 使用手机号码以及密码进行登录
     * @param map
     * @return
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String, Object> map) throws InterruptedException {
        try {
            //初始化储藏
            Map<String, Object> map1 = new HashMap<>(2);
            //状态码
            map1.put("state", 200);
            StaffEntity staffEntity = staffService.findStaffByPhoneAndPass(map);
            //成功结果
            map1.put("succeed", "账号或密码有误");
            if (staffEntity != null) {
                if (staffEntity.getError() == null) {
                    if (staffEntity.getStaffState().equals(2)){
                        map1.put("succeed", "离职用户,请联系管理员");
                    }else{
                        map1.put("succeed", "成功");
                    }
                    Thread.sleep(1000);
                    map1.put("menuList", staffService.menuList(staffEntity.getStaffId()));
                    map1.put("token", jwtTokenUtil.generateToken(staffEntity.getStaffName(),staffEntity.getStaffId(),staffService.selectPostName(staffEntity.getDeptPostId())));
                    map1.put("info",staffEntity);
                }else{
                    map1.put("succeed", "成功");
                    map1.put("info",staffEntity);
                }
            }
            return map1;

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map1 = new HashMap<>(2);
            map1.put("state", 300);
            map1.put("info", "服务器异常，请稍后再试");
            return map1;
        }
    }

}
