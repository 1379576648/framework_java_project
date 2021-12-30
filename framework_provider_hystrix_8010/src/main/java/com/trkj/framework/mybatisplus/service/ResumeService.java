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
 * @author 劉祁
 * @since 2021-12-23
 */
public interface ResumeService extends IService<ResumeVo> {
        IPage<ResumeVo> selectPageVo(Page<ResumeVo> page);
        IPage<ResumeVo> selectAll(Page<ResumeVo> page);
}
