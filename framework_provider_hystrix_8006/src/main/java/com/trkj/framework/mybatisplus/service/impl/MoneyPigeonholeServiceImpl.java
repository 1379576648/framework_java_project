package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.MoneyPigeonhole;
import com.trkj.framework.mybatisplus.mapper.MoneyPigeonholeMapper;
import com.trkj.framework.mybatisplus.service.MoneyPigeonholeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class MoneyPigeonholeServiceImpl implements MoneyPigeonholeService {
    @Autowired
    private MoneyPigeonholeMapper moneyPigeonholeMapper;

    /**
     * 查询未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @Override
    public IPage<MoneyPigeonhole> selectMoney(MoneyPigeonhole moneyPigeonhole) {
        Page<MoneyPigeonhole> page = new Page<>(moneyPigeonhole.getCurrentPage(),moneyPigeonhole.getPageSize());
        QueryWrapper<MoneyPigeonhole> queryWrapper = new QueryWrapper<>();
//        //根据员工姓名模糊查询
//        if(moneyPigeonhole.getStaffName()!=null){
//            queryWrapper.like("STAFF_NAME",moneyPigeonhole.getStaffName());
//        }
        queryWrapper.eq("MONEYPIGEONHOLE_STATE",0);
        return moneyPigeonholeMapper.selectMoney(page,queryWrapper);
    }

    /**
     * 统计未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @Override
    public Object countMoney(MoneyPigeonhole moneyPigeonhole) {
        List<MoneyPigeonhole> moneyPigeonholeList = moneyPigeonholeMapper.selectList(new QueryWrapper<MoneyPigeonhole>()
                .eq("MONEYPIGEONHOLE_STATE",0));
        //计薪人数
        moneyPigeonhole.setCountPerson(moneyPigeonholeList.size());
        for (int i = 0;i<moneyPigeonholeList.size();i++){
            if(moneyPigeonholeList!=null){
                moneyPigeonhole.setMoneyPigeonholeState(moneyPigeonholeList.get(i).getMoneyPigeonholeState());
                double f = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonhole.getCountyMoney()+moneyPigeonholeList.get(i).getMoneyPigeonholeSalary()));
                //应发金额
                moneyPigeonhole.setCountyMoney(f);
                //实发工资
                double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonhole.getCountsMoney()+moneyPigeonholeList.get(i).getMoneyPigeonholePayrollSalary()));
                moneyPigeonhole.setCountsMoney(x);
                //公司缴纳
                double y = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonhole.getCountcPay()+moneyPigeonholeList.get(i).getCompanySocial()+moneyPigeonholeList.get(i).getCompanyAccumulAtion()));
                moneyPigeonhole.setCountcPay(y);
            }
        }
        //员工成本
        double z = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonhole.getCountsMoney()+moneyPigeonhole.getCountcPay()));
        moneyPigeonhole.setStaffPay(z);
        if (moneyPigeonholeList.size()>=1){
            return moneyPigeonhole;
        }else{
            return null;
        }
    }

    /**
     * 查询已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @Override
    public IPage<MoneyPigeonhole> selectMoneys(MoneyPigeonhole moneyPigeonhole) {
        Page<MoneyPigeonhole> page = new Page<>(moneyPigeonhole.getCurrentPage(),moneyPigeonhole.getPageSize());
        QueryWrapper<MoneyPigeonhole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MONEYPIGEONHOLE_STATE",1);
        //当前月
        int year = moneyPigeonhole.getPayMonth().getYear() + 1900;
        int month = moneyPigeonhole.getPayMonth().getMonth() + 1;
        queryWrapper.eq("to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM')",month > 9 ? year + "-" + month : year + "-" + "0" + month);
        return moneyPigeonholeMapper.selectMoneys(page,queryWrapper);
    }

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
    @Override
    public List<MoneyPigeonhole> selectstatc(MoneyPigeonhole moneyPigeonhole) {
        QueryWrapper<MoneyPigeonhole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MONEYPIGEONHOLE_STATE",1);
        //当前月
        int year = moneyPigeonhole.getPayMonth().getYear() + 1900;
        int month = moneyPigeonhole.getPayMonth().getMonth() + 1;
        queryWrapper.eq("to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM')",month > 9 ? year + "-" + month : year + "-" + "0" + month);
        return moneyPigeonholeMapper.selectstatc(queryWrapper);
    }

    /**
     * 统计已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @Override
    public Object countMoneys(MoneyPigeonhole moneyPigeonhole) {
        Page<MoneyPigeonhole> page = new Page<>(moneyPigeonhole.getCurrentPage(),moneyPigeonhole.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        //判断传入的时间是否为空
        if (moneyPigeonhole.getStartTime() != null || moneyPigeonhole.getEndTime() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(moneyPigeonhole.getStartTime());
            cal.add(Calendar.MONTH, 1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(moneyPigeonhole.getEndTime());
            cal2.add(Calendar.MONTH, 1);
            //计薪时间范围查询
            queryWrapper.between("CREATED_TIME", cal.getTime(),cal2.getTime());
        }
        queryWrapper.eq("MONEYPIGEONHOLE_STATE",1);
        IPage<MoneyPigeonhole> moneyPigeonholeIPage = moneyPigeonholeMapper.selectPage(page,queryWrapper);

        for (int i = 0; i <moneyPigeonholeIPage.getRecords().size(); i++) {
            //当前月
            int year = moneyPigeonholeIPage.getRecords().get(i).getPayMonth().getYear() + 1900;
            int month = moneyPigeonholeIPage.getRecords().get(i).getPayMonth().getMonth() + 1;
            List<MoneyPigeonhole> moneyPigeonholeList = moneyPigeonholeMapper.selectList(
                    new QueryWrapper<MoneyPigeonhole>()
                            .eq("to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM')",month > 9 ? year + "-" + month : year + "-" + "0" + month)
                            .eq("MONEYPIGEONHOLE_STATE",1));
            for (int j = 0; j <moneyPigeonholeList.size() ; j++) {
                moneyPigeonholeIPage.getRecords().get(i).setMoneyPigeonholeState(moneyPigeonholeList.get(j).getMoneyPigeonholeState());
                double f = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.getRecords().get(i).getCountyMoney()+moneyPigeonholeList.get(j).getMoneyPigeonholeSalary()));
                //应发金额
                moneyPigeonholeIPage.getRecords().get(i).setCountyMoney(f);
                //实发工资
                double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.getRecords().get(i).getCountsMoney()+moneyPigeonholeList.get(j).getMoneyPigeonholePayrollSalary()));
                moneyPigeonholeIPage.getRecords().get(i).setCountsMoney(x);
                //公司缴纳
                double y = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.getRecords().get(i).getCountcPay()+moneyPigeonholeList.get(j).getCompanySocial()+moneyPigeonholeList.get(j).getCompanyAccumulAtion()));
                moneyPigeonholeIPage.getRecords().get(i).setCountcPay(y);
            }
            //员工成本
            double z = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.getRecords().get(i).getCountsMoney()+moneyPigeonholeIPage.getRecords().get(i).getCountcPay()));
            moneyPigeonholeIPage.getRecords().get(i).setStaffPay(z);
        }
        return page;
    }

    /**
     * 修改状态为已归档
     * @param moneyPigeonhole
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMoney(MoneyPigeonhole moneyPigeonhole) {
        if (moneyPigeonholeMapper.update(moneyPigeonhole,new QueryWrapper<MoneyPigeonhole>().eq("MONEYPIGEONHOLE_STATE",0))<=0){
            return 100;
        }
        return 666;
    }

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object selectstatcis(MoneyPigeonhole moneyPigeonhole) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("MONEYPIGEONHOLE_STATE", 1);
        List<MoneyPigeonhole> moneyPigeonholeIPage = moneyPigeonholeMapper.selectstatcis(queryWrapper);

        for (int i = 0; i < moneyPigeonholeIPage.size(); i++) {
            //当前月
            int year = moneyPigeonholeIPage.get(i).getPayMonth().getYear() + 1900;
            int month = moneyPigeonholeIPage.get(i).getPayMonth().getMonth() + 1;
            List<MoneyPigeonhole> moneyPigeonholeList = moneyPigeonholeMapper.selectList(
                    new QueryWrapper<MoneyPigeonhole>()
                            .eq("to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM')", month > 9 ? year + "-" + month : year + "-" + "0" + month)
                            .eq("MONEYPIGEONHOLE_STATE", 1));
            for (int j = 0; j < moneyPigeonholeList.size(); j++) {
                moneyPigeonholeIPage.get(i).setMoneyPigeonholeState(moneyPigeonholeList.get(j).getMoneyPigeonholeState());
                double f = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.get(i).getCountyMoney() + moneyPigeonholeList.get(j).getMoneyPigeonholeSalary()));
                //应发金额
                moneyPigeonholeIPage.get(i).setCountyMoney(f);
                //实发工资
                double x = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.get(i).getCountsMoney() + moneyPigeonholeList.get(j).getMoneyPigeonholePayrollSalary()));
                moneyPigeonholeIPage.get(i).setCountsMoney(x);
                //公司缴纳
                double y = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.get(i).getCountcPay() + moneyPigeonholeList.get(j).getCompanySocial() + moneyPigeonholeList.get(j).getCompanyAccumulAtion()));
                moneyPigeonholeIPage.get(i).setCountcPay(y);
            }
            //员工成本
            double z = Double.parseDouble(new java.text.DecimalFormat("#.00").format(moneyPigeonholeIPage.get(i).getCountsMoney() + moneyPigeonholeIPage.get(i).getCountcPay()));
            moneyPigeonholeIPage.get(i).setStaffPay(z);
        }
        return moneyPigeonholeIPage;
    }
}
