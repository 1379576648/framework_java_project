package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.vo.WorkSchemeVo;

import java.util.ArrayList;

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

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    int updateWorkSchemeState(WorkScheme workScheme);

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    int updateWorkSchemeStateTwo(WorkScheme workScheme);

    /**
     * 删除加班方案
     * @param list
     * @return
     */
    String deleteWorkScheme(ArrayList<Integer> list);
}
