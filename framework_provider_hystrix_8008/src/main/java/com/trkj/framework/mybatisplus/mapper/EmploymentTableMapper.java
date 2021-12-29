package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


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
     */
    @Select("SELECT e.EMPLOYMENT_ID,e.EMPLOYMENT_STATE,e.HIREDATE,r.RESUME_NAME,d.DEPT_NAME,p.POST_NAME,r.RESUME_PHONE,r.RESUME_MAILBOX " +
            "FROM EMPLOYMENT_TABLE e " +
            "LEFT JOIN RESUME r " +
            "on e.RESUME_ID = r.RESUME_ID " +
            "LEFT JOIN RECRUITMENT_PLAN rp " +
            "on r.RECRUITMENT_PLAN_ID = rp.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT d " +
            "on rp.DEPT_ID = d.DEPT_ID " +
            "LEFT JOIN DEPT_POST p " +
            "on rp.DEPT_POST_ID=p.DEPT_POST_ID " +
            "where e.EMPLOYMENT_STATE=0")
    IPage<HireVo> selectpage(Page<HireVo> page);

    /**
     * 查询已经淘汰的员工
     */
    @Select("SELECT e.EMPLOYMENT_ID,e.EMPLOYMENT_STATE,e.HIREDATE,e.WAIVE_REASON,r.RESUME_NAME,d.DEPT_NAME,p.POST_NAME,r.RESUME_PHONE,r.RESUME_MAILBOX " +
            "FROM EMPLOYMENT_TABLE e " +
            "LEFT JOIN RESUME r " +
            "on e.RESUME_ID = r.RESUME_ID " +
            "LEFT JOIN RECRUITMENT_PLAN rp " +
            "on r.RECRUITMENT_PLAN_ID = rp.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT d " +
            "on rp.DEPT_ID = d.DEPT_ID " +
            "LEFT JOIN DEPT_POST p " +
            "on rp.DEPT_POST_ID=p.DEPT_POST_ID " +
            "where e.EMPLOYMENT_STATE=2")
    IPage<HireVo> selectabandon(Page<HireVo> page);

    /**
     * 查询工作经历
     */
    @Select("select s.STAFF_NAME,w.WORK_EXPERIENCE_ID,w.WORK_STARE_TIME,w.WORK_END_TIME,w.STAFF_ID,w.COMPANY_NAME,w.POSITION_NAME,w.POSITION_INDUSTRY,w.POSITION_DESCRIBE,w.POSITION_SQMONTHLY " +
            "from  WORK_EXPERIENCE w " +
            "LEFT JOIN STAFF s " +
            "on w.STAFF_ID=s.STAFF_ID")
    IPage<WorkVo> selectwork(Page<WorkVo> page);



}
