package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.mapper.AttendandceMapper;
import com.trkj.framework.mybatisplus.mapper.WorkSchemeMapper;
import com.trkj.framework.mybatisplus.service.AttendandceService;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.vo.AttendandceVo;
import com.trkj.framework.vo.WorkSchemeVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendandceServiceImpI implements AttendandceService {

    @Autowired
    private AttendandceMapper attendandceMapper;

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @Override
    public IPage<AttendandceVo> selectAttendandce(AttendandceVo attendandceVo) {
        Page<AttendandceVo> page = new Page<>(attendandceVo.getCurrentPage(),attendandceVo.getPagesize());
        QueryWrapper<AttendandceVo> queryWrapper = new QueryWrapper<>();
        //根据方案名称查询
        if(attendandceVo.getAttendandceName()!=null){
            queryWrapper.like("a.ATTENDANDCE_NAME",attendandceVo.getAttendandceName());
        }
        //queryWrapper.eq("d.DEPT_NAME",workSchemeVo.getDeptName());
        queryWrapper.eq("a.IS_DELETED",0);
        return attendandceMapper.selectAttendandce(page,queryWrapper);
    }

    /**
     * 添加考勤扣款方案
     * @param attendandce
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAttendandce(Attendandce attendandce) {
        return attendandceMapper.insert(attendandce);
    }

    /**
     * 修改状态为禁用
     * @param attendandce
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAttendandceState(Attendandce attendandce) {
        final var i = attendandceMapper.updateById(attendandce);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改状态为启用
     * @param attendandce
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAttendandceStateTwo(Attendandce attendandce) {
        final var i = attendandceMapper.updateById(attendandce);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 删除考勤扣款方案
     * @param id
     * @return
     */
    @Override
    public String deleteAttendandce(Integer id) {
        String s = "成功";
        if (attendandceMapper.deleteById(id)<=0){
            return "删除考勤扣款方案失败";
        }
        return s;
    }

    /**
     * 根据id查询考勤扣款方案
     * @param attendandce
     * @return
     */
    @Override
    public List<Attendandce> selectAttendandceAll(Attendandce attendandce) {
        QueryWrapper<Attendandce> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ATTENDANDCE_ID",attendandce.getAttendandceId());
        return attendandceMapper.selectAttendandceAll(queryWrapper);
    }



    /**
     * 修改考勤扣款方案
     * @param attendandce
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAttendandce(Attendandce attendandce) {
        final var i = attendandceMapper.updateById(attendandce);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }
}
