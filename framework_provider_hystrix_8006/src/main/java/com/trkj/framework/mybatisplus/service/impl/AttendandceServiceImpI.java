package com.trkj.framework.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

//    /**
//     * 添加加班方案
//     * @param workScheme
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int insertWorkScheme(WorkScheme workScheme) {
//        return workSchemeMapper.insert(workScheme);
//    }
//
//    /**
//     * 修改状态为禁用
//     * @param workScheme
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int updateWorkSchemeState(WorkScheme workScheme) {
//        final var i = workSchemeMapper.updateById(workScheme);
//        if (i>=1){
//            return 999;
//        }else {
//            return 100;
//        }
//    }
//
//    /**
//     * 修改状态为启用
//     * @param workScheme
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int updateWorkSchemeStateTwo(WorkScheme workScheme) {
//        final var i = workSchemeMapper.updateById(workScheme);
//        if (i>=1){
//            return 999;
//        }else {
//            return 100;
//        }
//    }
//
//    /**
//     * 删除加班方案
//     * @param list
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public String deleteWorkScheme(ArrayList<Integer> list) {
//        String s = "成功";
//        for(int i =0;i<list.size();i++){
//            //通过奖励编号删除奖励
//            if(workSchemeMapper.delete(new QueryWrapper<WorkScheme>().eq("WORKSCHEME_ID",list.get(i)))<=0){
//                return "删除加班方案失败";
//            }else if(workSchemeMapper.delete(new QueryWrapper<WorkScheme>().eq("WORKSCHEME_ID",list.get(i)))>=1){
//                return "删除加班方案成功";
//            }
//        }
//        return s;
//    }
//
//    /**
//     * 根据id查询加班方案
//     * @param workScheme
//     * @return
//     */
//    @Override
//    public List<WorkScheme> selectWorkSchemeAll(WorkScheme workScheme) {
//        QueryWrapper<WorkScheme> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("WORKSCHEME_ID",workScheme.getWorkSchemeId());
//        return workSchemeMapper.selectWorkSchemeAll(queryWrapper);
//    }
//
//    /**
//     * 修改加班方案
//     * @param workScheme
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int updateWorkScheme(WorkScheme workScheme) {
//        final var i = workSchemeMapper.updateById(workScheme);
//        if (i>=1){
//            return 999;
//        }else {
//            return 100;
//        }
//    }
}
