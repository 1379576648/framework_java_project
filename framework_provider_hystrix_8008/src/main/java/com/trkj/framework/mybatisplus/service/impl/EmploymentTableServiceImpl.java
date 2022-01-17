package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 录用表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Service
public class EmploymentTableServiceImpl implements EmploymentTableService {
    @Autowired
    private EmploymentTableMapper employmentTableMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private RecruitmentplanMapper recruitmentplanMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptPostMapper deptPostMapper;

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private WorkExperiencessMapper workExperiencessMapper;

    @Autowired EducationssMapper educationssMapper;


    /**
     * 查询已录用待入职的员工
     *
     * @param
     * @return
     */
    @Override
    public IPage<HireVo> selectpage(HireVo hireVo) {
        Page<HireVo> page = new Page<>(hireVo.getCurrentPage(), hireVo.getPagesize());
        QueryWrapper<HireVo> queryWrapper = new QueryWrapper<>();
        //根据姓名模糊查询
        if(hireVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",hireVo.getResumeName());
        }
        queryWrapper.eq("e.EMPLOYMENT_STATE", 0);
        return employmentTableMapper.selectpage(page, queryWrapper);
    }

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */
    @Override
    public IPage<HireVo> selectabandon(HireVo hireVo) {
        Page<HireVo> page = new Page<>(hireVo.getCurrentPage(),hireVo.getPagesize());
        QueryWrapper<HireVo> queryWrapper = new QueryWrapper<>();
        //根据姓名模糊查询
        if(hireVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",hireVo.getResumeName());
        }
        queryWrapper.eq("e.EMPLOYMENT_STATE",2);
        return employmentTableMapper.selectabandon(page,queryWrapper);
    }

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    @Override
    public IPage<WorkVo> selectwork(WorkVo workVo) {
        Page<WorkVo> page = new Page<>(workVo.getCurrentPage(),workVo.getPagesize());
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        //根据姓名进行查询
       if(workVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",workVo.getStaffName());
        }
        return employmentTableMapper.selectwork(page,queryWrapper);
    }

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectWorkAll(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_ID",workVo.getStaffId());
        queryWrapper.eq("w.IS_DELETED",0);
        return employmentTableMapper.selectWorkAll(queryWrapper);
    }

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectGloryAll(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_ID",workVo.getStaffId());
        queryWrapper.eq("g.IS_DELETED",0);
        return employmentTableMapper.selectGloryAll(queryWrapper);
    }

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectPunishAll(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_ID",workVo.getStaffId());
        queryWrapper.eq("p.IS_DELETED",0);
        return employmentTableMapper.selectPunishAll(queryWrapper);
    }

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectEducationAll(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_ID",workVo.getStaffId());
        return employmentTableMapper.selectEducationAll(queryWrapper);
    }

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    @Override
    public IPage<FullVo> selectpost(FullVo fullVo) {
        Page<FullVo> page = new Page<>(fullVo.getCurrentPage(),fullVo.getPagesize());
        QueryWrapper<FullVo> queryWrapper = new QueryWrapper<>();
        //根据姓名查询
        if(fullVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",fullVo.getStaffName());
        }
        queryWrapper.eq("s.STAFF_STATE",0);
        return employmentTableMapper.selectpost(page,queryWrapper);
    }

    /**
     * 添加员工,工作经历,教育经历
     * @param hireVo
     * @return
     */

