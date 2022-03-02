package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.entity.mybatisplus.Business;
import com.trkj.framework.vo.AttendandceVo;
import com.trkj.framework.vo.BusinessVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    /**
     * 查询出差方案
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT distinct b.BUSINESS_ID,t.TRAVEL_ID,b.BUSINESS_NAME,b.BUSINESS_ONEMONEY,b.BUSINESS_STATE,b.BUSINESS_REMARK,d.DEPT_NAME,b.IS_DELETED FROM BUSINESS b LEFT JOIN TRAVEL t on t.TRAVEL_ID=b.TRAVEL_ID LEFT JOIN DEPT d on d.DEPT_NAME=b.DEPT_NAME ${ew.customSqlSegment}")
    IPage<BusinessVo> selectBusiness(Page<BusinessVo> page, @Param(Constants.WRAPPER)QueryWrapper<BusinessVo> queryWrapper);

    /**
     * 根据id查询出差方案
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM BUSINESS ${ew.customSqlSegment}")
    List<Business> selectBusinessAll(@Param(Constants.WRAPPER) QueryWrapper<Business> queryWrapper);

    /**
     * 根据部门名称查询有无方案
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM BUSINESS ${ew.customSqlSegment}")
    List<Business> selectBusinessBydept(@Param(Constants.WRAPPER) QueryWrapper<Business> queryWrapper);


}
