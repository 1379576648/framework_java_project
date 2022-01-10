package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
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
}
