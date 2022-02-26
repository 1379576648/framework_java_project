package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.WageTableVo;

public interface WageTableService {
    /**
     * 查询工资表
     * @param staff
     * @return
     */
    IPage<Staff> selectWage(Staff staff);


}
