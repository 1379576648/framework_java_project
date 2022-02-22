package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.mapper.DeptPostMapper;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptPostServicelmpl implements DeptPostService {
    @Autowired
    private DeptPostMapper deptPostMapper;

    @Override
    public Object selectDeptPost(DeptPost deptPost) {
        //创建分页
        Page<DeptPost> page = new Page<DeptPost>(deptPost.getCurrentPage(),deptPost.getPagesize());
        //条件构造器
        QueryWrapper<DeptPost> queryWrapper = new QueryWrapper<DeptPost>();
        //逻辑删除 未删除
        queryWrapper.eq("s.IS_DELETED", 0);
        //判断职位是否为空
        if (deptPost.getPostName() != null && !deptPost.getPostName().equals("")) {
            //模糊查询
            queryWrapper.like("d.POST_NAME", deptPost.getPostName());
        }
        return deptPostMapper.selectDeptpost(page, queryWrapper);
    }

    @Override
    public String scDeptPost(Integer id) {
        if (deptPostMapper.deleteById(id)<=0){
          return "删除失败";
        }
        return "成功";
    }

}
