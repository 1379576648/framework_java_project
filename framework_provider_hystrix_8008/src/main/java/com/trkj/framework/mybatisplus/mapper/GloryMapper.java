package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.vo.PunishGloryVo;
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

    /**
     * 查询奖励和惩罚
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,g.GLORY_ID,g.GLORY_NAME,g.GLORY_UNITNAME,g.GLORY_REMARK,g.CREATED_TIME,p.PUNISH_ID,p.PUNISH_TYPE,p.PUNISH_CAUSE,p.PUNISH_UNIT,p.IS_REVOCATION,p.PUNISH_REMARK FROM STAFF s LEFT JOIN GLORY g on g.STAFF_ID=s.STAFF_ID LEFT JOIN PUNISH p on p.STAFF_ID=s.STAFF_ID ${ew.customSqlSegment}")
    IPage<PunishGloryVo> selectPunishGlory(Page<PunishGloryVo> page,@Param(Constants.WRAPPER) QueryWrapper<PunishGloryVo> queryWrapper);
}
