package com.trkj.framework.mybatisplus.mapper.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import com.trkj.framework.util.Fuse8009Util;
import com.trkj.framework.vo.DeptPostVo;
import com.trkj.framework.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 职位查询
 *
 * @author 赖云涛
 * @since 2022-2-21
 */
@RestController
public class DeptPostController {
    @Autowired
    private DeptPostService deptPostService;

    @Autowired
    private Fuse8009Util fuse8009Util;
    /**
     *  查询所有职位
     * @param
     * @return
     */
    @PostMapping("/selectDeptPost")
    @HystrixCommand(fallbackMethod = "selectDeptPostF")
    public Map<String,Object> selectDeptPost(@RequestBody DeptPost deptPost){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",deptPostService.selectDeptPost(deptPost));
        return map1;
    }
    //备选
    public  Map<String ,Object> selectDeptPostF(@RequestBody DeptPost deptPost) {
       return fuse8009Util.main();
    }
    /**
     *  删除职位
     * @param
     * @return
     */
    @DeleteMapping("/scDeptPost/{id}")
    @HystrixCommand(fallbackMethod = "scDeptPostF")
    public Map<String,Object> scDeptPost(@PathVariable("id") Integer id){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",deptPostService.scDeptPost(id));
        return map1;
    }
    //备选
    public  Map<String ,Object> scDeptPostF(@PathVariable("id") Integer id) {
        return fuse8009Util.main();
    }
    /**
     *  新增职位
     * @param
     * @return
     */
    @PostMapping("/xzDeptPost")
    @HystrixCommand(fallbackMethod = "xzDeptPostF")
    public Map<String,Object> xzDeptPost(@RequestBody DeptPost deptPost){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",deptPostService.xzDeptPost(deptPost));
        return map1;
    }
    //备选
    public  Map<String ,Object> xzDeptPostF(@RequestBody DeptPost deptPost) {
        return fuse8009Util.main();
    }
    /**
     *  查询所有部门
     * @param
     * @return
     */
    @GetMapping("/cxDept")
    @HystrixCommand(fallbackMethod = "cxDeptF")
    public Map<String,Object> cxDept(){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",deptPostService.cxDept());
        return map1;
    }
    //备选
    public  Map<String ,Object> cxDeptF() {
        return fuse8009Util.main();
    }
}
