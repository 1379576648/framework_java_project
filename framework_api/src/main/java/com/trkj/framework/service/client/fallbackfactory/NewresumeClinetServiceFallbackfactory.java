package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 降级~
 * @author TanWei
 */
@Component
public class NewresumeClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;

    @Override
    public Object create(Throwable throwable) {
        return new NewresumeClinetService() {
            /**
             * 新简历
             * @param resumeVo
             * @return
             * @return
             */
            @Override
            public Map<String,Object> queryResume(ResumeVo resumeVo) {
                   return fuseUtil.main(throwable);
            }

            /**
             * 全部简历
             * @param resumeVo
             * @return
             */
            @Override
            public Map<String,Object> queryAll(ResumeVo resumeVo) {
                   return fuseUtil.main(throwable);
            }

            /**
             * 候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Map<String,Object> queryCandidate(ResumeVo resumeVo) {
                   return fuseUtil.main(throwable);
            }

            /**
             * 淘汰库
             * @param resumeVo
             * @return
             */
            @Override
            public Map<String,Object> queryEliminate(ResumeVo resumeVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 招聘计划
             * @param recruitmentVo
             * @return
             */
            @Override
            public Map<String,Object> queryRecruitment(RecruitmentVo recruitmentVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 面试通过
             * @param interviewVo
             * @return
             */
            @Override
            public Map<String,Object> queryInterviewPass(InterviewVo interviewVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 待面试
             * @param interviewVo
             * @return
             */
            @Override
            public Map<String,Object> selectForInterview(InterviewVo interviewVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 面试中
             * @param interviewVo
             * @return
             */
            @Override
            public Map<String,Object> selectInInterview(InterviewVo interviewVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 复试中
             * @param interviewVo
             * @return
             */
            @Override
            public Map<String,Object> selectSecondInterview(InterviewVo interviewVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 面试候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Map<String,Object> queryInterviewCandidate(ResumeVo resumeVo) {
                return fuseUtil.main(throwable);
            }
            /**
             * 已邀约
             * @param resumeVo
             * @return
             */
            @Override
            public Map<String,Object> queryInvite(ResumeVo resumeVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 添加录用数据
             * @param employment
             * @return
             */
            @Override
            public Map<String,Object> employStaff(Employment employment) {
                return fuseUtil.main(throwable);
            }
            /**
             * 添加新简历
             * @param resumeVo
             * @return
             */
            @Override
            public  Map<String, Object> queryAddResume(ResumeVo resumeVo) {
                return fuseUtil.main(throwable);
            }
            /**
             * 查询招聘计划名称（新增简历下拉列表框）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> selectPlan() {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询部门名称（新增招聘计划下拉列表框）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> selectDeptName1() {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询部门职位名称（新增招聘计划下拉列表框）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> selectDeptPostName1() {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询部门职位名称（新增招聘计划下拉列表框）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> selectMonthlySalary() {
                return fuseUtil.main(throwable);
            }

            /**
             * 新增招聘计划
             * @param
             * @return
             */
            @Override
            public  Map<String, Object> addRecruitmentPlan(RecruitmentVo recruitmentVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 设为候选人
             * @param
             * @return
             */
            @Override
            public Map<String, Object> SetCandidate(Resume resume) {
                return fuseUtil.main(throwable);
            }

            /**
             * 转入淘汰库（新简历）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> Obsolete(Resume resume) {
                return fuseUtil.main(throwable);
            }

            /**
             * 设为面试候选人
             * @param
             * @return
             */
            @Override
            public Map<String, Object> InterviewCcandidate(Resume resume) {
                return fuseUtil.main(throwable);
            }

            /**
             * 转入淘汰库（候选人）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> HObsolete(Resume resume) {
                return fuseUtil.main(throwable);
            }

            /**
             * 邀约面试（面试候选人）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> OfferInterview(Resume resume) {
                return fuseUtil.main(throwable);
            }

            /**
             * 淘汰放弃（面试候选人）
             * @param
             * @return
             */
            @Override
            public Map<String, Object> Abandon(Resume resume) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
