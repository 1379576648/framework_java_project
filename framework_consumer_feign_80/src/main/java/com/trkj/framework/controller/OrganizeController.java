package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.service.client.organize.OrganizeService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrganizeController {
    @Autowired
    private OrganizeService organizeService=null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 查询所有部门
     * @param dept
     * @return
     */
    @PostMapping("/selectDept")
    public AjaxResponse selectDept(@RequestBody Dept dept){
        Map<String,Object> map = (Map<String, Object>) organizeService.selectDept(dept);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
    /**
     * 查询所有职位
     * @param
     * @return
     */
    @PostMapping("/selectDeptPostF")
    public AjaxResponse selectDeptPost(@RequestBody DeptPost deptPost){
        Map<String,Object> map=(Map<String, Object>) organizeService.selectDeptPost(deptPost);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
    /**
     * 查询所有职位
     * @param
     * @return
     */
    @DeleteMapping("/scDeptPost/{id}")
    public AjaxResponse scDeptPost(@PathVariable("id") Integer id){
        Map<String,Object> map=(Map<String, Object>) organizeService.scDeptPost(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
