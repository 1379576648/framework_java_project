package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.vo.*;

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
     * 根据员工名称是否有离职记录
     * @param
     * @return
     */
    List<QuitDetailsVo>  selectDimissionRecord(QuitDetailsVo quitDetailsVo);

    /**
     * 添加离职 添加三个审批人
     * @param quitVo
     * @return
     */
    int submitToLeave3(QuitVo quitVo)throws ArithmeticException;

    /**
     * 添加调薪 添加两个审批人
     * @param quitVo
     * @return
     */
    int submitToLeave2(QuitVo quitVo)throws ArithmeticException;

    /**
     * 添加调薪 添加一个审批人
     * @param quitVo
     * @return
     */
    Integer submitToLeave1(QuitVo quitVo)throws ArithmeticException;
}
