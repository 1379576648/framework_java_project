package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.mybatisplus.mapper.ManAnalysisThreeMapper;
import com.trkj.framework.mybatisplus.service.ManAnalysisThreeService;
import com.trkj.framework.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */
@Service
public class ManAnalysisThreeServiceImpl  implements ManAnalysisThreeService {
    @Autowired
    private ManAnalysisThreeMapper mapper;

    /**
     * 员工性别查询
     * @return
     */
    @Override
    public List<Map<String, Object>> selectStaffSex() {
        return mapper.selectStaffSex();
    }
}
