package com.trkj.framework.service.client.organize;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.OrganizeServiceFallbackfactory;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
