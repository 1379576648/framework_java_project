package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.vo.WorkVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 惩罚表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface PunishService {

    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    List<WorkVo> selectPunishOne(WorkVo workVo);

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    int insertPunish(Punish punish);

    /**
     * 修改惩罚
     * @param punish
     * @return
     */
    int updatePunish(Punish punish);

    /**
     * 删除惩罚
     * @param list
     * @return
     */
    String deletePunish(ArrayList<Integer> list);


}
