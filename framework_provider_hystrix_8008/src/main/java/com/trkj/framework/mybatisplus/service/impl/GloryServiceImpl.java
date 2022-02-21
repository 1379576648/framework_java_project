package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.mybatisplus.mapper.GloryMapper;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.vo.PunishGloryVo;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 奖励表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class GloryServiceImpl implements GloryService {

    @Autowired
    private GloryMapper gloryMapper;


    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectGloryOne(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("GLORY_ID",workVo.getGloryId());
        return gloryMapper.selectGloryOne(queryWrapper);
    }

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertGlory(Glory glory) {
        return gloryMapper.insert(glory);
    }

    /**
     * 修改奖励
     * @param glory
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateGlory(Glory glory) {
        final var i = gloryMapper.updateById(glory);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 删除奖励
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteGlory(ArrayList<Integer> list) {
        String s = "成功";
        for(int i =0;i<list.size();i++){
            //通过奖励编号删除奖励
            if(gloryMapper.delete(new QueryWrapper<Glory>().eq("GLORY_ID",list.get(i)))<=0){
                return "删除奖励失败";
            }else if(gloryMapper.delete(new QueryWrapper<Glory>().eq("GLORY_ID",list.get(i)))>=1){
                return "删除奖励成功";
            }
        }
        return s;
    }

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @Override
    public IPage<PunishGloryVo> selectPunishGlory(PunishGloryVo punishGloryVo) {
        Page<PunishGloryVo> page = new Page<>(punishGloryVo.getCurrentPage(),punishGloryVo.getPagesize());
        QueryWrapper<PunishGloryVo> queryWrapper = new QueryWrapper<>();
        //根据奖励名称查询
        if(punishGloryVo.getGloryName()!=null){
            queryWrapper.like("g.GLORY_NAME",punishGloryVo.getGloryName());
        }
        //根据惩罚类型
        if(punishGloryVo.getPunishType()!=null){
            queryWrapper.like("p.PUNISH_TYPE",punishGloryVo.getPunishType());
        }
        return gloryMapper.selectPunishGlory(page,queryWrapper);
    }
}
