package com.trkj.framework.mybatisplus.mapper;

import com.trkj.framework.mybatisplus.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-22
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
