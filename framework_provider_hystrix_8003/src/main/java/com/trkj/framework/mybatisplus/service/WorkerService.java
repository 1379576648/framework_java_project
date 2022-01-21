package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.vo.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 转正表 服务类
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface WorkerService {
    /**
     *  根据审批类型的转正/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectWorkerlAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的转正/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndWorkerlAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<WorkerDetaIsVo> selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo);


    /**
     * 根据部门编号查询其部门经理
     * @return
     */
    List<DeptPostVo>selectDeptPostName(DeptPostVo deptPostVo);

    /**
     * 根据部门编号查询其部门名称
     * @param dept
     * @return
     */
    List<Dept>selectDeptName(Dept dept);

    /**
     * 查询人事经理及总裁（总经理）
     * @return
     */
    List<DeptPostVo>selectpresident();

    /**
     * 添加转正 添加三个审批人
     * @param workerVo
     * @return
     */
    int SubmitPositive3(WorkerVo workerVo);

    /**
     * 添加转正 添加两个审批人
     * @param workerVo
     * @return
     */
    int SubmitPositive2(WorkerVo workerVo);

    /**
     * 根据员工名称是否有转正记录
     * @param workerVo
     * @return
     */
    Integer selectexaminerecord(WorkerVo workerVo);
}
