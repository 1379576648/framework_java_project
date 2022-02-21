package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
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

    @Override
    public Object selectDept(Dept deptVo) {
        //创建分页
        Page<Dept> page = new Page<Dept>(deptVo.getCurrentPage(),deptVo.getPagesize());
        //条件构造器
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
        //逻辑删除 未删除
        queryWrapper.eq("s.IS_DELETED", 0);
        return deptMapper.selectDeptw(page, queryWrapper);
    }

    /**
     * 修改调动后的部门
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDept(Dept deptXg) {
        final var i = deptMapper.updateById(deptXg);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }
}
