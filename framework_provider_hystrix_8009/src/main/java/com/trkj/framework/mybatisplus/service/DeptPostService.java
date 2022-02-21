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
}
