package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatis.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
public interface DeptService extends IService<Dept> {
    Dept deptId(Integer id);
}
