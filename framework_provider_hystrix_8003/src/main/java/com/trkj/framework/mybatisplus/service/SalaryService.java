package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
import com.trkj.framework.vo.SalaryDetailsVo;

import java.util.List;

public interface SalaryService {
    /**
     *  根据审批类型的调薪/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectSalaryAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的调薪/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndSalaryAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<SalaryDetailsVo> selectDetailsSalary(SalaryDetailsVo salaryDetailsVo);
}
