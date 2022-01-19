package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.mapper.GloryMapper;
import com.trkj.framework.mybatisplus.mapper.PunishMapper;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.mybatisplus.service.PunishService;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 惩罚表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class PunishServiceImpl implements PunishService {

    @Autowired
    private PunishMapper punishMapper;


    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectPunishOne(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PUNISH_ID",workVo.getPunishId());
        return punishMapper.selectPunishOne(queryWrapper);
    }

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPunish(Punish punish) {
        return punishMapper.insert(punish);
    }

    /**
     * 修改惩罚
     * @param punish
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePunish(Punish punish) {
        final var i = punishMapper.updateById(punish);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 删除惩罚
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deletePunish(ArrayList<Integer> list) {
        String s = "成功";
        for(int i =0;i<list.size();i++){
            //通过惩罚编号删除惩罚
            if(punishMapper.delete(new QueryWrapper<Punish>().eq("PUNISH_ID",list.get(i)))<=0){
                return "删除惩罚失败";
            }else if(punishMapper.delete(new QueryWrapper<Punish>().eq("PUNISH_ID",list.get(i)))>=1){
                return "删除惩罚成功";
            }
        }
        return s;
    }
}
