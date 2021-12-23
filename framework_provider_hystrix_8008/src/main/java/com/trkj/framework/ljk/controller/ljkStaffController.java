package com.trkj.framework.ljk.controller;

import com.trkj.framework.entity.StaffEntity;
import com.trkj.framework.ljk.service.ljkStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ljkStaffController {
    @Autowired
    private ljkStaffService service;

    @GetMapping("/staff/findCreated")
    public List<StaffEntity> findCreated(){
        return service.findCreated();
    }

    @GetMapping("/staff/get/{id}")
    private List<StaffEntity> findCreatedById(@PathVariable("id") Long id){
        return service.findCreatedById(id);
    }

    @GetMapping("/staff/getByName/{name}")
    private List<StaffEntity> findCreatedLikeByName(@PathVariable("name") String name){
        String str="%"+name+"%";
        System.out.println(str);
        return service.findCreatedLikeByName(str);
    }
}
