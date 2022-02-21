package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.service.DeptService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 修改调动后的部门
     * @param dept
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDeptName(Dept dept) {
        final var i = deptMapper.updateById(dept);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }



}
