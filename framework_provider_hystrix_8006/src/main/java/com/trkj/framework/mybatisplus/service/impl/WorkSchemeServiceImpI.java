package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.mapper.WorkSchemeMapper;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.vo.WorkSchemeVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        //queryWrapper.eq("d.DEPT_NAME",workSchemeVo.getDeptName());
        queryWrapper.eq("w.IS_DELETED",0);
        return workSchemeMapper.selectWorkScheme(page,queryWrapper);
    }

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @Override
    public int insertWorkScheme(WorkScheme workScheme) {
        return workSchemeMapper.insert(workScheme);
    }

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWorkSchemeState(WorkScheme workScheme) {
        final var i = workSchemeMapper.updateById(workScheme);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWorkSchemeStateTwo(WorkScheme workScheme) {
        final var i = workSchemeMapper.updateById(workScheme);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 删除加班方案
     * @param id
     * @return
     */
    @Override
    public String deleteWorkScheme(Integer id) {
        String s = "成功";
        if (workSchemeMapper.deleteById(id)<=0){
            return "删除加班方案失败";
        }
        return s;
    }

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @Override
    public List<WorkScheme> selectWorkSchemeAll(WorkScheme workScheme) {
        QueryWrapper<WorkScheme> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("WORKSCHEME_ID",workScheme.getWorkSchemeId());
        return workSchemeMapper.selectWorkSchemeAll(queryWrapper);
    }

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWorkScheme(WorkScheme workScheme) {
        final var i = workSchemeMapper.updateById(workScheme);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 根据部门名称查询是否有方案
     * @param workScheme
     * @return
     */
    @Override
    public List<WorkScheme> selectWorkSchemeBydept(WorkScheme workScheme) {
        QueryWrapper<WorkScheme> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DEPT_NAME",workScheme.getDeptName());
        queryWrapper.eq("IS_DELETED",0);
        return workSchemeMapper.selectWorkSchemeBydept(queryWrapper);
    }
}
