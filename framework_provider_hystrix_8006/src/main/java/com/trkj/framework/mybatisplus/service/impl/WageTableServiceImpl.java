package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.WageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WageTableServiceImpl implements WageTableService {

    @Autowired
    private WageTableMapper wageTableMapper;

    @Autowired
    private QuitMapper quitMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private DeptPostMapper deptPostMapper;

    @Autowired
    private FixedwagfMapper fixedwagfMapper;

    @Autowired
    private OvertimeaskMapper overtimeaskMapper;

    @Autowired
    private WorkSchemeMapper workSchemeMapper;

    @Autowired
    private AttendandceMapper attendandceMapper;

    @Autowired
    private ClockRecordMapper clockRecordMapper;

    @Autowired
    private ArchiveMapper archiveMapper;

    @Autowired
    private InsuredArchiveMapper insuredArchiveMapper;

    @Autowired
    private TravelMapper travelMapper;

    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private MoneyPigeonholeMapper moneyPigeonholeMapper;


    /**
     * 查询工资表
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String selectWage() {
        List<Staff> staffList = new ArrayList<>();
        List<MoneyPigeonhole> moneyPigeonholeList = moneyPigeonholeMapper.selectList(
                new QueryWrapper<MoneyPigeonhole>()
                        .eq("MONEYPIGEONHOLE_STATE", 0));
        if (moneyPigeonholeList.size() <= 0) {
            //当前月
            int year = new Date().getYear() + 1900;
            int month = new Date().getMonth() + 1;
            List<MoneyPigeonhole> moneyPigeonholeList1 = moneyPigeonholeMapper.selectList(
                    new QueryWrapper<MoneyPigeonhole>()
                            .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month));
            if (moneyPigeonholeList1.size() >= 1) {
                return "本月已核算";
            }
            staffList = staffMapper.selectListOrState();
            for (int i = 0; i < staffList.size(); i++) {
                MoneyPigeonhole moneyPigeonhole = new MoneyPigeonhole();
                System.out.println("111111111111111111");
                //查询加班表
                List<Overtimeask> overtimeaskList = overtimeaskMapper.selectList(
                                new QueryWrapper<Overtimeask>()
                                        .eq("STAFF_NAME", staffList.get(i).getStaffName())
                                        .eq("OVERTIMEASK_STATE", 1)
                                        .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + (month - 1)));
                System.out.println(overtimeaskList);
                //加班方案
                WorkScheme workscheme_state = workSchemeMapper.selectOne(
                        new QueryWrapper<WorkScheme>()
                                .eq("WORKSCHEME_STATE", 0)
                                .eq("DEPT_NAME", staffList.get(i).getDeptName()));
                if (workscheme_state != null) {
                    for (int j = 0; j < overtimeaskList.size(); j++) {
                        if (overtimeaskList.get(j).getOvertimeaskType().equals("工作日加班")) {
                            System.out.println("222222222222222222222222222222222");
                            staffList.get(i).setWorkMoney(staffList.get(i).getWorkMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeWorkratio());
                        } else if (overtimeaskList.get(j).getOvertimeaskType().equals("休息日加班")) {
                            staffList.get(i).setOffMoney(staffList.get(i).getOffMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeDayoffratio());
                        } else if (overtimeaskList.get(j).getOvertimeaskType().equals("节假日加班")) {
                            staffList.get(i).setHolidayMoney(staffList.get(i).getHolidayMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeHolidayratio());
                        }
                    }
                }
                //查询出查表
                List<Travel> travelList = travelMapper.selectList(
                        new QueryWrapper<Travel>()
                                .eq("STAFF_NAME", staffList.get(i).getStaffName())
                                .eq("TRAVEL_CONDITION", 1)
                                .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + (month - 1)));
                //查询出差方案
                Business business = businessMapper.selectOne(
                        new QueryWrapper<Business>()
                                .eq("BUSINESS_STATE", 0)
                                .eq("DEPT_NAME", staffList.get(i).getDeptName()));
                if (business != null) {
                    for (int y = 0; y < travelList.size(); y++) {
                        if (travelList.get(y).getTravelActualTokinaga() != null) {
                            staffList.get(i).setTravelMoney(staffList.get(i).getTravelMoney() + travelList.get(y).getTravelActualTokinaga() * business.getBusinessOnemoney());
                        } else if (travelList == null) {
                            staffList.get(i).setTravelMoney(0.0);
                        }
                    }
                }
                //打卡记录
                List<ClockRecord> clockRecordList = clockRecordMapper.selectList(
                        new QueryWrapper<ClockRecord>()
                                .eq("STAFF_NAME", staffList.get(i).getStaffName())
                                .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + (month - 1)));
                //考勤月报表
                Archive archive = archiveMapper.selectOne(
                        new QueryWrapper<Archive>()
                                .eq("STAFF_NAME", staffList.get(i).getStaffName())
                                .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + (month - 1))

                );
                //考勤扣款方案
                Attendandce attendandce = attendandceMapper.selectOne(
                        new QueryWrapper<Attendandce>().eq("ATTENDANDCE_STATE", 0)
                                .eq("DEPT_NAME", staffList.get(i).getDeptName()));
                if (attendandce != null) {
                    if (archive != null) {
                        for (int x = 0; x < clockRecordList.size(); x++) {
                            if (clockRecordList.get(x).getCheckState().equals("早退")) {
                                staffList.get(i).setElaryMoney(staffList.get(i).getElaryMoney() + archive.getLeaveEarlyFrequency() * attendandce.getAttendandceLeavemoney());
                            } else if (clockRecordList.get(x).getCheckState().equals("迟到")) {
                                staffList.get(i).setLateMoney(staffList.get(i).getLateMoney() + archive.getLateFrequency() * attendandce.getAttendandceLitemoney());
                            } else if (clockRecordList.get(x).getCheckState().equals("旷工")) {
                                staffList.get(i).setLeaveMoney(staffList.get(i).getLeaveMoney() + archive.getAbsenteeismFrequency() * attendandce.getAttendandceAbscntmoney());
                            }
                        }
                    }
                }
                //查询社保归档表
                InsuredArchive insuredArchive = insuredArchiveMapper.selectOne(
                        new QueryWrapper<InsuredArchive>()
                                .eq("INS_ARCHIVE_STAFF_NAME", staffList.get(i).getStaffName())
                                .eq("to_char(INS_ARCHIVE_INSURED_MONTH,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + (month - 1))
                );
                if (insuredArchive == null) {
                    staffList.get(i).setInsuredArchive(new InsuredArchive());
                    //个人缴纳社保
                    staffList.get(i).getInsuredArchive().setInsArchiveSocialPersonPay(0.0);
                    //公司缴纳社保
                    staffList.get(i).getInsuredArchive().setInsArchiveSocialFirmPay(0.0);
                    //个人缴纳公积金
                    staffList.get(i).getInsuredArchive().setInsArchiveFundPersonPay(0.0);
                    //公司缴纳公积金
                    staffList.get(i).getInsuredArchive().setInsArchiveFundFirmPay(0.0);
                } else {
                    staffList.get(i).setInsuredArchive(insuredArchive);
                }

                //查询基本工资
                Fixedwagf fixedwagf = fixedwagfMapper.selectOne(new QueryWrapper<Fixedwagf>().eq("STAFF_NAME", staffList.get(i).getStaffName()));
                if (fixedwagf != null) {
                    System.out.println("11111111111111111111");
                    System.out.println(fixedwagf);
                    System.out.println(staffList.get(i));
                    if (staffList.get(i).getStaffState().equals(1L)) {
                        double f = Double.parseDouble(new java.text.DecimalFormat("#.00").format(fixedwagf.getFixedwageOfflcialpostmoney() + fixedwagf.getFixedwageOfficialmoney()));
                        staffList.get(i).setBaseWage(f);
                    } else {
                        double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(fixedwagf.getFixedwagePeriodpostmoney() + fixedwagf.getFixedwagePeriodmoney()));
                        staffList.get(i).setBaseWage(x);
                    }
                }
                //工资合计
                staffList.get(i).setTotalWage(
                        staffList.get(i).getBaseWage() +
                                staffList.get(i).getWorkMoney()
                                + staffList.get(i).getOffMoney()
                                + staffList.get(i).getHolidayMoney()
                                + staffList.get(i).getTravelMoney()
                                + staffList.get(i).getInsuredArchive().getInsArchiveSocialFirmPay()
                                + staffList.get(i).getInsuredArchive().getInsArchiveFundFirmPay());
                double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staffList.get(i).getTotalWage()));
                staffList.get(i).setTotalWage(x);
                //实发工资
                staffList.get(i).setSalarySum(
                        staffList.get(i).getTotalWage() -
                                staffList.get(i).getElaryMoney() -
                                staffList.get(i).getLateMoney() -
                                staffList.get(i).getLateMoney() -
                                staffList.get(i).getInsuredArchive().getInsArchiveSocialPersonPay() -
                                staffList.get(i).getInsuredArchive().getInsArchiveFundPersonPay());
                double y = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staffList.get(i).getSalarySum()));
                staffList.get(i).setSalarySum(y);
                if (archive == null) {
                    archive = new Archive();
                    //早退次数
                    archive.setLeaveEarlyFrequency(0);
                    //迟到次数
                    archive.setLateFrequency(0);
                    //旷工次数
                    archive.setAbsenteeismFrequency(0);

                }
                //早退次数
                staffList.get(i).setElaryMoneycs(archive.getLeaveEarlyFrequency());
                //迟到次数
                staffList.get(i).setLateMoneycs(archive.getLateFrequency());
                //旷工次数
                staffList.get(i).setLeaveMoneycs(archive.getAbsenteeismFrequency());

                //部门名称
                moneyPigeonhole.setDeptName(staffList.get(i).getDeptName());
                //应发工资
                moneyPigeonhole.setMoneyPigeonholeSalary(staffList.get(i).getTotalWage());
                //实发工资
                moneyPigeonhole.setMoneyPigeonholePayrollSalary(staffList.get(i).getSalarySum());
                //公司缴纳
                moneyPigeonhole.setMoneyPigeonholeFirmPayment(staffList.get(i).getCountcPay());
                //员工成本
                moneyPigeonhole.setMoneyPigeonholeStaffCost(staffList.get(i).getStaffPay());
                //状态
                moneyPigeonhole.setMoneyPigeonholeState(0);
                //员工姓名
                moneyPigeonhole.setStaffName(staffList.get(i).getStaffName());
                //职位
                moneyPigeonhole.setMoneyPigeonholePost(staffList.get(i).getPostName());
                //基本工资
                moneyPigeonhole.setMoneyPigeonholeBasePay(staffList.get(i).getBaseWage());
                //工作日加班工资
                moneyPigeonhole.setWorkdayOvertimePay(staffList.get(i).getWorkMoney());
                //休息日加班工资
                moneyPigeonhole.setDayOffOvertimePay(staffList.get(i).getOffMoney());
                //节假日加班工资
                moneyPigeonhole.setHolidayOvertimePay(staffList.get(i).getHolidayMoney());
                //工资合计
                moneyPigeonhole.setTotalWage(staffList.get(i).getTotalWage());
                //出差工资
                moneyPigeonhole.setTravelwage(staffList.get(i).getTravelMoney());
                //迟到
                moneyPigeonhole.setMoneyPigeonholeLate(staffList.get(i).getLateMoney());
                //早退
                moneyPigeonhole.setMoneyPigeonholeLeaveArly(staffList.get(i).getElaryMoney());
                //旷工
                moneyPigeonhole.setAbsenteism(staffList.get(i).getLeaveMoney());
                //个人缴纳公积金
                moneyPigeonhole.setPersonageAccumulAtion(staffList.get(i).getInsuredArchive().getInsArchiveFundPersonPay());
                //个人缴纳社保
                moneyPigeonhole.setPersonageSocial(staffList.get(i).getInsuredArchive().getInsArchiveSocialPersonPay());
                //公司缴纳社保
                moneyPigeonhole.setCompanySocial(staffList.get(i).getInsuredArchive().getInsArchiveSocialFirmPay());
                //公司缴纳公积金
                moneyPigeonhole.setCompanyAccumulAtion(staffList.get(i).getInsuredArchive().getInsArchiveFundFirmPay());
                if (moneyPigeonholeMapper.insert(moneyPigeonhole) <= 0) {
                    return "核算工资失败";
                }
            }
        } else {
            return "本月已核算";

        }
        return "成功";
    }

    /**
     * 统计工资表
     *
     * @param staff
     * @return
     */
    @Override
    public Object countWage(Staff staff) {
        List<Staff> staffIPage = staffMapper.selectList(new QueryWrapper<Staff>());
        for (int i = 0; i < staffIPage.size(); i++) {
            //查询部门名称
            Dept dept = deptMapper.selectById(staffIPage.get(i).getDeptId());
            if (dept != null) {
                staffIPage.get(i).setDeptName(dept.getDeptName());
            }
            //查询职位名称
            DeptPost deptPost = deptPostMapper.selectById(staffIPage.get(i).getDeptPostId());
            if (deptPost != null) {
                staffIPage.get(i).setPostName(deptPost.getPostName());
            }
            //查询加班表
            List<Overtimeask> overtimeaskList = overtimeaskMapper.selectList(
                    new QueryWrapper<Overtimeask>()
                            .eq("STAFF_NAME", staffIPage.get(i).getStaffName())
                            .eq("OVERTIMEASK_STATE", 1));
            //加班方案
            WorkScheme workscheme_state = workSchemeMapper.selectOne(
                    new QueryWrapper<WorkScheme>()
                            .eq("WORKSCHEME_STATE", 0)
                            .eq("DEPT_NAME", dept.getDeptName()));
            if (workscheme_state != null) {
                System.out.println("3333333333333333333");
                System.out.println(staffIPage.get(i).getStaffName());
                for (int j = 0; j < overtimeaskList.size(); j++) {
                    if (overtimeaskList.get(j).getOvertimeaskType().equals("工作日加班")) {
                        staffIPage.get(i).setWorkMoney(staffIPage.get(i).getWorkMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeWorkratio());
                    } else if (overtimeaskList.get(j).getOvertimeaskType().equals("休息日加班")) {
                        staffIPage.get(i).setOffMoney(staffIPage.get(i).getOffMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeDayoffratio());
                    } else if (overtimeaskList.get(j).getOvertimeaskType().equals("节假日加班")) {
                        System.out.println("999999999999999999999999999999");
                        staffIPage.get(i).setHolidayMoney(staffIPage.get(i).getHolidayMoney() + overtimeaskList.get(j).getOvertimeaskActualTokinaga() * workscheme_state.getWorkschemeHolidayratio());
                    }
                }
            } else {
                System.out.println("2222222222222222222222222222222");
            }
            //查询出查表
            List<Travel> travelList = travelMapper.selectList(
                    new QueryWrapper<Travel>()
                            .eq("STAFF_NAME", staffIPage.get(i).getStaffName())
                            .eq("TRAVEL_CONDITION", 1));
            //查询出差方案
            Business business = businessMapper.selectOne(
                    new QueryWrapper<Business>()
                            .eq("BUSINESS_STATE", 0)
                            .eq("DEPT_NAME", dept.getDeptName()));
            if (business != null) {
                for (int y = 0; y < travelList.size(); y++) {
                    if (travelList.get(y).getTravelActualTokinaga() != null) {
                        staffIPage.get(i).setTravelMoney(staffIPage.get(i).getTravelMoney() + travelList.get(y).getTravelActualTokinaga() * business.getBusinessOnemoney());
                    } else if (travelList == null) {
                        staffIPage.get(i).setTravelMoney(0.0);
                    }
                }
            }
            //当前月
            int year = new Date().getYear() + 1900;
            int month = new Date().getMonth() + 1;
            //打卡记录
            List<ClockRecord> clockRecordList = clockRecordMapper.selectList(
                    new QueryWrapper<ClockRecord>().eq("STAFF_NAME", staffIPage.get(i).getStaffName()));
            //考勤月报表
            Archive archive = archiveMapper.selectOne(
                    new QueryWrapper<Archive>()
                            .eq("STAFF_NAME", staffIPage.get(i).getStaffName())
                            .eq("to_char(CREATED_TIME,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month)

            );
            //考勤扣款方案
            Attendandce attendandce = attendandceMapper.selectOne(
                    new QueryWrapper<Attendandce>().eq("ATTENDANDCE_STATE", 0)
                            .eq("DEPT_NAME", dept.getDeptName()));
            if (attendandce != null) {
                if (archive != null) {
                    for (int x = 0; x < clockRecordList.size(); x++) {
                        if (clockRecordList.get(x).getCheckState().equals("早退")) {
                            staffIPage.get(i).setElaryMoney(staffIPage.get(i).getElaryMoney() + archive.getLeaveEarlyFrequency() * attendandce.getAttendandceLeavemoney());
                        } else if (clockRecordList.get(x).getCheckState().equals("迟到")) {
                            staffIPage.get(i).setLateMoney(staffIPage.get(i).getLateMoney() + archive.getLateFrequency() * attendandce.getAttendandceLitemoney());
                        } else if (clockRecordList.get(x).getCheckState().equals("旷工")) {
                            staffIPage.get(i).setLeaveMoney(staffIPage.get(i).getLeaveMoney() + archive.getAbsenteeismFrequency() * attendandce.getAttendandceAbscntmoney());
                        }
                    }
                }
            }
            //查询社保归档表
            InsuredArchive insuredArchive = insuredArchiveMapper.selectOne(
                    new QueryWrapper<InsuredArchive>()
                            .eq("INS_ARCHIVE_STAFF_NAME", staffIPage.get(i).getStaffName())
                            .eq("to_char(INS_ARCHIVE_INSURED_MONTH,'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month)
            );
            System.out.println("社保归档数据");
            System.out.println(insuredArchive);
            if (insuredArchive == null) {
                staffIPage.get(i).setInsuredArchive(new InsuredArchive());
                //个人缴纳社保
                staffIPage.get(i).getInsuredArchive().setInsArchiveSocialPersonPay(0.0);
                //公司缴纳社保
                staffIPage.get(i).getInsuredArchive().setInsArchiveSocialFirmPay(0.0);
                //个人缴纳公积金
                staffIPage.get(i).getInsuredArchive().setInsArchiveFundPersonPay(0.0);
                //公司缴纳公积金
                staffIPage.get(i).getInsuredArchive().setInsArchiveFundFirmPay(0.0);
            } else {
                staffIPage.get(i).setInsuredArchive(insuredArchive);
            }
            //查询基本工资
            Fixedwagf fixedwagf = fixedwagfMapper.selectOne(new QueryWrapper<Fixedwagf>().eq("STAFF_NAME", staffIPage.get(i).getStaffName()));
            if (fixedwagf != null) {
                if (staffIPage.get(i).getStaffState().equals(1L)) {
                    staffIPage.get(i).setBaseWage(fixedwagf.getFixedwageOfflcialpostmoney() + fixedwagf.getFixedwageOfficialmoney());
                } else {
                    staffIPage.get(i).setBaseWage(fixedwagf.getFixedwagePeriodpostmoney() + fixedwagf.getFixedwagePeriodmoney());
                }
            }

            //工资合计
            staffIPage.get(i).setTotalWage(
                    staffIPage.get(i).getBaseWage() +
                            staffIPage.get(i).getWorkMoney()
                            + staffIPage.get(i).getOffMoney()
                            + staffIPage.get(i).getHolidayMoney()
                            + staffIPage.get(i).getTravelMoney()
                            + staffIPage.get(i).getInsuredArchive().getInsArchiveFundPersonPay()
                            + staffIPage.get(i).getInsuredArchive().getInsArchiveFundFirmPay());

            //实发工资
            staffIPage.get(i).setSalarySum(
                    staffIPage.get(i).getTotalWage() -
                            staffIPage.get(i).getElaryMoney() -
                            staffIPage.get(i).getLateMoney() -
                            staffIPage.get(i).getLateMoney() -
                            staffIPage.get(i).getInsuredArchive().getInsArchiveSocialPersonPay() -
                            staffIPage.get(i).getInsuredArchive().getInsArchiveFundPersonPay());
        }
        Staff staff1 = new Staff();
        //计薪人数
        staff1.setCountPerson(staffIPage.size());
        for (int i = 0; i < staffIPage.size(); i++) {
            if (staffIPage != null) {
                double f = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staff1.getCountyMoney() + staffIPage.get(i).getTotalWage()));
                //应发金额
                staff1.setCountyMoney(f);
                //实发工资
                double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staff1.getCountsMoney() + staffIPage.get(i).getSalarySum()));
                staff1.setCountsMoney(x);
                //公司缴纳
                double y = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staff1.getCountcPay() + staffIPage.get(i).getInsuredArchive().getInsArchiveFundPersonPay() + staffIPage.get(i).getInsuredArchive().getInsArchiveFundFirmPay()));
                staff1.setCountcPay(y);
            }

        }
        //员工成本
        double z = Double.parseDouble(new java.text.DecimalFormat("#.00").format(staff1.getCountsMoney() + staff1.getCountcPay()));
        staff1.setStaffPay(z);
        return staff1;
    }
}
