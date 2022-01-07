package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.StaffVo;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
public interface StaffService {
    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    IPage<StaffVo> selectStaff(StaffVo staffVo);

}
