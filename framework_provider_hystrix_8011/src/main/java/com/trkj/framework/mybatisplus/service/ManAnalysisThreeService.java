package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.StaffVo;

import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */
public interface ManAnalysisThreeService  {

    /**
     * 员工性别查询
     * @return
     */
    List<Map<String, Object>> selectStaffSex();
}
