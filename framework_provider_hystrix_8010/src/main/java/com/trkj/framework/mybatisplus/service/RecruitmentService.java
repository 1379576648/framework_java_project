package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.RecruitmentVo;

/**
 * @author 牛蛙
 */

public interface RecruitmentService extends IService<RecruitmentVo> {
    //查询招聘计划
    IPage<RecruitmentVo> selectRecruitment(RecruitmentVo recruitmentVo);
}
