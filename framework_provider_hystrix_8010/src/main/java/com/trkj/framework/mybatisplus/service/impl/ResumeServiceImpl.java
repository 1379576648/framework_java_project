package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.mapper.ResumeMapper;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-23
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, ResumeVo> implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public IPage<ResumeVo> selectPageVo(Page<ResumeVo> page) {
        return resumeMapper.selectPageVo(page);
    }

    @Override
    public IPage<ResumeVo> selectAll(Page<ResumeVo> page) {
        return resumeMapper.selectAll(page);
    }
}
