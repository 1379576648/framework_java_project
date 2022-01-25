package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.InsuredPayment;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 参保方案表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */

@Mapper
public interface InsuredPaymentMapper extends BaseMapper<InsuredPayment> {

}
