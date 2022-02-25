package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.RecruitmentPlan;
import com.trkj.framework.vo.RecruitmentVo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
 * @author TanWei
 */
@Mapper
public interface RecruitmentPlanMapper extends BaseMapper<RecruitmentPlan> {
}
