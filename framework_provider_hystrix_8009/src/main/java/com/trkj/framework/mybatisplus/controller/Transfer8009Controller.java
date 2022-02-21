package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.service.Transfer8009Service;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     *  查询所有部门
     * @param
     * @return
     */
    @PostMapping("/selectDept")
//    @HystrixCommand(fallbackMethod = "selectDepHystrix")
    public  Map<String ,Object> selectDept(@RequestBody Dept deptVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",transferService.selectDept(deptVo));
        return map1;
    }
    //备选
    public  Map<String ,Object> selectDepHystrix(@RequestBody DeptVo deptVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
