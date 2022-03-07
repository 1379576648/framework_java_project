package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FixedwagfMapper extends BaseMapper<Fixedwagf> {

    @Select("select FIXEDWAGE_OFFICIALMONEY from FIXEDWAGE ${ew.customSqlSegment}")
    Double selectPay(@Param(Constants.WRAPPER) QueryWrapper<Fixedwagf> queryWrapper);

}
