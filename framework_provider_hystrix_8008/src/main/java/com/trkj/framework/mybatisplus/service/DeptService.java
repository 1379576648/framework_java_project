package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.Dept;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface DeptService {
    /**
     * 修改调动后的部门
     * @param dept
     * @return
     */
    int updateDeptName(Dept dept);


}
