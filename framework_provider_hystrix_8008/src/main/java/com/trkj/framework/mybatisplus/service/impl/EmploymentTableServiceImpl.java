package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.mybatisplus.mapper.EmploymentTableMapper;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 录用表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Service
public class EmploymentTableServiceImpl implements EmploymentTableService {
    @Autowired
    private EmploymentTableMapper employmentTableMapper;


    /**
     * 查询已录用待入职的员工
     *
     * @param
     * @return
     */
    @Override
    public IPage<HireVo> selectpage(HireVo hireVo) {
        Page<HireVo> page = new Page<>(hireVo.getCurrentPage(), hireVo.getPagesize());
        QueryWrapper<HireVo> queryWrapper = new QueryWrapper<>();
        //根据姓名模糊查询
        if(hireVo.getResumeName()!=null){
            queryWrapper.like("r.RESUME_NAME",hireVo.getResumeName());
        }
        queryWrapper.eq("e.EMPLOYMENT_STATE", 0);
        return employmentTableMapper.selectpage(page, queryWrapper);
    }

    /**
     * 查询已经淘汰的员工
     */
    @Override
    public IPage<HireVo> selectabandon(HireVo hireVo) {
        Page<HireVo> page = new Page<>(hireVo.getCurrentPage(),hireVo.getPagesize());
        QueryWrapper<HireVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("e.EMPLOYMENT_STATE",2);
        return employmentTableMapper.selectabandon(page,queryWrapper);
    }

    /**
     * 查询工作经历
     */
    @Override
    public IPage<WorkVo> selectwork(WorkVo workVo) {
        Page<WorkVo> page = new Page<>(workVo.getCurrentPage(),workVo.getPagesize());
        return employmentTableMapper.selectwork(page);
    }

    /**
     *查询转正
     */
    @Override
    public IPage<FullVo> selectpost(FullVo fullVo) {
        Page<FullVo> page = new Page<>(fullVo.getCurrentPage(),fullVo.getPagesize());
        return employmentTableMapper.selectpost(page);
    }
}
