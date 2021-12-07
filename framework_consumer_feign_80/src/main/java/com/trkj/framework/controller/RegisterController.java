package com.trkj.framework.controller;

import com.trkj.framework.service.client.register.RegisterClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterClinetService registerClinetService = null;

    @PostMapping("/register")
    public AjaxResponse register(@RequestBody Map<String, Object> map) {
        return registerClinetService.register(map);
    }
}
