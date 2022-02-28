package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.vo.DeptPostVo;

public interface DeptPostService {
    /**
     * 查询所有职位
     * @param
     * @return
     */
    Object selectDeptPost(DeptPost deptPost);
    /**
     * 删除职位
     * @param
     * @return
     */
    String scDeptPost(Integer id);
    /**
     * 新增职位
     * @param
     * @return
     */
    String xzDeptPost(DeptPost deptPost);
    /**
     * 查询所有部门
     * @param
     * @return
     */
    Object cxDept();

}
