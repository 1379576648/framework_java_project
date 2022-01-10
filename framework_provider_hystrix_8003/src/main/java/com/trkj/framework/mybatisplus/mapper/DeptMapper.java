package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.vo.DeptPostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    @Select("select d.POST_NAME,s.STAFF_NAME from DEPT_POST d LEFT JOIN DEPT a on d.DEPT_ID = a.Dept_ID LEFT JOIN STAFF s on d.DEPT_ID = s.DEPT_ID and d.DEPT_POST_ID = s.DEPT_POST_ID ${ew.customSqlSegment}")
    List<DeptPostVo> selectpresident(@Param(Constants.WRAPPER) QueryWrapper<DeptPostVo> queryWrapper);
}
