package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatis.Dept;
import com.trkj.framework.mybatisplus.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/mybatisplus/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/deptId/{id}")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = deptService.deptId(id);
        if (dept == null) {
            throw new RuntimeException("id=>" + id + ".不存在该用户，或者信息无法找到~");
        }
        return dept;
    }

    // 备选方案
    public Dept HystixGet(@PathVariable("id") Integer id) {
        return new Dept().setDeptId(id).setDeptName("id=>" + "没有对应的信息，null--@Hystix");
    }
}

