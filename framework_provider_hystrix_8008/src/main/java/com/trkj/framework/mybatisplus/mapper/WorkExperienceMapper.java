package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.staff_workvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 工作经历表 Mapper 接口
 * </p>
 *
 * @author suki
 * @since 2021-12-22
 */
@Mapper
public interface WorkExperienceMapper extends BaseMapper<staff_workvo> {

    @Select("select w.WORK_EXPERIENCE_ID,w.WORK_STARE_TIME,w.WORK_END_TIME,w.COMPANY_NAME,w.POSITION_NAME,w.POSITION_INDUSTRY,w.POSITION_DESCRIBE,w.POSITION_SQMONTHLY,s.staff_name from WORK_EXPERIENCE w left JOIN STAFF s on w.WORK_EXPERIENCE_ID=s.STAFF_ID \n")
    List<staff_workvo> staffSelect();
}
