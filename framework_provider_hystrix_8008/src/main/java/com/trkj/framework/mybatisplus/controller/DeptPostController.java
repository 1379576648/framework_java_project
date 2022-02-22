package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import com.trkj.framework.mybatisplus.service.DeptService;
import com.trkj.framework.util.Fuse8008Util;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 部门职位表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class DeptPostController {

    @Autowired
    private DeptPostService deptPostService;

    @Autowired
    private Fuse8008Util fuse8008Util;

}

