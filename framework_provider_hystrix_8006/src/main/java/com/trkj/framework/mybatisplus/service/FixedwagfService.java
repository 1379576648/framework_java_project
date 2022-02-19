package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.vo.FixedwageVo;

public interface FixedwagfService {

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    IPage<FixedwageVo> selectFixedwage(FixedwageVo fixedwageVo);

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    int updateFixedwage(Fixedwagf fixedwagf);


}
