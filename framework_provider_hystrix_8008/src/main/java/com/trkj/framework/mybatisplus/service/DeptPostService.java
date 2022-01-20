package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.DeptPost;

/**
 * <p>
 * 部门职位表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface DeptPostService {
    /**
     * 修改调动后的职位
     * @param deptPost
     * @return
     */
    int updateDeptPostName(DeptPost deptPost);


}
