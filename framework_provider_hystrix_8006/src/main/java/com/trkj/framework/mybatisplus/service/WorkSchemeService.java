package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.vo.WorkSchemeVo;

public interface WorkSchemeService {

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    IPage<WorkSchemeVo> selectWorkScheme(WorkSchemeVo workSchemeVo);

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    int insertWorkScheme(WorkScheme workScheme);
}