    @Override
    @Transactional
    public String insertStaff(HireVo hireVo) {
        //员工
        Staff staff = new Staff();
        //工作经历
        WorkExperience workExperience = new WorkExperience();
        //教育经历
        Education education = new Education();
        String s = "成功";
        //通过id查询简历数据
        Resume resume = resumeMapper.selectById(hireVo.getResumeId());
        System.out.println("查询简历数据");
        System.out.println(resume);
        //根据id查询招聘计划的数据
        RecruitmentPlan recruitmentPlan = recruitmentplanMapper.selectById(resume.getRecruitmentPlanId());
        System.out.println("查询招聘计划的数据");
        System.out.println(recruitmentPlan);
        //根据id查询部门数据
        Dept dept = deptMapper.selectById(recruitmentPlan.getDeptId());
        System.out.println("查询部门数据");
        System.out.println(dept);
        //根据id查询职位数据
        DeptPost deptPost = deptPostMapper.selectById(recruitmentPlan.getDeptPostId());
        System.out.println("查询职位数据");
        System.out.println(deptPost);
        //根据id查询工作经历数据
        WorkExperiencess workExperiencess = workExperiencessMapper.selectById(resume.getResumeId());
        System.out.println("查询工作经历");
        System.out.println(workExperiencess);
        //根据id查询教育经历
        Educationss educationss = educationssMapper.selectById(resume.getResumeId());
        System.out.println("查询教育经历");
        System.out.println(educationss);
        //如果工作经历和教育经历为空
        if(workExperiencess == null && educationss == null){
            //只添加员工数据
            //姓名
            staff.setStaffName(hireVo.getResumeName());
            //部门
            staff.setDeptId(dept.getDeptId());
            //职位
            staff.setDeptPostId(deptPost.getDeptPostId());
            //手机号码
            staff.setStaffPhone(hireVo.getResumePhone());
            //邮箱
            staff.setStaffEmail(hireVo.getResumeMailbox());
            //入职日期
            staff.setStaffHiredate(hireVo.getHiredate());
            //性别
            staff.setStaffSex(hireVo.getResumeSex());
            //学历
            staff.setStaffEducation(hireVo.getResumeEducation());
            //照片
            staff.setStaffPicture(hireVo.getResumePhoto());
            //出生日期
            staff.setStaffBirthday(hireVo.getResumeBirthday());
            //户口所在地
            staff.setStaffRegistered(hireVo.getResumeResidence());
            //政治面貌
            staff.setStaffOutlook(hireVo.getResumePoliticalOutlook());

            //添加到员工表
            int row = staffMapper.insert(staff);

            if (row >= 1) {
               s="成功";
            }else {
                return "添加失败";
            }
            //如果工作经历为空
        }else if(resume!=null && workExperiencess == null && educationss!=null){
            //只添加员工和教育经历
            //姓名
            staff.setStaffName(hireVo.getResumeName());
            //部门
            staff.setDeptId(dept.getDeptId());
            //职位
            staff.setDeptPostId(deptPost.getDeptPostId());
            //手机号码
            staff.setStaffPhone(hireVo.getResumePhone());
            //邮箱
            staff.setStaffEmail(hireVo.getResumeMailbox());
            //入职日期
            staff.setStaffHiredate(hireVo.getHiredate());
            //性别
            staff.setStaffSex(hireVo.getResumeSex());
            //学历
            staff.setStaffEducation(hireVo.getResumeEducation());
            //照片
            staff.setStaffPicture(hireVo.getResumePhoto());
            //出生日期
            staff.setStaffBirthday(hireVo.getResumeBirthday());
            //户口所在地
            staff.setStaffRegistered(hireVo.getResumeResidence());
            //政治面貌
            staff.setStaffOutlook(hireVo.getResumePoliticalOutlook());

            //添加到员工表
            int row = staffMapper.insert(staff);

            //开始时间
            education.setEducationStartTime(hireVo.getEducationStartTime());
            //结束时间
            education.setEducationEndTime(hireVo.getEducationEndTime());
            //员工编号
            education.setStaffId(staff.getStaffId());
            //学校名称
            education.setEducationStudentname(hireVo.getEducationStudentname());
            //所属专业
            education.setEducationMajor(hireVo.getEducationMajor());
            //是否全日制
            education.setEducationFullTime(hireVo.getEducationFullTime());

            //添加教育经历表
            int row3 = educationMapper.insert(education);

            //如果添加成功
            if (row >= 1) {
                s="成功";
            }else if(row3>=1){
                s="成功";
            }else {
                return "添加失败";
            }

            //如果教育经历为空
        }else if(resume!=null && workExperience!=null && educationss == null){
            //只添加员工和工作经历
            //姓名
            staff.setStaffName(hireVo.getResumeName());
            //部门
            staff.setDeptId(dept.getDeptId());
            //职位
            staff.setDeptPostId(deptPost.getDeptPostId());
            //手机号码
            staff.setStaffPhone(hireVo.getResumePhone());
            //邮箱
            staff.setStaffEmail(hireVo.getResumeMailbox());
            //入职日期
            staff.setStaffHiredate(hireVo.getHiredate());
            //性别
            staff.setStaffSex(hireVo.getResumeSex());
            //学历
            staff.setStaffEducation(hireVo.getResumeEducation());
            //照片
            staff.setStaffPicture(hireVo.getResumePhoto());
            //出生日期
            staff.setStaffBirthday(hireVo.getResumeBirthday());
            //户口所在地
            staff.setStaffRegistered(hireVo.getResumeResidence());
            //政治面貌
            staff.setStaffOutlook(hireVo.getResumePoliticalOutlook());

            //添加到员工表
            int row = staffMapper.insert(staff);

            //开始时间
            workExperience.setWorkStareTime(hireVo.getWorkStareTime());
            //结束时间
            workExperience.setWorkEndTime(hireVo.getWorkEndTime());
            //员工编号
            workExperience.setStaffId(staff.getStaffId());
            //公司名称
            workExperience.setCompanyName(hireVo.getCompanyName());
            //职位名称
            workExperience.setPositionName(hireVo.getPositionName());
            //所属行业
            workExperience.setPositionIndustry(hireVo.getPositionIndustry());
            //工作描述
            workExperience.setPositionDescribe(hireVo.getPositionDescribe());
            //税前月薪
            workExperience.setPositionSqmonthly(hireVo.getPositionSqmonthly());

            //添加工作经历表
            int row2 = workExperienceMapper.insert(workExperience);

            //如果添加成功
            if (row >= 1) {
                s="成功";
            }else if(row2>=1){
                s="成功";
            }else {
                return "添加失败";
            }
            //如果都不为空
        }else if(hireVo != null){
            //讲所有数据赋值到员工实体类中
            //姓名
            staff.setStaffName(hireVo.getResumeName());
            //部门
            staff.setDeptId(dept.getDeptId());
            //职位
            staff.setDeptPostId(deptPost.getDeptPostId());
            //手机号码
            staff.setStaffPhone(hireVo.getResumePhone());
            //邮箱
            staff.setStaffEmail(hireVo.getResumeMailbox());
            //入职日期
            staff.setStaffHiredate(hireVo.getHiredate());
            //性别
            staff.setStaffSex(hireVo.getResumeSex());
            //学历
            staff.setStaffEducation(hireVo.getResumeEducation());
            //照片
            staff.setStaffPicture(hireVo.getResumePhoto());
            //出生日期
            staff.setStaffBirthday(hireVo.getResumeBirthday());
            //户口所在地
            staff.setStaffRegistered(hireVo.getResumeResidence());
            //政治面貌
            staff.setStaffOutlook(hireVo.getResumePoliticalOutlook());

            //添加到员工表
            int row = staffMapper.insert(staff);

            //开始时间
            workExperience.setWorkStareTime(hireVo.getWorkStareTime());
            //结束时间
            workExperience.setWorkEndTime(hireVo.getWorkEndTime());
            //员工编号
            workExperience.setStaffId(staff.getStaffId());
            //公司名称
            workExperience.setCompanyName(hireVo.getCompanyName());
            //职位名称
            workExperience.setPositionName(hireVo.getPositionName());
            //所属行业
            workExperience.setPositionIndustry(hireVo.getPositionIndustry());
            //工作描述
            workExperience.setPositionDescribe(hireVo.getPositionDescribe());
            //税前月薪
            workExperience.setPositionSqmonthly(hireVo.getPositionSqmonthly());

            //添加工作经历表
            int row2 = workExperienceMapper.insert(workExperience);

            //开始时间
            education.setEducationStartTime(hireVo.getEducationStartTime());
            //结束时间
            education.setEducationEndTime(hireVo.getEducationEndTime());
            //员工编号
            education.setStaffId(staff.getStaffId());
            //学校名称
            education.setEducationStudentname(hireVo.getEducationStudentname());
            //所属专业
            education.setEducationMajor(hireVo.getEducationMajor());
            //是否全日制
            education.setEducationFullTime(hireVo.getEducationFullTime());

            //添加教育经历表
            int row3 = educationMapper.insert(education);

            //如果添加成功
            if (row >= 1) {
                s="成功";
            }else if(row2>=1){
                s="成功";
            }else if(row3>=1){
                s="成功";
            }
            else {
                return "添加失败";
            }
        }else {
            return "查无[" + hireVo.getResumeId() + "]简历编号";
        }
        return s;
   }

    /**
     * 修改录用状态为已录用
     * @param employmentTable
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateEmploymentState(EmploymentTable employmentTable) {
        final var i = employmentTableMapper.updateById(employmentTable);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateEmploymentStateAndWaiveReasonInt(EmploymentTable employmentTable) {
        final var i = employmentTableMapper.updateById(employmentTable);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectWorkOne(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("WORK_EXPERIENCE_ID",workVo.getWorkExperienceId());
        return employmentTableMapper.selectWorkOne(queryWrapper);
    }

}
