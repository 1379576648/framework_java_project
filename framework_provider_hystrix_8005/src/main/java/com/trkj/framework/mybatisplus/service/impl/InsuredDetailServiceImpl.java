package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.InsuredDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.hibernate.query.ImmutableEntityUpdateQueryHandlingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * <p>
 * 参保明细表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Service
public class InsuredDetailServiceImpl implements InsuredDetailService {

    @Autowired
    private InsuredDetailMapper insuredDetailMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private InsuredSchemeMapper insuredSchemeMapper;

    @Autowired
    private InsuredPaymentMapper insuredPaymentMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private DefInsuredMapper defInsuredMapper;

    @Autowired
    private InsuredArchiveMapper insuredArchiveMapper;
    @Autowired
    private DefSchemeMapper defSchemeMapper;

    @Autowired
    private InsuredLogMapper insuredLogMapper;

    @Autowired
    private DeptPostMapper deptPostMapper;

    /***
     * 分页查询参保明细
     * @param insuredDetail
     * @return
     */
    @Override
    public Object selectPageIsuredDetail(InsuredDetail insuredDetail) {
        //分页插件
        Page<InsuredDetail> page = new Page<>(insuredDetail.getCurrenPage(), insuredDetail.getPageSize());
        //条件构造器
        QueryWrapper<InsuredDetail> queryWrapper = new QueryWrapper<>();
        //判断名称是否为空
        if (insuredDetail.getStaffName() != null && !insuredDetail.getStaffName().equals("")) {
            //根据姓名模糊查询
            queryWrapper.like("b.STAFF_NAME", insuredDetail.getStaffName());
        }

        //判断员工状态是否为空
        if (insuredDetail.getStaffState() != null) {
            //根据员工状态查询
            queryWrapper.eq("b.STAFF_STATE", insuredDetail.getStaffState());
        }
        //是否被删除
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        //编号倒叙
        queryWrapper.orderByDesc("a.INS_DETAIL_ID");
        //当前月
        int year = new Date().getYear() + 1900;
        int month = new Date().getMonth() + 1;
        queryWrapper.eq("to_char(a.INS_DETAIL_INSURED_MONTH,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month);
        //判断部门列表是否为空
        if (insuredDetail.getDeptIdList().size() > 0) {
            for (int i = 0; i < insuredDetail.getDeptIdList().size(); i++) {
                //根据部门列表查询
                queryWrapper.eq("c.DEPT_ID", insuredDetail.getDeptIdList().get(i));
            }
        }

        return insuredDetailMapper.pageInsuredDetail(page, queryWrapper);
    }

    /***
     * 查询所有的部门列表
     * @return
     */
    @Override
    public Object deptList() {
        return deptMapper.selectList(new QueryWrapper<Dept>().eq("DEPT_STATE", 0));
    }


    /***
     * 多选删除参保
     * @param insuredDetail
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteInsuredDetail(InsuredDetail insuredDetail) throws ArithmeticException {
        for (int i = 0; i < insuredDetail.getStaffIdList().size(); i++) {
            Staff staff = staffMapper.selectById(insuredDetail.getStaffIdList().get(i));
            if (staff == null) {
                throw new ArithmeticException("删除失败");
            }
            InsuredLog insuredLog = new InsuredLog();
            //当前月
            int year = new Date().getYear() + 1900;
            int month = new Date().getMonth() + 1;
            InsuredPayment insuredPayment = insuredPaymentMapper.selectOne(
                    new QueryWrapper<InsuredPayment>()
                            .eq("STAFF_ID", insuredDetail.getStaffIdList().get(i))
                            .eq("to_char(INSURED_PAYMENT_INSURED_MONTH,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month));
            insuredLog.setInsLogIdTheInsured(staff.getStaffName());
            insuredLog.setInsLogUpdateObject(insuredDetail.getStaffName());
            insuredLog.setInsLogColor("rgb(243, 18, 18)");
            insuredLog.setInsLogSocialInsuredMonth(insuredPayment.getInsuredPaymentInsuredMonth());
            insuredLog.setInsLogSocialSalaryMonth(insuredPayment.getInsuredPaymentSalaryMonth());
            insuredLog.setInsLogFundInsuredMonth(insuredPayment.getInsuredPaymentInsuredMonth());
            insuredLog.setInsLogFundSalaryMonth(insuredPayment.getInsuredPaymentSalaryMonth());
            insuredLog.setInsLogExplain("删除社保公积金");
            InsuredScheme insuredScheme = insuredSchemeMapper.selectOne(new QueryWrapper<InsuredScheme>().eq("INSURED_SCHEME_ID", insuredPayment.getInsuredSchemeId()));
            if (insuredScheme==null){
                throw new ArithmeticException("删除失败");
            }
            DefInsured defInsured = defInsuredMapper.selectById(insuredScheme.getDefInsuredId());
            if (defInsured==null){
                throw new ArithmeticException("删除失败");
            }

            insuredLog.setInsLogInsuredName(defInsured.getDefInsuredName());
            insuredLog.setInsLogFundNumber(insuredPayment.getInsuredPaymentFundNumber());
            insuredLog.setInsLogSocialNumber(insuredPayment.getInsuredPaymentSocialNumber());
            if (insuredLogMapper.insert(insuredLog) <= 0) {
                throw new ArithmeticException("删除失败");
            }
            //修改参保方案的人数
            defInsured.setDefInsuredNumber(defInsured.getDefInsuredNumber() - 1);
            if (defInsuredMapper.updateById(defInsured) <= 0) {
                throw new ArithmeticException("删除失败");
            }
            //删除参保方案表
            if (insuredSchemeMapper.delete(new QueryWrapper<InsuredScheme>().eq("STAFF_ID", staff.getStaffId())) <= 0) {
                throw new ArithmeticException("删除失败");
            }
            //删除参保缴纳表
            if (insuredPaymentMapper.delete(new QueryWrapper<InsuredPayment>().eq("STAFF_ID", staff.getStaffId())) <= 0) {
                throw new ArithmeticException("删除失败");
            }
            //删除参保明细表
            if (insuredDetailMapper.delete(new QueryWrapper<InsuredDetail>().eq("INS_DETAIL_STAFF_NAME", staff.getStaffName())) <= 0) {
                throw new ArithmeticException("删除失败");
            }
        }
        return "成功";
    }

    /***
     * 归档
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String pigeonhole() throws ArithmeticException{
        //当前月
        int year = new Date().getYear() + 1900;
        int month = new Date().getMonth() + 1;
        List<InsuredDetail> insuredDetails = insuredDetailMapper.selectList(
                new QueryWrapper<InsuredDetail>().eq("to_char(INS_DETAIL_SALARY_MONTH,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month));
        for (int i = 0; i < insuredDetails.size(); i++) {
            //初始化实体类
            InsuredArchive insuredArchive = new InsuredArchive();
            InsuredLog insuredLog = new InsuredLog();
            insuredArchive.setInsArchiveStaffName(insuredDetails.get(i).getInsDetailStaffName());
            insuredArchive.setInsArchiveInsuredName(insuredDetails.get(i).getInsDetailInsuredName());
            //当前月
            year = insuredDetails.get(i).getInsDetailInsuredMonth().getYear() + 1900;
            month = insuredDetails.get(i).getInsDetailInsuredMonth().getMonth() + 1;
            insuredArchive.setInsArchiveName(month > 9 ? year + "-" + month : year + "-" + "0" + month + " 社保公积金");
            insuredArchive.setInsArchiveSocialPersonPay(insuredDetails.get(i).getInsDetailSocialPersonPay());
            insuredArchive.setInsArchiveSocialFirmPay(insuredDetails.get(i).getInsDetailSocialFirmPay());
            insuredArchive.setInsArchiveFundPersonPay(insuredDetails.get(i).getInsDetailFundPersonPay());
            insuredArchive.setInsArchiveFundFirmPay(insuredDetails.get(i).getInsDetailFundFirmPay());
            insuredArchive.setInsArchiveInsuredMonth(insuredDetails.get(i).getInsDetailInsuredMonth());
            insuredArchive.setInsArchiveSalaryMonth(insuredDetails.get(i).getInsDetailSalaryMonth());
            Staff staff = staffMapper.selectOne(new QueryWrapper<Staff>().eq("STAFF_NAME", insuredDetails.get(i).getInsDetailStaffName()));
            if (staff == null) {
                throw new ArithmeticException("归档失败");
            }
            insuredLog.setInsLogIdTheInsured(staff.getStaffName());
            insuredLog.setInsLogUpdateObject("自动");
            insuredLog.setInsLogExplain("提交社保公积金");
            insuredLog.setInsLogColor("rgb(49, 222, 0)");
            insuredLog.setInsLogInsuredName(insuredDetails.get(i).getInsDetailInsuredName());
            Dept dept = deptMapper.selectById(staff.getDeptId());
            if (dept == null) {
                throw new ArithmeticException("归档失败");
            }
            DeptPost deptPost = deptPostMapper.selectById(staff.getDeptPostId());
            if (deptPost == null) {
                throw new ArithmeticException("归档失败");
            }
            InsuredPayment insuredPayment = insuredPaymentMapper.selectOne(
                    new QueryWrapper<InsuredPayment>().eq("INS_DETAIL_ID", insuredDetails.get(i).getInsDetailId()));
            if (insuredPayment == null) {
                throw new ArithmeticException("归档失败");
            }
            insuredArchive.setInsArchiveDeptName(dept.getDeptName());
            insuredArchive.setInsArchivePostName(deptPost.getPostName());
            insuredArchive.setInsArchiveSocialNumber(insuredPayment.getInsuredPaymentSocialNumber());
            insuredArchive.setInsArchiveFundNumber(insuredPayment.getInsuredPaymentFundNumber());

            InsuredScheme insuredScheme = insuredSchemeMapper.selectOne(
                    new QueryWrapper<InsuredScheme>().eq("INSURED_SCHEME_ID", insuredPayment.getInsuredSchemeId()));
            if (insuredScheme == null) {
                throw new ArithmeticException("归档失败");
            }
            insuredLog.setInsLogSocialNumber(insuredPayment.getInsuredPaymentSocialNumber());
            insuredLog.setInsLogFundNumber(insuredPayment.getInsuredPaymentFundNumber());
            List<DefScheme> defSchemeList = defSchemeMapper.selectList(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID", insuredScheme.getDefInsuredId()));
            for (int j = 0; j < defSchemeList.size(); j++) {
                if (defSchemeList.get(j).getDefSchemeType().equals("养老保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveSocialMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveSocialMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchivePrFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchivePrUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchivePrNumber(aLong);
                    insuredArchive.setInsArchivePrPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchivePrPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchivePrFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchivePrFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                } else if (defSchemeList.get(j).getDefSchemeType().equals("失业保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveSocialMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveSocialMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchiveUnFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchiveUnUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchiveUnNumber(aLong);
                    insuredArchive.setInsArchiveUnPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchiveUnPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchiveUnFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchiveUnFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                } else if (defSchemeList.get(j).getDefSchemeType().equals("工伤保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveSocialMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveSocialMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchiveOcFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchiveOcUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchiveOcNumber(aLong);
                    insuredArchive.setInsArchiveOcPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchiveOcPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchiveOcFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchiveOcFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                } else if (defSchemeList.get(j).getDefSchemeType().equals("生育保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveSocialMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveSocialMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchiveGiFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchiveGiUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchiveGiNumber(aLong);
                    insuredArchive.setInsArchiveGiPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchiveGiPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchiveGiFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchiveGiFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                } else if (defSchemeList.get(j).getDefSchemeType().equals("医疗保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveSocialMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveSocialMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchiveMdFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchiveMdUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchiveMdNumber(aLong);
                    insuredArchive.setInsArchiveMdPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchiveMdPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchiveMdFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchiveMdFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                } else if (defSchemeList.get(j).getDefSchemeType().equals("公积金")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getInsuredPaymentFundNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getInsuredPaymentFundNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getInsuredPaymentFundNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredArchive.setInsArchiveFundMin(defSchemeList.get(j).getDefSchemeMin());
                    insuredArchive.setInsArchiveFundMax(defSchemeList.get(j).getDefSchemeMax());
                    insuredArchive.setInsArchiveFuFloor(defSchemeList.get(j).getDefSchemeFloor());
                    insuredArchive.setInsArchiveFuUpper(defSchemeList.get(j).getDefSchemeUpper());
                    insuredArchive.setInsArchiveFuNumber(aLong);
                    insuredArchive.setInsArchiveFuPersonProp(defSchemeList.get(j).getDefSchemePersonProp());
                    insuredArchive.setInsArchiveFuPersonSum(defSchemeList.get(j).getDefSchemePersonSum());
                    insuredArchive.setInsArchiveFuFirmProp(defSchemeList.get(j).getDefSchemeFirmProp());
                    insuredArchive.setInsArchiveFuFirmSum(defSchemeList.get(j).getDefSchemeFirmSum());
                }
            }

            //添加归档表
            if (insuredArchiveMapper.insert(insuredArchive) <= 0) {
                throw new ArithmeticException("归档失败");
            }


            //删除参保明细表
            if (insuredDetailMapper.deleteById(insuredDetails.get(i).getInsDetailId()) <= 0) {
                throw new ArithmeticException("归档失败");
            }
            //添加下一个月的参保明细表数据
            Calendar cal = Calendar.getInstance();
            cal.setTime(insuredDetails.get(i).getInsDetailInsuredMonth());
            cal.add(Calendar.MONTH, 1);
            insuredDetails.get(i).setInsDetailInsuredMonth(cal.getTime());
            insuredDetails.get(i).setInsDetailSalaryMonth(cal.getTime());
            if (insuredDetailMapper.insert(insuredDetails.get(i)) <= 0) {
                throw new ArithmeticException("归档失败");
            }

            //删除参保缴纳表
            if (insuredPaymentMapper.deleteById(insuredPayment.getInsuredPaymentId()) <= 0) {
                throw new ArithmeticException("归档失败");
            }
            //删除参保方案表
            if (insuredSchemeMapper.delete(
                    new QueryWrapper<InsuredScheme>().eq("INSURED_SCHEME_ID", insuredPayment.getInsuredSchemeId())) <= 0) {
                throw new ArithmeticException("归档失败");
            }
            //添加下个月参保方案表的数据
            if (insuredSchemeMapper.insert(insuredScheme) <= 0) {
                throw new ArithmeticException("归档失败");
            }
            //添加下一个月的参保缴纳表数据
            insuredLog.setInsLogSocialInsuredMonth(cal.getTime());
            insuredLog.setInsLogSocialSalaryMonth(cal.getTime());
            insuredLog.setInsLogFundInsuredMonth(cal.getTime());
            insuredLog.setInsLogFundSalaryMonth(cal.getTime());
            insuredPayment.setInsuredPaymentInsuredMonth(cal.getTime());
            insuredPayment.setInsuredPaymentSalaryMonth(cal.getTime());
            insuredPayment.setInsuredSchemeId(insuredPayment.getInsuredSchemeId());
            insuredPayment.setInsDetailId(insuredPayment.getInsDetailId());
            if (insuredPaymentMapper.insert(insuredPayment) <= 0) {
                throw new ArithmeticException("归档失败");
            }
            if (insuredLogMapper.insert(insuredLog) <= 0) {
                throw new ArithmeticException("归档失败");
            }

        }
        return "成功";
    }

    /***
     * 归档数据查询
     * @return
     */
    @Override
    public Object archived(InsuredArchive insuredArchive) {
        Page<InsuredArchive> insuredArchivePage = new Page<InsuredArchive>(insuredArchive.getCurrenPage(), insuredArchive.getPageSize());
        IPage<InsuredArchive> archiveIPage = insuredArchiveMapper.archived(insuredArchivePage);
        for (int i = 0; i < archiveIPage.getRecords().size(); i++) {
            InsuredArchive insuredArchive1 = insuredArchiveMapper.selectOne(
                    new QueryWrapper<InsuredArchive>()
                            .eq("INS_ARCHIVE_NAME", archiveIPage.getRecords().get(i).getInsArchiveName())
                            .select("sum(INS_ARCHIVE_SOCIAL_PERSON_PAY+INS_ARCHIVE_FUND_PERSON_PAY) as INS_ARCHIVE_SOCIAL_PERSON_PAY,sum(INS_ARCHIVE_SOCIAL_FIRM_PAY+INS_ARCHIVE_FUND_FIRM_PAY) as INS_ARCHIVE_SOCIAL_FIRM_PAY,count(INS_ARCHIVE_NAME) as quantity"));
            if (insuredArchive1 == null) {
                return "查询数据有误";
            }
            archiveIPage.getRecords().get(i).setQuantity(insuredArchive1.getQuantity());
            archiveIPage.getRecords().get(i).setInsArchiveSocialPersonPay(insuredArchive1.getInsArchiveSocialPersonPay());
            archiveIPage.getRecords().get(i).setInsArchiveSocialFirmPay(insuredArchive1.getInsArchiveSocialFirmPay());
        }
        return archiveIPage;
    }

    /***
     * 查询某一个月份的归档明细
     * @param name
     * @return
     */
    @Override
    public Object archivedInMonth(String name) {
        return insuredArchiveMapper.selectList(new QueryWrapper<InsuredArchive>().eq("INS_ARCHIVE_NAME", name));
    }

    /****
     * 删除某一个月的归档数据
     * @param map
     * @return
     */
    @Override
    public String deleteArchivedInName(Map<String, Object> map) {
        int row = insuredArchiveMapper.delete(new QueryWrapper<InsuredArchive>().eq("INS_ARCHIVE_NAME", map.get("name")));
        if (row <= 0) {
            return "删除失败";
        }
        return "成功";
    }

    /***
     * 通过员工名称获取职位名称
     * @param name
     * @return
     */
    @Override
    public String selectPostName(String name) {
        Staff staff = staffMapper.selectOne(new QueryWrapper<Staff>().eq("STAFF_NAME", name));
        if (staff == null) {
            return "获取职位名称失败";
        }
        DeptPost deptPost = deptPostMapper.selectById(staff.getDeptPostId());
        if (deptPost == null) {
            return "获取职位名称失败";
        }
        return deptPost.getPostName();
    }


    /***
     * 通过明细编号查询
     * @param id
     * @return
     */
    @Override
    public Object selectListScheme(Integer id) {
        InsuredPayment insuredPayment =insuredPaymentMapper.selectOne(new QueryWrapper<InsuredPayment>().eq("INS_DETAIL_ID",id));
        if (insuredPayment==null){
            return "查询明细失败";
        }
        InsuredScheme insuredScheme = insuredSchemeMapper.selectById(insuredPayment.getInsuredSchemeId());
        if (insuredScheme == null) {
            return "查询明细失败";
        }
        List<DefScheme> defSchemeList = defSchemeMapper.selectList(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID",insuredScheme.getDefInsuredId()));
        for (int j = 0; j < defSchemeList .size(); j++){
            if (defSchemeList.get(j).getDefSchemeType().equals("养老保险")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentSocialNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            } else if (defSchemeList.get(j).getDefSchemeType().equals("失业保险")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentSocialNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            } else if (defSchemeList.get(j).getDefSchemeType().equals("工伤保险")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentSocialNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            } else if (defSchemeList.get(j).getDefSchemeType().equals("生育保险")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentSocialNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            } else if (defSchemeList.get(j).getDefSchemeType().equals("医疗保险")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentSocialNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            } else if (defSchemeList.get(j).getDefSchemeType().equals("公积金")) {
                Double integer = 0.0;
                Double aLong = 0.0;
                //判断基数多少
                if (insuredPayment.getInsuredPaymentFundNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                    integer = defSchemeList.get(j).getDefSchemeMin();
                } else if (insuredPayment.getInsuredPaymentFundNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                    integer = defSchemeList.get(j).getDefSchemeMax();
                } else {
                    integer = insuredPayment.getInsuredPaymentFundNumber();
                }
                //判断基数上下限
                if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                    aLong = defSchemeList.get(j).getDefSchemeFloor();
                } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                    aLong = defSchemeList.get(j).getDefSchemeUpper();
                } else {
                    aLong = integer;
                }
                //缴纳基数
                defSchemeList.get(j).setNumber(aLong);
                //小计
                defSchemeList.get(j).setStatistics(
                        (aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                defSchemeList.get(j).getDefSchemeFirmSum())+( aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                defSchemeList.get(j).getDefSchemePersonSum())
                );
                //四舍五入
                defSchemeList.get(j).setStatistics((double) Math.round( defSchemeList.get(j).getStatistics() * 100) / 100);
            }

        }
        Map<String,Object> map = new HashMap<>(2);
        map.put("defSchemeList",defSchemeList);
        map.put("insuredPayment",insuredPayment);
        return map;
    }

    /***
     *查询某一个员工某一个月的参保日志
     * @param name
     * @param month
     * @return
     */
    @Override
    public Object selectInsuredLog(String name, String month) {
        return insuredLogMapper.selectList(
                new QueryWrapper<InsuredLog>()
                        .eq("INS_LOG_ID_THE_INSURED",name)
                        .eq("to_char(INS_LOG_SOCIAL_SALARY_MONTH,'YYYY-MM')",month)
                        .orderByAsc("CREATED_TIME")
        );
    }



}
