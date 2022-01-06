package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @Override
    public IPage<StaffVo> selectStaff(StaffVo staffVo) {
        Page<StaffVo> page = new Page<>(staffVo.getCurrentPage(),staffVo.getPagesize());
        QueryWrapper<StaffVo> queryWrapper = new QueryWrapper<>();
        //根据名称查询
        if(staffVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",staffVo.getStaffName());
        }
        return staffMapper.selectStaff(page,queryWrapper);
    }
}
