package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.RecruitmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 简历表 Mapper 接口
 * </p>
 *
 * @author 牛蛙
 * @since 2021-1-6
 */
@Mapper
public interface RecruitmentMapper extends BaseMapper<RecruitmentVo> {

    @Select("select a.RECRUITMENT_PLAN_ID,a.RECRUITMENT_PLAN_NAME,b.DEPT_NAME,c.POST_NAME,a.RECRUITMENT_PLAN_NUMBER,a.RECRUITMENT_PLAN_START_TIME,a.RECRUITMENT_ZT from RECRUITMENT_PLAN a left join DEPT b on b.DEPT_ID=a.DEPT_ID left join DEPT_POST c on c.DEPT_POST_ID=a.DEPT_POST_ID")
    IPage<RecruitmentVo> selectRecruitment(Page<RecruitmentVo> page);
}

