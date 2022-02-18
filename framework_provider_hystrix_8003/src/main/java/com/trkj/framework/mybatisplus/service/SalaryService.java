package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.vo.*;

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

    /**
     * 根据员工名称是否有调薪记录
     * @param
     * @return
     */
    List<SalaryVo>  selectSalaryRecord(SalaryVo salaryVo);

    /**
     * 根据员工ID查询其基本工资
     * @param fixedwagf
     * @return
     */
    Integer selectPay(Fixedwagf fixedwagf);

    /**
     * 添加调薪 添加三个审批人
     * @param salaryVo
     * @return
     */
    int SubmitSalary3(SalaryVo salaryVo)throws ArithmeticException;

    /**
     * 添加调薪 添加两个审批人
     * @param salaryVo
     * @return
     */
    int SubmitSalary2(SalaryVo salaryVo)throws ArithmeticException;

    /**
     * 添加调薪 添加一个审批人
     * @param salaryVo
     * @return
     */
    Integer SubmitSalary1(SalaryVo salaryVo)throws ArithmeticException;

}
