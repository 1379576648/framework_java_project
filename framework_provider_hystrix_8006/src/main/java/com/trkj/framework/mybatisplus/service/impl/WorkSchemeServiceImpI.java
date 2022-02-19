package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.mapper.WorkSchemeMapper;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.vo.WorkSchemeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkSchemeServiceImpI implements WorkSchemeService {

    @Autowired
    private WorkSchemeMapper workSchemeMapper;

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @Override
    public IPage<WorkSchemeVo> selectWorkScheme(WorkSchemeVo workSchemeVo) {
        Page<WorkSchemeVo> page = new Page<>(workSchemeVo.getCurrentPage(),workSchemeVo.getPagesize());
        QueryWrapper<WorkSchemeVo> queryWrapper = new QueryWrapper<>();
        //根据方案名称查询
        if(workSchemeVo.getWorkSchemeName()!=null){
            queryWrapper.like("w.WORKSCHEME_NAME",workSchemeVo.getWorkSchemeName());
        }
        return workSchemeMapper.selectWorkScheme(page,queryWrapper);
    }

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertWorkScheme(WorkScheme workScheme) {
        return workSchemeMapper.insert(workScheme);
    }
}
