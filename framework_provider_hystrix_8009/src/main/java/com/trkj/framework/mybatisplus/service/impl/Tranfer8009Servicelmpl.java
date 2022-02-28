package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.Transfer8009Service;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Tranfer8009Servicelmpl implements Transfer8009Service {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询所有部门与模糊查询
     * @param
     * @return
     */
    @Override
    public Object selectDept(Dept deptVo) {
        //创建分页
        Page<Dept> page = new Page<Dept>(deptVo.getCurrentPage(),deptVo.getPagesize());
        //条件构造器
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
        //逻辑删除 未删除
        queryWrapper.eq("s.IS_DELETED", 0);
        //判断部门是否为空
        if (deptVo.getDeptName() != null && !deptVo.getDeptName().equals("")) {
            //模糊查询
            queryWrapper.like("d.DEPT_NAME", deptVo.getDeptName());
        }
        if (deptVo.getStaffName() != null && !deptVo.getStaffName().equals("")){
            //
            queryWrapper.like("s.STAFF_NAME",deptVo.getStaffName());
        }
        return deptMapper.selectDeptw(page, queryWrapper);

    }

    /**
     * 修改部门
     * @param
     * @return
     */
    @Override
    public String upDept(Dept dept) {
        if (deptMapper.updateById(dept)<=0){
            return "修改失败！";
        }
        return "成功";
    }
    /**
     * 查询所有员工
     * @param
     * @return
     */
    @Override
    public Object selectStaffF() {
        QueryWrapper queryWrapper=new QueryWrapper();
        return staffMapper.selectList(queryWrapper);
    }
    /**
     * 新增部门
     * @param
     * @return
     */
    @Override
    public String xzDept(Dept dept) {
        if (deptMapper.insert(dept)<=0){
            return "新增失败！";
        }
        return "成功";
    }


}
