package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.vo.AttendandceVo;
import com.trkj.framework.vo.WorkSchemeVo;

import java.util.ArrayList;
import java.util.List;

public interface AttendandceService {

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    IPage<AttendandceVo> selectAttendandce(AttendandceVo attendandceVo);

    /**
     * 添加考勤扣款方案
     * @param attendandce
     * @return
     */
    int insertAttendandce(Attendandce attendandce);


    /**
     * 修改状态为禁用
     * @param attendandce
     * @return
     */
    int updateAttendandceState(Attendandce attendandce);

    /**
     * 修改状态为启用
     * @param attendandce
     * @return
     */
    int updateAttendandceStateTwo(Attendandce attendandce);

    /**
     * 删除考勤扣款方案
     * @param id
     * @return
     */
    String deleteAttendandce(Integer id);

    /**
     * 根据id查询考勤扣款方案
     * @param attendandce
     * @return
     */
    List<Attendandce> selectAttendandceAll(Attendandce attendandce);

    /**
     * 修改考勤扣款方案
     * @param attendandce
     * @return
     */
    int updateAttendandce(Attendandce attendandce);
}
