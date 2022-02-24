package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.entity.mybatisplus.Business;
import com.trkj.framework.mybatisplus.mapper.AttendandceMapper;
import com.trkj.framework.mybatisplus.mapper.BusinessMapper;
import com.trkj.framework.mybatisplus.service.AttendandceService;
import com.trkj.framework.mybatisplus.service.BusinessService;
import com.trkj.framework.vo.AttendandceVo;
import com.trkj.framework.vo.BusinessVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessServiceImpI implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    /**
     * 查询出差方案
     * @param businessVo
     * @return
     */
    @Override
    public IPage<BusinessVo> selectBusiness(BusinessVo businessVo) {
        Page<BusinessVo> page = new Page<>(businessVo.getCurrentPage(),businessVo.getPagesize());
        QueryWrapper<BusinessVo> queryWrapper = new QueryWrapper<>();
        //根据方案名称查询
        if(businessVo.getBusinessName()!=null){
            queryWrapper.like("b.BUSINESS_NAME",businessVo.getBusinessName());
        }
        //queryWrapper.eq("d.DEPT_NAME",workSchemeVo.getDeptName());
        queryWrapper.eq("b.IS_DELETED",0);
        return businessMapper.selectBusiness(page,queryWrapper);
    }

    /**
     * 添加出差方案
     * @param business
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBusiness(Business business) {
        return businessMapper.insert(business);
    }

    /**
     * 修改状态为禁用
     * @param business
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBusinessState(Business business) {
        final var i = businessMapper.updateById(business);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改状态为启用
     * @param business
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBusinessStateTwo(Business business) {
        final var i = businessMapper.updateById(business);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 删除出差方案
     * @param id
     * @return
     */
    @Override
    public String deleteBusiness(Integer id) {
        String s = "成功";
        if (businessMapper.deleteById(id)<=0){
            return "删除出差方案失败";
        }
        return s;
    }

    /**
     * 根据id查询出差方案
     * @param business
     * @return
     */
    @Override
    public List<Business> selectBusinessAll(Business business) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("BUSINESS_ID",business.getBusinessId());
        return businessMapper.selectBusinessAll(queryWrapper);
    }



    /**
     * 修改出差方案
     * @param business
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBusiness(Business business) {
        final var i = businessMapper.updateById(business);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }
}
