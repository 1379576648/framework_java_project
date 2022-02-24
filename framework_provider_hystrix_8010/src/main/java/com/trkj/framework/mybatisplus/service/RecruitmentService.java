package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.RecruitmentVo;

import java.util.List;

/**
 * @author 牛蛙
 */

public interface RecruitmentService extends IService<RecruitmentVo> {

    /**
     * 查询招聘计划
     * @param recruitmentVo
     * @return
     */
    IPage<RecruitmentVo> selectRecruitment(RecruitmentVo recruitmentVo);


}
