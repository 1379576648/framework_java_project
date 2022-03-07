package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.entity.mybatisplus.NoticeDept;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * <p>
 * 录用表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Mapper
public interface EmploymentTableMapper extends BaseMapper<EmploymentTable> {

    /**
     * 查询已录用待入职的员工
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT e.EMPLOYMENT_ID,e.EMPLOYMENT_STATE,e.EMPLOYMENT_SALARY,e.EMPLOYMENT_SALARYZ,e.WAIVE_REASON,e.EMPLOYMENT_HIREDATE,rp.RECRUITMENT_PLAN_ID,r.RESUME_ID,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_AGE,d.DEPT_NAME,p.POST_NAME,r.RESUME_PHONE,r.RESUME_EDUCATION,r.RESUME_MAILBOX,r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,x.WORK_EXPERIENCESS_ID,x.WORK_STARE_TIME,x.WORK_END_TIME,x.COMPANY_NAME,x.POSITION_NAME,x.POSITION_INDUSTRY,x.POSITION_DESCRIBE,x.POSITION_SQMONTHLY,a.EDUCATIONSS_ID,a.EDUCATION_START_TIME,a.EDUCATION_END_TIME,a.EDUCATION_STUDENTNAME,a.EDUCATION_MAJOR,a.EDUCATION_FULL_TIME FROM EMPLOYMENT_TABLE e LEFT JOIN RESUME r on e.RESUME_ID = r.RESUME_ID LEFT JOIN WORK_EXPERIENCESS x on x.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID = rp.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on rp.DEPT_ID = d.DEPT_ID LEFT JOIN DEPT_POST p on rp.DEPT_POST_ID=p.DEPT_POST_ID LEFT JOIN EDUCATIONSS a on a.RESUME_ID=r.RESUME_ID ${ew.customSqlSegment}")
    IPage<HireVo> selectpage(Page<HireVo> page, @Param(Constants.WRAPPER) QueryWrapper<HireVo> queryWrapper);

    /**
     * 查询已经淘汰的员工
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT e.EMPLOYMENT_ID,e.EMPLOYMENT_STATE,e.EMPLOYMENT_HIREDATE,e.WAIVE_REASON,r.RESUME_NAME,d.DEPT_NAME,p.POST_NAME,r.RESUME_PHONE,r.RESUME_MAILBOX FROM EMPLOYMENT_TABLE e LEFT JOIN RESUME r on e.RESUME_ID = r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID = rp.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on rp.DEPT_ID = d.DEPT_ID LEFT JOIN DEPT_POST p on rp.DEPT_POST_ID=p.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<HireVo> selectabandon(Page<HireVo> page,@Param(Constants.WRAPPER) QueryWrapper<HireVo> queryWrapper);

    /**
     * 查询工作经历
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select s.STAFF_ID,s.STAFF_NAME,w.WORK_EXPERIENCE_ID,w.WORK_STARE_TIME,w.WORK_END_TIME,w.COMPANY_NAME,w.POSITION_NAME,w.POSITION_INDUSTRY,w.POSITION_DESCRIBE,w.POSITION_SQMONTHLY,w.IS_DELETED FROM WORK_EXPERIENCE w LEFT JOIN STAFF s on w.STAFF_ID=s.STAFF_ID ${ew.customSqlSegment}")
    IPage<WorkVo> selectwork(Page<WorkVo> page,@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

    /**
     * 根据id查询工作经历
     * @param queryWrapper
     * @return
     */
    @Select("select s.STAFF_ID,s.STAFF_NAME,w.WORK_EXPERIENCE_ID,w.WORK_STARE_TIME,w.WORK_END_TIME,w.COMPANY_NAME,w.POSITION_NAME,w.POSITION_INDUSTRY,w.POSITION_DESCRIBE,w.POSITION_SQMONTHLY,w.IS_DELETED FROM WORK_EXPERIENCE w LEFT JOIN STAFF s on w.STAFF_ID=s.STAFF_ID ${ew.customSqlSegment}")
    List<WorkVo> selectWorkAll(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

    /**
     * 根据id查询奖励
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,g.GLORY_ID,g.GLORY_NAME,g.GLORY_UNITNAME,g.GLORY_REMARK,g.CREATED_TIME,g.IS_DELETED FROM GLORY g LEFT JOIN STAFF s on s.STAFF_ID=g.STAFF_ID ${ew.customSqlSegment}")
    List<WorkVo> selectGloryAll(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

    /**
     * 根据id查询惩罚
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,p.PUNISH_ID,p.PUNISH_TYPE,p.PUNISH_CAUSE,p.PUNISH_UNIT,p.IS_REVOCATION,p.PUNISH_REMARK,p.IS_DELETED FROM PUNISH p LEFT JOIN STAFF s on s.STAFF_ID=p.STAFF_ID ${ew.customSqlSegment}")
    List<WorkVo> selectPunishAll(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

    /**
     * 根据id查询教育经历
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,e.EDUCATION_ID,e.EDUCATION_START_TIME,e.EDUCATION_END_TIME,e.EDUCATION_STUDENTNAME,e.EDUCATION_MAJOR,e.EDUCATION_FULL_TIME,e.IS_DELETED FROM EDUCATION e LEFT JOIN STAFF s on s.STAFF_ID=e.STAFF_ID  ${ew.customSqlSegment}")
    List<WorkVo> selectEducationAll(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);

    /**
     * 查询转正
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,s.STAFF_NAME , s.STAFF_STATE , s.STAFF_IDENTITY , d.DEPT_NAME , p.POST_NAME , s.STAFF_HIREDATE FROM STAFF s LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID = s.DEPT_POST_ID ${ew.customSqlSegment} ")
    IPage<FullVo> selectpost(Page<FullVo> page,@Param(Constants.WRAPPER) QueryWrapper<FullVo> queryWrapper);

    /**
     * 根据工作经历id查询工作经历
     * @param queryWrapper
     * @return
     */
    @Select("select * FROM WORK_EXPERIENCE ${ew.customSqlSegment}")
    List<WorkVo> selectWorkOne(@Param(Constants.WRAPPER) QueryWrapper<WorkVo> queryWrapper);


}
