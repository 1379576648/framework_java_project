package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatis.Dept;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept deptId(Integer id) {
        return deptMapper.selectById(id);
    }
}
