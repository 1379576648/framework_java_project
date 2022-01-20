package com.trkj.framework.mybatisplus.controller;


import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import com.trkj.framework.mybatisplus.service.DeptService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * 修改调动后的职位
     * @param deptPost
     * @return
     */
    @PutMapping("/updateDeptPostName")
    public Object updateDeptPostName(@RequestBody DeptPost deptPost){
        //职位名称
        deptPost.setPostName(deptPost.getPostName());
        final var i = deptPostService.updateDeptPostName(deptPost);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }


}

