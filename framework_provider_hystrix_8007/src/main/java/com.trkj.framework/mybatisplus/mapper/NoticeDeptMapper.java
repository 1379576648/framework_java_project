package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.NoticeDept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公告部门表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-30
 */
@Mapper
public interface NoticeDeptMapper extends BaseMapper<NoticeDept> {
    /***
     * 物理删除公告部门表数据
     * @param queryWrapper
     * @return
     */
    @Delete("delete from NOTICE_DEPT ${ew.customSqlSegment}")
    int deleteNoticeDept(@Param(Constants.WRAPPER) QueryWrapper<NoticeDept> queryWrapper);
}
