package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.InsuredDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 参保明细表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Mapper
public interface InsuredDetailMapper extends BaseMapper<InsuredDetail> {

    /***
     *分页查询参保明细
     * @param staffPage
     * @param queryWrapper
     * @return
     */
    public IPage<InsuredDetail>  pageInsuredDetail(Page<InsuredDetail> staffPage, @Param(Constants.WRAPPER) QueryWrapper<InsuredDetail> queryWrapper);
}
