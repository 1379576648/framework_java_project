package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 13795
 */
@Mapper
public interface PunishMapper extends BaseMapper<Punish> {

    /**
     * 根据惩罚id查询惩罚
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM PUNISH ${ew.customSqlSegment}")
    List<WorkVo> selectPunishOne(@Param(Constants.WRAPPER)QueryWrapper<WorkVo> queryWrapper);
}
