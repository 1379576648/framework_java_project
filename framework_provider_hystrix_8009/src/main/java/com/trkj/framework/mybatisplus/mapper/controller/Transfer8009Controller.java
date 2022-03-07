package com.trkj.framework.mybatisplus.mapper.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.service.Transfer8009Service;
import com.trkj.framework.util.Fuse8009Util;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 部门查询
 *
 * @author 赖云涛
 * @since 2022-1-14
 */
@RestController
public class Transfer8009Controller {
    @Autowired
    private Transfer8009Service transferService;

    @Autowired
    private Fuse8009Util fuse8009Util;
    /**
     *  查询所有部门
     * @param
     * @return
     */
    @PostMapping("/selectDept")
    @HystrixCommand(fallbackMethod = "selectDepHystrix")
    public  Map<String ,Object> selectDept(@RequestBody Dept deptVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.selectDept(deptVo));
        return map1;
    }
    //备选
    public  Map<String ,Object> selectDepHystrix(@RequestBody Dept deptVo) {
        return fuse8009Util.main();
    }
    /**
     * 查询所有员工
     * @param
     * @return
     */
    @GetMapping("/selectStaffF")
    @HystrixCommand(fallbackMethod = "selectStaffX")
    public Map<String ,Object> selectStaffF(){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.selectStaffF());
        return map1;
    }
    //备选
    public  Map<String ,Object> selectStaffX() {
        return fuse8009Util.main();
    }
    /**
     * 新增部门
     * @param
     * @return
     */
    @PostMapping("/xzDept")
    @HystrixCommand(fallbackMethod = "xzDeptF")
    public Map<String,Object> xzDept(@RequestBody Dept dept){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.xzDept(dept));
        return map1;
    }
    //备选
    public  Map<String ,Object> xzDeptF(@RequestBody Dept dept) {
        return fuse8009Util.main();
    }
    /**
     * 修改部门
     * @param
     * @return
     */
    @PutMapping("/upDept")
    @HystrixCommand(fallbackMethod = "upDaptF")
    public Map<String,Object> upDept(@RequestBody Dept dept){
        Map<String,Object> map1= new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.upDept(dept));
        return map1;
    }
    //备选
    public  Map<String ,Object> upDaptF(@RequestBody Dept dept) {
        return fuse8009Util.main();
    }
}
