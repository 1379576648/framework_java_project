package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.mybatisplus.mapper.FixedwagfMapper;
import com.trkj.framework.mybatisplus.service.FixedwagfService;
import com.trkj.framework.vo.FixedwageVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FixedwagfServiceImpI implements FixedwagfService {

    @Autowired
    private FixedwagfMapper fixedwageMapper;

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @Override
    public IPage<FixedwageVo> selectFixedwage(FixedwageVo fixedwageVo) {
        Page<FixedwageVo> page = new Page<>(fixedwageVo.getCurrentPage(),fixedwageVo.getPagesize());
        QueryWrapper<FixedwageVo> queryWrapper = new QueryWrapper<>();
        //根据名称查询
        if(fixedwageVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",fixedwageVo.getStaffName());
        }
        queryWrapper.eq("d.DEPT_NAME",fixedwageVo.getDeptName());
        return fixedwageMapper.selectFixedwage(page,queryWrapper);
    }

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateFixedwage(Fixedwagf fixedwagf) {
        final var i = fixedwageMapper.updateById(fixedwagf);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }
}
