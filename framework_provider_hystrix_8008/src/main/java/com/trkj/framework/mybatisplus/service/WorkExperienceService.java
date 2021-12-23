package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.staff_workvo;

import java.util.List;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author suki
 * @since 2021-12-22
 */
public interface WorkExperienceService extends IService<staff_workvo> {

    List<staff_workvo> staffSelect();
}
