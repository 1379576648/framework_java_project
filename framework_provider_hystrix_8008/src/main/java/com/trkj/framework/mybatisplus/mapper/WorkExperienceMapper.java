package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 工作经历表 Mapper 接口
 * </p>
 *
 * @author suki
 * @since 2021-12-29
 */
@Mapper
public interface WorkExperienceMapper extends BaseMapper<WorkExperience> {
//    /**
//     * 查询工作经历
//     */
//    @Select("select s.STAFF_NAME,w.WORK_EXPERIENCE_ID,w.WORK_STARE_TIME,w.WORK_END_TIME,w.STAFF_ID,w.COMPANY_NAME,w.POSITION_NAME,w.POSITION_INDUSTRY,w.POSITION_DESCRIBE,w.POSITION_SQMONTHLY " +
//            "from  WORK_EXPERIENCE w " +
//            "LEFT JOIN STAFF s " +
//            "on w.STAFF_ID=s.STAFF_ID")
//    IPage<WorkVo> selectwork(Page<WorkVo> page);

}
