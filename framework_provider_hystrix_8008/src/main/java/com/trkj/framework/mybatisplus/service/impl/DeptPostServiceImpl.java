package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.DeptPostMapper;
import com.trkj.framework.mybatisplus.service.DeptPostService;
import com.trkj.framework.mybatisplus.service.DeptService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 部门职位表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class DeptPostServiceImpl implements DeptPostService {

    @Autowired
    private DeptPostMapper deptPostMapper;



}
