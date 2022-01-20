package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Education;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 受教育经历表 Mapper 接口
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@Mapper
public interface EducationMapper extends BaseMapper<Education> {

    /**
     * 根据教育经历id查询教育经历
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM EDUCATION ${ew.customSqlSegment}")
    List<WorkVo> selectEducationOne(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

}
