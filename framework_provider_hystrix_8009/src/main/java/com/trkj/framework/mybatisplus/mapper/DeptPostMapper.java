package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptPostMapper extends BaseMapper<DeptPost> {
    //d--职位 s--组织 c--员工
    @Select("select  d.*, s.DEPT_NAME,s.STAFF_ID,s.DEPT_STATE, c.STAFF_NAME from  DEPT_POST d left join DEPT s on d.DEPT_ID= s.DEPT_ID   left join STAFF c on s.STAFF_ID= c.STAFF_ID ${ew.customSqlSegment}")
    IPage<DeptPost> selectDeptpost(Page<DeptPost> page, @Param(Constants.WRAPPER) QueryWrapper<DeptPost> queryWrapper);

}
