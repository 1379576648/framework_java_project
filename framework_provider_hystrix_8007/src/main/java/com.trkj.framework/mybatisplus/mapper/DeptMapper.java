package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 13795
 */
@Mapper
public interface DeptMapper  extends BaseMapper<Dept> {
}
