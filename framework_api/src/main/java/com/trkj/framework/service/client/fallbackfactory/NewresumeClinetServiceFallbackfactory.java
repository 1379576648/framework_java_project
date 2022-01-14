package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.InterviewVo;
import com.trkj.framework.vo.RecruitmentVo;
import com.trkj.framework.vo.ResumeVo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 降级~
 * @author TanWei
 */
@Component
public class NewresumeClinetServiceFallbackfactory implements FallbackFactory {

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
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 全部简历
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryAll(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryCandidate(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 淘汰库
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryEliminate(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 招聘计划
             * @param recruitmentVo
             * @return
             */
            @Override
            public Object queryRecruitment(RecruitmentVo recruitmentVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 面试通过
             * @param interviewVo
             * @return
             */
            @Override
            public Object queryInterviewPass(InterviewVo interviewVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 面试候选人
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryInterviewCandidate(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
            /**
             * 已邀约
             * @param resumeVo
             * @return
             */
            @Override
            public Object queryInvite(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

        };
    }
}
