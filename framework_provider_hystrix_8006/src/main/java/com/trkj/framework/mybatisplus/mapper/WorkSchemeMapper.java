package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.vo.WorkSchemeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WorkSchemeMapper extends BaseMapper<WorkScheme> {

    /**
     * 查询加班方案
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT w.WORKSCHEME_NAME,w.WORKSCHEME_HOLIDAYRATIO,w.WORKSCHEME_DAYOFFRATIO,w.WORKSCHEME_WORKRATIO,d.DEPT_NAME,w.WORKSCHEME_REMARK,w.WORKSCHEME_STATE FROM WORKSCHEME w LEFT JOIN DEPT d on d.DEPT_NAME=w.DEPT_NAME ${ew.customSqlSegment}")
    IPage<WorkSchemeVo> selectWorkScheme(Page<WorkSchemeVo> page, @Param(Constants.WRAPPER)QueryWrapper<WorkSchemeVo> queryWrapper);
}
