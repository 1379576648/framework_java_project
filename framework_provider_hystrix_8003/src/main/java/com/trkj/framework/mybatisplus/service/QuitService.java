package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
import com.trkj.framework.vo.QuitVo;
import com.trkj.framework.vo.SalaryVo;

import java.util.List;

public interface QuitService {
    /**
     *  根据审批类型的离职/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectQuitAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的离职/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndQuitAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<QuitDetailsVo> selectDetailsQuit(QuitDetailsVo quitDetailsVo);

    /**
     * 根据员工名称是否有调薪记录
     * @param
     * @return
     */
    Integer selectDimissionRecord(Quit quit);

    /**
     * 添加离职 添加三个审批人
     * @param quitVo
     * @return
     */
    int submitToLeave3(QuitVo quitVo);

    /**
     * 添加调薪 添加三个审批人
     * @param quitVo
     * @return
     */
    int submitToLeave2(QuitVo quitVo);
}
