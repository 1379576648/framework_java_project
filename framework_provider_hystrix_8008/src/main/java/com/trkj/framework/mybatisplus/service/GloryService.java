package com.trkj.framework.mybatisplus.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.vo.PunishGloryVo;
import com.trkj.framework.vo.WorkVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 奖励表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface GloryService {

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    List<WorkVo> selectGloryOne(WorkVo workVo);

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    int insertGlory(Glory glory);

    /**
     * 修改奖励
     * @param glory
     * @return
     */
    int updateGlory(Glory glory);

    /**
     * 删除奖励
     * @param list
     * @return
     */
    String deleteGlory(ArrayList<Integer> list);

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    IPage<PunishGloryVo> selectPunishGlory(PunishGloryVo punishGloryVo);


}
