package com.trkj.framework.controller;

import com.trkj.framework.service.client.register.RegisterClinetService;
import com.trkj.framework.util.JwtTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterClinetService registerClinetService = null;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public AjaxResponse register(@RequestBody Map<String, Object> map) {
        return AjaxResponse.success(registerClinetService.register(map));
    }
    @GetMapping("/toLogin")
    public String toLogin(@RequestParam("name") String name, @RequestParam("id") String id){
        String token=jwtTokenUtil.generateToken(name,id);
        System.out.println(token);
        return "index";
    }
    @GetMapping("/qw")
    public String qw(){
        return "不是吧";
    }
}
