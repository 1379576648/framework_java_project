package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
             */
            @Override
            public Object queryResume(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 全部简历
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryAll(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryCandidate(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 淘汰库
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryEliminate(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 招聘计划
             * @param recruitmentVo
             * @return
             */
            @Override
            public Object queryRecruitment(RecruitmentVo recruitmentVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 面试通过
             * @param interviewVo
             * @return
             */
            @Override
            public Object queryInterviewPass(InterviewVo interviewVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 面试候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryInterviewCandidate(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }
            /**
             * 已邀约
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryInvite(ResumeVo resumeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }
        };
    }
}
