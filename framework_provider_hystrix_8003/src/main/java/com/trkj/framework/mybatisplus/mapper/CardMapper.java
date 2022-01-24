package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.vo.CardDetailsVo;
import com.trkj.framework.vo.OvertimeaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CardMapper extends BaseMapper<Card> {

    @Select("select distinct  a.AUDITFLOW_STATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID = b.AUDITFLOW_ID LEFT JOIN CARD c on a.AUDITFLOW_ID = c.AUDITFLOW_ID ${ew.customSqlSegment}")
    List<CardDetailsVo> selectCardExamine(@Param(Constants.WRAPPER) QueryWrapper<CardDetailsVo> queryWrapper);
}
