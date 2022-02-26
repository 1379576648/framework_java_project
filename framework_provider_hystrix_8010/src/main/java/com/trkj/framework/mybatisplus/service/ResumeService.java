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
public interface ResumeService extends IService<ResumeVo> {
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
         * @param
         * @return
         */
        String addResume(ResumeVo resumeVo);
}
