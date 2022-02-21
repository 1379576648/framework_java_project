package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 13795
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    @Select("select  d.*, s.DEPT_NAME, c.STAFF_NAME from  DEPT_POST d left join DEPT s on d.DEPT_ID= s.DEPT_ID ${ew.customSqlSegment}")
    IPage<Dept> selectDeptw(Page<Dept> page, @Param(Constants.WRAPPER) QueryWrapper<Dept> queryWrapper);
}
