package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Transfer;
import com.trkj.framework.vo.Transfer8003Vo;
import com.trkj.framework.vo.TransferVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransferMapper extends BaseMapper<Transfer> {

    @Select("select distinct  a.AUDITFLOW_STATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID = b.AUDITFLOW_ID LEFT JOIN TRANSFER c on a.AUDITFLOW_ID = c.AUDITFLOW_ID ${ew.customSqlSegment}")
    List<Transfer8003Vo> selectTransferRecord(@Param(Constants.WRAPPER) QueryWrapper<Transfer8003Vo> queryWrapper);
}
