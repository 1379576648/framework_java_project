package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReissueCardManager extends BaseMapper<Card> {
}
