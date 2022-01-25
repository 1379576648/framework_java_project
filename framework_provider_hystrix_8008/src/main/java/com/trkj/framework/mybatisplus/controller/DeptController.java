package com.trkj.framework.mybatisplus.controller;


import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.service.DeptService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    /**
     * 修改调动后的部门
     * @param deptId
     * @return
     */
    @PutMapping("/updateDeptName")
    public Object updateDeptName(@RequestBody Dept deptId){
        //部门名称
        deptId.setDeptName(deptId.getDeptName());
        final var i = deptService.updateDeptName(deptId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }


}

