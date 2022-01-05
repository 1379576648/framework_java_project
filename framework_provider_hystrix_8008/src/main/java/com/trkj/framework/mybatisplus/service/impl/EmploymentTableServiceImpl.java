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
     */
    @Override
    public IPage<HireVo> selectabandon(HireVo hireVo) {
        Page<HireVo> page = new Page<>(hireVo.getCurrentPage(),hireVo.getPagesize());
        QueryWrapper<HireVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("e.EMPLOYMENT_STATE",2);
        return employmentTableMapper.selectabandon(page,queryWrapper);
    }

    /**
     * 查询工作经历
     */
    @Override
    public IPage<WorkVo> selectwork(WorkVo workVo) {
        Page<WorkVo> page = new Page<>(workVo.getCurrentPage(),workVo.getPagesize());
        return employmentTableMapper.selectwork(page);
    }

    /**
     *查询转正
     */
    @Override
    public IPage<FullVo> selectpost(FullVo fullVo) {
        Page<FullVo> page = new Page<>(fullVo.getCurrentPage(),fullVo.getPagesize());
        return employmentTableMapper.selectpost(page);
    }

    /**
     * 添加员工
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
        //根据id查询招聘计划的数据
        RecruitmentPlan recruitmentPlan = recruitmentplanMapper.selectById(resume.getRecruitmentPlanId());
        //根据id查询部门数据
        Dept dept = deptMapper.selectById(recruitmentPlan.getDeptId());
        //根据id查询职位数据
        DeptPost deptPost = deptPostMapper.selectById(recruitmentPlan.getDeptPostId());
        //如果简历实体类不为空
        if (hireVo != null) {
            //讲简历实体类的数据赋值到员工实体类中
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
        } else {
            return "查无[" + hireVo.getResumeId() + "]简历编号";
        }
        return s;
    }

    /**
     * 修改录用状态
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
}
