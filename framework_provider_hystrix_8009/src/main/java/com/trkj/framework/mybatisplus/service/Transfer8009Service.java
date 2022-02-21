package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.vo.DeptVo;

import java.util.List;

public interface Transfer8009Service {
    /**
     * 查询所有部门
     * @param
     * @return
     */
    Object selectDept(Dept deptVo);
    /**
     * 修改调动后的职位
     * @param
     * @return
     */
    int updateDept(Dept deptXg);


}
