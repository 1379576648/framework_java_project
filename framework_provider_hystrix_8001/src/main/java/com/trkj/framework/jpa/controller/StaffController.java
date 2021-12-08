package com.trkj.framework.jpa.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.distinguish.service.MethodService;
import com.trkj.framework.jpa.service.StaffService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private MethodService methodService;
    @PostMapping("/register")
    @HystrixCommand(fallbackMethod = "registerHystrix")
    public AjaxResponse register(@RequestBody Map<String, Object> map) throws Exception {
        AjaxResponse response = new AjaxResponse();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",200);
        System.out.println(map.get("base"));
        Map<String,Object> map2=methodService.faceSelect(String.valueOf(map.get("base")));
        if (map2.get("成功")==null){
            map1.put("error",map2.get("失败"));
        }else{
            map1.put("succeed",staffService.selectStaff(Integer.parseInt(map2.get("成功").toString())));
        }
        response.setData(map1);
        return  response;
    }
    //备选方法
    public AjaxResponse registerHystrix(@RequestBody Map<String, Object> map){
        AjaxResponse response = new AjaxResponse();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        response.setData(map1);
        return response;
    }
}
