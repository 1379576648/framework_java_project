package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.InterviewVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 简历 Mapper 接口
 * </p>
 *
 * @author 牛蛙
 * @since 2021-1-10
 */
@Mapper
public interface InterviewMapper extends BaseMapper<InterviewVo> {


    /**
     * 面试通过查询
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select r.RESUME_ID,r.RESUME_NAME,d.POST_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX,r.RESUME_BIRTHDAY,i.INTERVIEW_NAME from INTERVIEW i left join RESUME r on r.RESUME_ID=i.RESUME_ID left join RECRUITMENT_PLAN P on p.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID left join DEPT_POST d on d.DEPT_POST_ID=p.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<InterviewVo> selectInterviewPass(Page<InterviewVo> page, @Param(Constants.WRAPPER) QueryWrapper<InterviewVo> queryWrapper);

}
