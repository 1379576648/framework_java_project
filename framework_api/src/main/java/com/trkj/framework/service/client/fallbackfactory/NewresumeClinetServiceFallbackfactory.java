package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.Employment;
import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            public Object queryAddResume(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

        };
    }
}
