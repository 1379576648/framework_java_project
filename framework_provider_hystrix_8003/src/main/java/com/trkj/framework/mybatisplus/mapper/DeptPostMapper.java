package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptPostMapper extends BaseMapper<DeptPost> {
}
