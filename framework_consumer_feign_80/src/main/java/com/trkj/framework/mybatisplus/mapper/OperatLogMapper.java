package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 操作日志表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-02-10
 */
@Mapper
public interface OperatLogMapper extends BaseMapper<OperatLog> {

}
