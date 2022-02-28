package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.vo.ResumeVo;

/**
 * <p>
 * 简历表 服务类
 * </p>
 *
 * @author 牛蛙
 * @since 2021-12-23
 */
public interface ResumeService{
        /**
         * 新简历
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectPageVo(ResumeVo resumeVo);

        /**
         * 全部简历
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectAll(ResumeVo resumeVo);

        /**
         * 候选人
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectCandidate(ResumeVo resumeVo);

        /**
         * 淘汰库
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectEliminate(ResumeVo resumeVo);

        /**
         * 面试候选人
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectInterviewCandidate(ResumeVo resumeVo);

        /**
         * 已邀约
         * @param resumeVo
         * @return
         */
        IPage<ResumeVo> selectInvite(ResumeVo resumeVo);

        /**
         * 新增简历
         * @param resumeVo
         * @return
         */
        String addResume(ResumeVo resumeVo);

        /**
         * 设为候选人
         * @param
         * @return
         */
        int SetCandidate(Resume resume);

        /**
         * 转入淘汰库（新简历）
         * @param
         * @return
         */
        int Obsolete(Resume resume);

        /**
         * 设为面试候选人
         * @param
         * @return
         */
        int InterviewCcandidate(Resume resume);

        /**
         * 转入淘汰库（候选人）
         * @param
         * @return
         */
        int HObsolete(Resume resume);

        /**
         * 邀约面试（面试候选人）
         * @param
         * @return
         */
        int OfferInterview(Resume resume);

        /**
         * 淘汰放弃（面试候选人）
         * @param
         * @return
         */
        int Abandon(Resume resume);
}
