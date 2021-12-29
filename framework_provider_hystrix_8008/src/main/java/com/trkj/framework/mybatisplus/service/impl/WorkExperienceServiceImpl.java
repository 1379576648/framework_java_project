package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.mapper.WorkExperienceMapper;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.WorkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2021-12-29
 */
@Service
public class WorkExperienceServiceImpl extends ServiceImpl<WorkExperienceMapper, WorkExperience> implements WorkExperienceService {
//    @Autowired
//    private WorkExperienceMapper workExperienceMapper;
//
//    /**
//     * 查询工作经历
//     */
//    @Override
//    public IPage<WorkVo> selectwork(Page<WorkVo> page) {
//        return workExperienceMapper.selectwork(page);
//    }
}
