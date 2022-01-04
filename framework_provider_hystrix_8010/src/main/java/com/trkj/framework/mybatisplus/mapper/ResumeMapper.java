package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.ResumeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 简历表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-23
 */
@Mapper
public interface ResumeMapper extends BaseMapper<ResumeVo> {

    // 新简历
    @Select("select a.RESUME_NAME,b.POST_NAME,a.RESUME_SEX,a.RESUME_EDUCATION,a.RESUME_PHONE,a.RESUME_MAILBOX,a.RESUME_BIRTHDAY from RECRUITMENT_PLAN c LEFT JOIN RESUME a on c.RECRUITMENT_PLAN_ID=a.RECRUITMENT_PLAN_ID LEFT JOIN DEPT_POST b on b.DEPT_POST_ID=c.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<ResumeVo> selectPageVo(Page<ResumeVo> page, @Param(Constants.WRAPPER) QueryWrapper<ResumeVo> queryWrapper);

    // 全部简历
    @Select("select a.RESUME_NAME,b.POST_NAME,a.RESUME_SEX,a.RESUME_EDUCATION,a.RESUME_PHONE,a.RESUME_MAILBOX,a.RESUME_BIRTHDAY from RECRUITMENT_PLAN c LEFT JOIN RESUME a on c.RECRUITMENT_PLAN_ID=a.RECRUITMENT_PLAN_ID LEFT JOIN DEPT_POST b on b.DEPT_POST_ID=c.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<ResumeVo> selectAll(Page<ResumeVo> page, @Param(Constants.WRAPPER) QueryWrapper<ResumeVo> queryWrapper);
}
