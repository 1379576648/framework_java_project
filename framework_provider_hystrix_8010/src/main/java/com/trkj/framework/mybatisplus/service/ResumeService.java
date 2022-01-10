package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.baomidou.mybatisplus.extension.service.IService;
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
        //新简历
        IPage<ResumeVo> selectPageVo(ResumeVo resumeVo);
        //全部简历
        IPage<ResumeVo> selectAll(ResumeVo resumeVo);
        //候选人
        IPage<ResumeVo> selectCandidate(ResumeVo resumeVo);
        //淘汰库
        IPage<ResumeVo> selectEliminate(ResumeVo resumeVo);
}
