package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 牛蛙
 * @since 2021-12-23
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, ResumeVo> implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private Resume2Mapper resume2Mapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private WorkExperiencessMapper workExperiencessMapper;

    @Autowired
    private RecruitmentPlanMapper mapper;

    @Autowired
    private Interview2Mapper interview2Mapper;
    /**
     * 新简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectPageVo(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",0);
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectPageVo(page,queryWrapper);
    }

    /**
     * 全部简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectAll(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNotNull("RESUME_ZT");
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectAll(page,queryWrapper);
    }
    /**
     * 候选人简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectCandidate(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",1);
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectCandidate(page,queryWrapper);
    }
    /**
     * 淘汰库查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectEliminate(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",2);
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectEliminate(page,queryWrapper);
    }
    /**
     * 面试候选人
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectInterviewCandidate(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",3);
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectInterviewCandidate(page,queryWrapper);
    }
    /**
     * 已邀约
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectInvite(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",4);
        if (resumeVo.getResumeName()!=null){
            queryWrapper.like("a.RESUME_NAME",resumeVo.getResumeName());
        }
        queryWrapper.orderByDesc("a.RESUME_ID");
        return resumeMapper.selectInvite(page,queryWrapper);
    }
    /**
     * 新增简历
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addResume(ResumeVo resumeVo) throws ArithmeticException {
        RecruitmentPlan recruitmentPlan =mapper.selectOne(new QueryWrapper<RecruitmentPlan>().eq("RECRUITMENT_PLAN_NAME",resumeVo.getRecruitmentPlanName()));
        Resume resume = new Resume();
        if (recruitmentPlan!=null){
        resume.setRecruitmentPlanId(recruitmentPlan.getRecruitmentPlanId());
        }
        resume.setResumeName(resumeVo.getResumeName());
        resume.setResumeSex(resumeVo.getResumeSex());
        resume.setResumeBirthday(resumeVo.getResumeBirthday());
        resume.setResumePhone(resumeVo.getResumePhone());
        resume.setResumeMailbox(resumeVo.getResumeMailbox());
        resume.setResumeAge(resumeVo.getResumeAge());
        resume.setResumeEducation(resumeVo.getResumeEducation());
        resume.setResumePoliticalOutlook(resumeVo.getResumePoliticalOutlook());
        resume.setToujTime(new Date());
        int i = resume2Mapper.insert(resume);
        if(i == 1){
            Educationss educationss = new Educationss();
            educationss.setResumeId(resume.getResumeId());
            educationss.setEducationStudentname(resumeVo.getEducationStudentname());
            educationss.setEducationMajor(resumeVo.getEducationMajor());
            educationss.setEducationStartTime(resumeVo.getEducationStartTime());
            educationss.setEducationEndTime(resumeVo.getEducationEndTime());
            int e = educationMapper.insert(educationss);
            if (e == 1){
                WorkExperiencess workExperiencess = new WorkExperiencess();
                workExperiencess.setResumeId(resume.getResumeId());
                workExperiencess.setCompanyName(resumeVo.getCompanyName());
                workExperiencess.setPositionName(resumeVo.getPositionName());
                workExperiencess.setWorkStareTime(resumeVo.getWorkStareTime());
                workExperiencess.setWorkEndTime(resumeVo.getWorkEndTime());
                workExperiencess.setPositionIndustry(resumeVo.getPositionIndustry());
                workExperiencess.setPositionSqmonthly(resumeVo.getPositionSqmonthly());
                workExperiencess.setPositionDescribe(resumeVo.getPositionDescribe());
                int w = workExperiencessMapper.insert(workExperiencess);
                if (w==1){
                    return "添加成功";
                }else {
                    throw new ArithmeticException("添加失败");
                }
            }else {
                throw new ArithmeticException("添加失败");
            }
        }else {
            throw new ArithmeticException("添加失败");
        }
    }

    /**
     * 设为候选人
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SetCandidate(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 转入淘汰库
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int Obsolete(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 设为面试候选人
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int InterviewCcandidate(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 转入淘汰库（候选人）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int HObsolete(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 邀约面试（面试候选人）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int OfferInterview(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 淘汰放弃（面试候选人）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int Abandon(Resume resume) {
        int i = resume2Mapper.updateById(resume);
        if(i>=1){
            return 666;
        }else {
            return 100;
        }
    }
    /**
     * 面试签到
     * @param
     * @return
     */
    @Override
    public int InterviewSign(Resume resume) {
        val resume2 = resume2Mapper.selectById(resume);
        Interview interview = new Interview();
        interview.setResumeId(resume2.getResumeId());

        int i=  interview2Mapper.insert(interview);
        if (i>=1){
            int a = resume2Mapper.updateById(resume);
            if (a>=1){
                return 666;
            }else {
                return 100;
            }
        }else {
            return 100;
        }
    }


}
