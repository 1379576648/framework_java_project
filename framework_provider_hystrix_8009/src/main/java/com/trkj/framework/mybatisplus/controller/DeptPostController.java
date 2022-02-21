package com.trkj.framework.mybatisplus.controller;

import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import com.trkj.framework.vo.DeptPostVo;
import com.trkj.framework.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    /**
     *  查询所有职位
     * @param
     * @return
     */
    @PostMapping("/selectDeptPost")
    public Map<String,Object> selectDeptPost(@RequestBody DeptPost deptPost){
        Map<String,Object>map1=new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",deptPostService.selectDeptPost(deptPost));
        return map1;
    }
    //备选
    public  Map<String ,Object> selectDepHystrix(@RequestBody DeptPostVo deptVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
