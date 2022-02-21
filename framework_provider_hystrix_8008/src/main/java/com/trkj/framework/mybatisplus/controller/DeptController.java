package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.service.DeptService;
import com.trkj.framework.util.Fuse8008Util;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private Fuse8008Util fuse8008Util;
    /**
     * 修改调动后的部门
     * @param deptId
     * @return
     */
    @PutMapping("/updateDeptName")
    @HystrixCommand(fallbackMethod = "updateDeptNameHystix")
    public Map<String ,Object> updateDeptName(@RequestBody Dept deptId){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info", deptService.updateDeptName(deptId));
        return map1;
    }

    //备选方案
    public Map<String,Object> updateDeptNameHystix(@RequestBody Dept deptId) {
        return fuse8008Util.main();
    }


}

