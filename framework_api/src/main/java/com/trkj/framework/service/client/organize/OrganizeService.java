package com.trkj.framework.service.client.organize;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.OrganizeServiceFallbackfactory;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "REGISTER-8009/provider", fallbackFactory = OrganizeServiceFallbackfactory.class)
public interface OrganizeService {

    /**
     * 查询所有部门
     */
    @PostMapping("/selectDept")
    Map<String,Object> selectDept(@RequestBody Dept dept);
    /**
     * 查询所有职位
     */
    @PostMapping("/selectDeptPost")
    Map<String,Object> selectDeptPost(@RequestBody DeptPost deptPost);
    /**
     * 删除职位
     */
    @DeleteMapping("/scDeptPost/{id}")
    Map<String,Object> scDeptPost(@PathVariable("id") Integer id);
    /**
     * 新增职位
     */
    @PostMapping("/xzDeptPost")
    Map<String,Object> xzDeptPost(@RequestBody DeptPost deptPost);
    /**
     * 新增部门
     */
    @PostMapping("/xzDept")
    Map<String,Object> xzDept(@RequestBody Dept dept);
    /**
     * 查询部门
     */
    @GetMapping("/cxDept")
    Map<String,Object> cxDept();
    /**
     * 查询员工
     */
    @GetMapping("/selectStaffF")
    Map<String,Object> selectStaffF();
    /**
     * 修改部门
     */
    @PutMapping("/upDept")
    Map<String,Object> upDept(@RequestBody Dept dept);
}
