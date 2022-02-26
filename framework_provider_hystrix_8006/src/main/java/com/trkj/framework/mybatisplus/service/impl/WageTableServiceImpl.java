package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.WageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    /**
     * 查询工资表
     * @param staff
     * @return
     */
    @Override
    public IPage<Staff> selectWage(Staff staff) {
        Page<Staff> page = new Page<>(staff.getCurrentPage(),staff.getPageSize());
        IPage<Staff> staffIPage = staffMapper.selectPage(page, null);
        for (int i = 0; i <staffIPage.getRecords().size(); i++) {
            //过滤掉离职且非本月离职的员工
            Quit quit = quitMapper.selectOne(new QueryWrapper<Quit>().eq("STAFF_NAME",staffIPage.getRecords().get(i).getStaffName()));
            if (quit != null) {
                if (quit.getQuitState().equals(1L)){
                    if (quit.getFormalQuitDate().getMonth()+1<new Date().getMonth()+1){
                        page.getRecords().remove(i);
                    }
                }
            }
        }

        for (int i = 0; i <staffIPage.getRecords().size() ; i++) {
            //查询部门名称
            Dept dept = deptMapper.selectById(staffIPage.getRecords().get(i).getDeptId());
            if (dept!=null){
                staffIPage.getRecords().get(i).setDeptName(dept.getDeptName());
            }
            //查询职位名称
            DeptPost deptPost = deptPostMapper.selectById(staffIPage.getRecords().get(i).getDeptPostId());
            if (deptPost!=null){
                staffIPage.getRecords().get(i).setPostName(deptPost.getPostName());
            }
            //查询加班表
            List<Overtimeask> overtimeaskList = overtimeaskMapper.selectList(
                    new QueryWrapper<Overtimeask>()
                            .eq("STAFF_NAME", staffIPage.getRecords().get(i).getStaffName())
                            .eq("OVERTIMEASK_STATE",1));
            //加班方案
            WorkScheme workscheme_state = workSchemeMapper.selectOne(
                    new QueryWrapper<WorkScheme>()
                            .eq("WORKSCHEME_STATE", 0)
                            .eq("DEPT_NAME",dept.getDeptName()));
            if (workscheme_state!=null){
                System.out.println("3333333333333333333");
                System.out.println(staffIPage.getRecords().get(i).getStaffName());
                for (int j = 0; j < overtimeaskList.size(); j++) {
                    if (overtimeaskList.get(j).getOvertimeaskType().equals("工作日加班")){
                        staffIPage.getRecords().get(i).setWorkMoney( staffIPage.getRecords().get(i).getWorkMoney()+overtimeaskList.get(j).getOvertimeaskActualTokinaga()*workscheme_state.getWorkschemeWorkratio());
                    }else if(overtimeaskList.get(j).getOvertimeaskType().equals("休息日加班")){
                        staffIPage.getRecords().get(i).setOffMoney( staffIPage.getRecords().get(i).getOffMoney()+overtimeaskList.get(j).getOvertimeaskActualTokinaga()*workscheme_state.getWorkschemeDayoffratio());
                    }else if (overtimeaskList.get(j).getOvertimeaskType().equals("节假日加班")){
                        System.out.println("999999999999999999999999999999");
                        staffIPage.getRecords().get(i).setHolidayMoney( staffIPage.getRecords().get(i).getHolidayMoney()+overtimeaskList.get(j).getOvertimeaskActualTokinaga()*workscheme_state.getWorkschemeHolidayratio());
                    }
                }
            }else{
                System.out.println("2222222222222222222222222222222");
            }
            //当前月
            int year =new Date().getYear()+1900;
            int month =new Date().getMonth()+1;
            //打卡记录
            List<ClockRecord> clockRecordList = clockRecordMapper.selectList(
                      new QueryWrapper<ClockRecord>().eq("STAFF_NAME",staffIPage.getRecords().get(i).getStaffName()));
            //考勤月报表
            Archive archive = archiveMapper.selectOne(
                    new QueryWrapper<Archive>()
                            .eq("STAFF_NAME",staffIPage.getRecords().get(i).getStaffName())
                                    .eq("to_char(CREATED_TIME,'YYYY-MM')",month>9?year+"-"+month:year+"-"+"0"+month)

            );
            //考勤扣款方案
            Attendandce attendandce = attendandceMapper.selectOne(
                    new QueryWrapper<Attendandce>().eq("ATTENDANDCE_STATE",0)
                            .eq("DEPT_NAME",dept.getDeptName()));
            if(attendandce!=null){
                if (archive!=null){
                    for(int x = 0;x<clockRecordList.size();x++){
                        if(clockRecordList.get(x).getCheckState().equals("早退")){
                            staffIPage.getRecords().get(i).setElaryMoney(staffIPage.getRecords().get(i).getElaryMoney()+archive.getLeaveEarlyFrequency()*attendandce.getAttendandceLeavemoney());
                        }else if(clockRecordList.get(x).getCheckState().equals("迟到")){
                            staffIPage.getRecords().get(i).setLateMoney(staffIPage.getRecords().get(i).getLateMoney()+archive.getLateFrequency()*attendandce.getAttendandceLitemoney());
                        }else if(clockRecordList.get(x).getCheckState().equals("旷工")){
                            staffIPage.getRecords().get(i).setLeaveMoney(staffIPage.getRecords().get(i).getLeaveMoney()+archive.getAbsenteeismFrequency()*attendandce.getAttendandceAbscntmoney());
                        }
                    }
                }
            }
            //查询社保归档表
           InsuredArchive insuredArchive = insuredArchiveMapper.selectOne(
                   new QueryWrapper<InsuredArchive>()
                           .eq("INS_ARCHIVE_STAFF_NAME",staffIPage.getRecords().get(i).getStaffName())
                           .eq("to_char(INS_ARCHIVE_INSURED_MONTH,'YYYY-MM')",month>9?year+"-"+month:year+"-"+"0"+month)
           );
            System.out.println("社保归档数据");
            System.out.println(insuredArchive);
            if (insuredArchive==null){
                staffIPage.getRecords().get(i).setInsuredArchive(new InsuredArchive());
                //个人缴纳社保
                staffIPage.getRecords().get(i).getInsuredArchive().setInsArchiveSocialPersonPay(0.0);
                //公司缴纳社保
                staffIPage.getRecords().get(i).getInsuredArchive().setInsArchiveSocialFirmPay(0.0);
                //个人缴纳公积金
                staffIPage.getRecords().get(i).getInsuredArchive().setInsArchiveFundPersonPay(0.0);
                //公司缴纳公积金
                staffIPage.getRecords().get(i).getInsuredArchive().setInsArchiveFundFirmPay(0.0);
            }else{
                staffIPage.getRecords().get(i).setInsuredArchive(insuredArchive);
            }
            //查询基本工资
            Fixedwagf fixedwagf = fixedwagfMapper.selectOne(new QueryWrapper<Fixedwagf>().eq("STAFF_NAME", staffIPage.getRecords().get(i).getStaffName()));
            if (fixedwagf!=null){
                if (staffIPage.getRecords().get(i).getStaffState().equals(1L)){
                    staffIPage.getRecords().get(i).setBaseWage(fixedwagf.getFixedwageOfflcialpostmoney()+ fixedwagf.getFixedwageOfficialmoney());
                }else{
                    staffIPage.getRecords().get(i).setBaseWage(fixedwagf.getFixedwagePeriodpostmoney()+ fixedwagf.getFixedwagePeriodmoney());
                }
            }
            //工资合计
            staffIPage.getRecords().get(i).setTotalWage(
                    staffIPage.getRecords().get(i).getBaseWage()+
                            staffIPage.getRecords().get(i).getWorkMoney()
                            +staffIPage.getRecords().get(i).getOffMoney()
                            +staffIPage.getRecords().get(i).getHolidayMoney());
            //实发工资
            staffIPage.getRecords().get(i).setSalarySum(
                    staffIPage.getRecords().get(i).getTotalWage()-
                            staffIPage.getRecords().get(i).getElaryMoney()-
                            staffIPage.getRecords().get(i).getLateMoney()-
                            staffIPage.getRecords().get(i).getLateMoney()-
                            staffIPage.getRecords().get(i).getInsuredArchive().getInsArchiveSocialPersonPay()-
                            staffIPage.getRecords().get(i).getInsuredArchive().getInsArchiveSocialFirmPay()-
                            staffIPage.getRecords().get(i).getInsuredArchive().getInsArchiveFundPersonPay()-
                            staffIPage.getRecords().get(i).getInsuredArchive().getInsArchiveFundFirmPay());
            if (archive==null){
                archive = new Archive();
                //早退次数
                archive.setLeaveEarlyFrequency(0);
                //迟到次数
                archive.setLateFrequency(0);
                //旷工次数
                archive.setAbsenteeismFrequency(0);

            }

            //早退次数
            staffIPage.getRecords().get(i).setElaryMoneycs(archive.getLeaveEarlyFrequency());
            //迟到次数
            staffIPage.getRecords().get(i).setLateMoneycs(archive.getLateFrequency());
            //旷工次数
            staffIPage.getRecords().get(i).setLeaveMoneycs(archive.getAbsenteeismFrequency());
        }
        System.out.println(page.getRecords());

        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        return staffIPage;
    }
}
