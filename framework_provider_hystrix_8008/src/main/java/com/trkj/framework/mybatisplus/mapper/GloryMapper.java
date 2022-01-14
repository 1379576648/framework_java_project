package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 13795
 */
@Mapper
public interface GloryMapper extends BaseMapper<Glory> {

    /**
     * 根据奖励id查询奖励
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM GLORY ${ew.customSqlSegment}")
    List<WorkVo> selectGloryOne(@Param(Constants.WRAPPER)QueryWrapper<WorkVo> queryWrapper);
}
