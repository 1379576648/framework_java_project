package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.mybatisplus.mapper.RecruitmentMapper;
import com.trkj.framework.mybatisplus.service.RecruitmentService;
import com.trkj.framework.vo.RecruitmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 牛蛙
 */
@Service
public class RecruitmentServiceImpI extends ServiceImpl<RecruitmentMapper, RecruitmentVo> implements RecruitmentService {
    @Autowired
    private RecruitmentMapper recruitmentMapper;


    /**
     * 招聘计划查询
     * @param
     * @return
     */
    @Override
    public IPage<RecruitmentVo> selectRecruitment(RecruitmentVo recruitmentVo) {
        Page<RecruitmentVo> page=new Page<>(recruitmentVo.getCurrentPage(),recruitmentVo.getPagesize());
        return recruitmentMapper.selectRecruitment(page);
    }

    /**
     * 查询招聘计划名称（新增简历下拉列表框）
     * @param
     * @return
     */
    @Override
    public List<RecruitmentVo> selectPlan(String  name) {
        return recruitmentMapper.selectList(new QueryWrapper<RecruitmentVo>().eq("recruitmentPlanName",name));
    }
}
