package com.trkj.framework.mybatisplus.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.DefInsuredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javafx.util.BuilderFactory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * <p>
 * 默认参保方案表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-19
 */
@Service
public class DefInsuredServiceImpl implements DefInsuredService {

    @Autowired
    private DefInsuredMapper defInsuredMapper;

    @Autowired
    private DefSchemeMapper defSchemeMapper;


    @Autowired
    private DeptMapper deptMapper;


    @Autowired
    private InsuredSchemeMapper insuredSchemeMapper;

    @Autowired
    private InsuredDetailMapper insuredDetailMapper;

    @Autowired
    private InsuredPaymentMapper insuredPaymentMapper;

    @Autowired
    private InsuredArchiveMapper insuredArchiveMapper;

    @Autowired
    private InsuredLogMapper insuredLogMapper;

    /***
     * 分页查询社保方案
     * @param defInsured
     * @return
     */
    @Override
    public IPage<DefInsured> selectDefInsured(DefInsured defInsured) {
        //条件构造器
        QueryWrapper<DefInsured> queryWrapper = new QueryWrapper<DefInsured>();
        //分页插件
        Page<DefInsured> page = new Page<DefInsured>(defInsured.getCurrenPage(), defInsured.getPageSize());
        //判断状态是否为空
        if ((defInsured.getDefInsuredState() != null && !defInsured.getDefInsuredState().equals(""))) {
            queryWrapper.eq("DEF_INSURED_STATE", defInsured.getDefInsuredState());
        }
        //通过菜单顺序排序
        queryWrapper.orderByDesc("CREATED_TIME");
        return defInsuredMapper.selectPage(page, queryWrapper);
    }

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @Override
    public String deleteDefInsured(Integer integer) {
        //查询方案是否被使用
        List<InsuredScheme> list = insuredSchemeMapper.selectList(new QueryWrapper<InsuredScheme>().eq("DEF_INSURED_ID", integer));
        if (list.size() > 0) {
            return "该方案正被使用无法删除";
        }
        //删除方案数据
        defSchemeMapper.delete(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID", integer));
        if (defInsuredMapper.deleteById(integer) <= 0) {
            return "删除失败";
        }
        return "成功";
    }

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @Override
    public String updateDefInsuredState(Integer integer) {
        //通过编号查询数据
        DefInsured defInsured = defInsuredMapper.selectById(integer);
        //判断查询的数据
        if (defInsured == null) {
            return "查询信息有误";
        }
        //判断是不是启用
        if (Integer.parseInt(defInsured.getDefInsuredState().toString()) == 0) {
            defInsured.setDefInsuredState(1L);

        } else {
            defInsured.setDefInsuredState(0L);
        }

        //修改数据
        if (defInsuredMapper.updateById(defInsured) <= 0) {
            return "修改失败";
        }

        return "成功";
    }

    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @Override
    public DefInsured selectDefInsuredId(Integer integer) {
        return defInsuredMapper.selectById(integer);
    }


    /***
     *  通过外键查询方案数据
     * @param integer
     * @return
     */
    @Override
    public Object listSelectDefScheme(Integer integer) {
        return defSchemeMapper.selectList(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID", integer));
    }

    /**
     * 添加社保方案
     *
     * @param objectMap
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addDefInsured(Map<String, Object> objectMap)  throws ArithmeticException{
        DefInsured defInsured = JSONObject.parseObject(JSONObject.toJSONString(objectMap.get("defInsured")), DefInsured.class);
        if (defInsuredMapper.insert(defInsured) <= 0) {
            throw new ArithmeticException("添加社保方案失败");
        }
        List<DefScheme> defSchemeList = JSONObject.parseArray(JSONObject.toJSONString(objectMap.get("defSchemeList")), DefScheme.class);
        for (int i = 0; i < defSchemeList.size(); i++) {
            defSchemeList.get(i).setDefInsuredId(Long.valueOf(defInsured.getDefInsuredId()));
            if (defSchemeMapper.insert(defSchemeList.get(i)) <= 0) {
                throw new ArithmeticException("添加社保方案失败");
            }
        }
        return "成功";
    }

    /***
     * 修改社保方案
     * @param objectMap
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateDefInsured(Map<String, Object> objectMap)  throws ArithmeticException{
        DefInsured defInsured = JSONObject.parseObject(JSONObject.toJSONString(objectMap.get("defInsured")), DefInsured.class);
        //删除社保方案项目
        defSchemeMapper.delete(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID", defInsured.getDefInsuredId()));

        List<DefScheme> defSchemeList = JSONObject.parseArray(JSONObject.toJSONString(objectMap.get("defSchemeList")), DefScheme.class);
        for (int i = 0; i < defSchemeList.size(); i++) {
            defSchemeList.get(i).setDefInsuredId(Long.valueOf(defInsured.getDefInsuredId()));
            if (defSchemeMapper.insert(defSchemeList.get(i)) <= 0) {
                throw new ArithmeticException("修改社保方案失败");
            }
        }
        if (defInsuredMapper.updateById(defInsured) <= 0) {
            throw new ArithmeticException("修改社保方案失败");
        }
        return "成功";
    }

    /***
     * 查询社保方案名称
     * @param name
     * @return
     */
    @Override
    public Object selectDefInsuredName(String name) {
        return defInsuredMapper.selectOne(new QueryWrapper<DefInsured>().eq("DEF_INSURED_NAME", name));
    }


    /***
     * 查询所有的社保方案
     * @return
     */
    @Override
    public Object selectDefInsuredListName() {
        return defInsuredMapper.selectList(new QueryWrapper<DefInsured>().eq("DEF_INSURED_STATE", 0));
    }

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @Override
    public Object pageStaff(Staff staff) {
        //分页插件
        Page<Staff> staffPage = new Page<Staff>(staff.getCurrenPage(), staff.getPageSize());
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<Staff>();
        //当前月
        int year =new Date().getYear()+1900;
        int month =new Date().getMonth()+1;
        queryWrapper.ne("to_char(e_INSURED_PAYMENT_SALARY_MONTH,'YYYY-MM')",month>9?year+"-"+month:year+"-"+"0"+month);
        queryWrapper.or().isNull("e_INSURED_PAYMENT_SALARY_MONTH");
        //判断名称是否为空
        if (staff.getStaffName() != null && !staff.getStaffName().equals("")) {
            //根据姓名模糊查询
            queryWrapper.like("a_STAFF_NAME", staff.getStaffName());
        }
        //判断部门名称是否为空
        if (staff.getDeptName() != null && !staff.getDeptName().equals("")) {
            //根据部门名称
            queryWrapper.eq("b_DEPT_NAME", staff.getDeptName());
        }
        return defInsuredMapper.pageStaff(staffPage, queryWrapper);
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
     *  参保提交
     * @param map
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insuredSubmit(@RequestBody Map<String, Object> map) throws ArithmeticException {
        List<Staff> staffList = JSONObject.parseArray(JSONObject.toJSONString(map.get("selectStaffList")), Staff.class);
        InsuredPayment insuredPayment = JSONObject.parseObject(JSONObject.toJSONString(map.get("payment")), InsuredPayment.class);
        Long schemeId = Long.valueOf(map.get("scheme_id").toString());
        InsuredLog insuredLog = new InsuredLog();
        for (int i = 0; i < staffList.size(); i++) {
            insuredLog.setInsLogIdTheInsured(staffList.get(i).getStaffName());
            //添加参保方案表
            InsuredScheme insuredScheme = new InsuredScheme();
            insuredScheme.setStaffId(Long.valueOf(staffList.get(i).getStaffId()));
            insuredScheme.setDefInsuredId(schemeId);
            if (insuredSchemeMapper.insert(insuredScheme) <= 0) {
                throw new ArithmeticException("提交失败");
            }
            DefInsured defInsured = defInsuredMapper.selectById(schemeId);
            if (defInsured == null) {
                throw new ArithmeticException("提交失败");
            }
            //查询所有的参保方案项目
            List<DefScheme> defSchemeList = defSchemeMapper.selectList(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID", schemeId));
            //添加参保明细表
            InsuredDetail insuredDetail = new InsuredDetail();
            insuredDetail.setInsDetailSocialFirmPay((double) 0);
            insuredDetail.setInsDetailSocialPersonPay((double) 0);
            insuredDetail.setInsDetailFundFirmPay((double) 0);
            insuredDetail.setInsDetailFundPersonPay((double) 0);
            insuredDetail.setInsDetailStaffName(staffList.get(i).getStaffName());
            insuredDetail.setInsDetailInsuredName(defInsured.getDefInsuredName());
            insuredDetail.setInsDetailInsuredMonth(insuredPayment.getInMonth());
            insuredDetail.setInsDetailSalaryMonth(insuredPayment.getTime());
            for (int j = 0; j < defSchemeList.size(); j++) {
                if (defSchemeList.get(j).getDefSchemeType().equals("养老保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogSocialNumber(insuredPayment.getSocialNumber());
                    //社保公司缴费
                    insuredDetail.setInsDetailSocialFirmPay(
                            insuredDetail.getInsDetailSocialFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //社保个人缴费
                    insuredDetail.setInsDetailSocialPersonPay(
                            insuredDetail.getInsDetailSocialPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                } else if (defSchemeList.get(j).getDefSchemeType().equals("失业保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogSocialNumber(insuredPayment.getSocialNumber());
                    //社保公司缴费
                    insuredDetail.setInsDetailSocialFirmPay(
                            insuredDetail.getInsDetailSocialFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //社保个人缴费
                    insuredDetail.setInsDetailSocialPersonPay(
                            insuredDetail.getInsDetailSocialPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                } else if (defSchemeList.get(j).getDefSchemeType().equals("工伤保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogSocialNumber(insuredPayment.getSocialNumber());
                    //社保公司缴费
                    insuredDetail.setInsDetailSocialFirmPay(
                            insuredDetail.getInsDetailSocialFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //社保个人缴费
                    insuredDetail.setInsDetailSocialPersonPay(
                            insuredDetail.getInsDetailSocialPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                } else if (defSchemeList.get(j).getDefSchemeType().equals("生育保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogSocialNumber(insuredPayment.getSocialNumber());
                    //社保公司缴费
                    insuredDetail.setInsDetailSocialFirmPay(
                            insuredDetail.getInsDetailSocialFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //社保个人缴费
                    insuredDetail.setInsDetailSocialPersonPay(
                            insuredDetail.getInsDetailSocialPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                } else if (defSchemeList.get(j).getDefSchemeType().equals("医疗保险")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getSocialNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getSocialNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getSocialNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogSocialNumber(insuredPayment.getSocialNumber());
                    //社保公司缴费
                    insuredDetail.setInsDetailSocialFirmPay(
                            insuredDetail.getInsDetailSocialFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //社保个人缴费
                    insuredDetail.setInsDetailSocialPersonPay(
                            insuredDetail.getInsDetailSocialPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                } else if (defSchemeList.get(j).getDefSchemeType().equals("公积金")) {
                    Double integer = 0.0;
                    Double aLong = 0.0;
                    //判断基数多少
                    if (insuredPayment.getFundNumber() < defSchemeList.get(j).getDefSchemeMin()) {
                        integer = defSchemeList.get(j).getDefSchemeMin();
                    } else if (insuredPayment.getFundNumber() > defSchemeList.get(j).getDefSchemeMax()) {
                        integer = defSchemeList.get(j).getDefSchemeMax();
                    } else {
                        integer = insuredPayment.getFundNumber();
                    }
                    //判断基数上下限
                    if (integer < defSchemeList.get(j).getDefSchemeFloor()) {
                        aLong = defSchemeList.get(j).getDefSchemeFloor();
                    } else if (integer > defSchemeList.get(j).getDefSchemeUpper()) {
                        aLong = defSchemeList.get(j).getDefSchemeUpper();
                    } else {
                        aLong = integer;
                    }
                    insuredLog.setInsLogFundNumber(insuredPayment.getFundNumber());
                    //积金公司缴费
                    insuredDetail.setInsDetailFundFirmPay(
                            insuredDetail.getInsDetailFundFirmPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemeFirmProp() / 100) +
                                    defSchemeList.get(j).getDefSchemeFirmSum()
                    );
                    //积金个人缴费
                    insuredDetail.setInsDetailFundPersonPay(
                            insuredDetail.getInsDetailFundPersonPay() +
                                    aLong * (defSchemeList.get(j).getDefSchemePersonProp() / 100) +
                                    defSchemeList.get(j).getDefSchemePersonSum()
                    );
                }
            }
            //四舍五入
            //社保
            insuredDetail.setInsDetailSocialFirmPay((double) Math.round(insuredDetail.getInsDetailSocialFirmPay() * 100) / 100);
            insuredDetail.setInsDetailSocialPersonPay((double) Math.round(insuredDetail.getInsDetailSocialPersonPay() * 100) / 100);
            //积金
            insuredDetail.setInsDetailFundFirmPay((double) Math.round(insuredDetail.getInsDetailFundFirmPay() * 100) / 100);
            insuredDetail.setInsDetailFundPersonPay((double) Math.round(insuredDetail.getInsDetailFundPersonPay() * 100) / 100);
            if (insuredDetailMapper.insert(insuredDetail) <= 0) {
                throw new ArithmeticException("提交失败");
            }
            insuredLog.setInsLogSocialInsuredMonth(insuredPayment.getInMonth());
            insuredLog.setInsLogSocialSalaryMonth(insuredPayment.getTime());
            insuredLog.setInsLogFundInsuredMonth(insuredPayment.getInMonth());
            insuredLog.setInsLogFundSalaryMonth(insuredPayment.getInMonth());
            //添加参保缴纳表
            InsuredPayment insuredPayment1 = new InsuredPayment();
            insuredPayment1.setStaffId(Long.valueOf(staffList.get(i).getStaffId()));
            insuredPayment1.setInsuredSchemeId(Long.valueOf(insuredScheme.getInsuredSchemeId()));
            insuredPayment1.setInsDetailId(Long.valueOf(insuredDetail.getInsDetailId()));
            insuredPayment1.setInsuredPaymentSocialNumber(insuredPayment.getSocialNumber());
            insuredPayment1.setInsuredPaymentFundNumber(insuredPayment.getFundNumber());
            insuredPayment1.setInsuredPaymentInsuredMonth(insuredPayment.getInMonth());
            insuredPayment1.setInsuredPaymentSalaryMonth(insuredPayment.getTime());
            if (insuredPaymentMapper.insert(insuredPayment1) <= 0) {
                throw new ArithmeticException("提交失败");
            }
            //参保日志
            insuredLog.setInsLogUpdateObject(map.get("staffName").toString());
            insuredLog.setInsLogInsuredName(defInsured.getDefInsuredName());
            insuredLog.setInsLogExplain("提交社保公积金");
            insuredLog.setInsLogColor("rgb(49, 222, 0)");
            if (insuredLogMapper.insert(insuredLog) <= 0) {
                throw new ArithmeticException("提交失败");
            }
            //修改参保方案的人数
            defInsured.setDefInsuredNumber(defInsured.getDefInsuredNumber() + 1);
            if (defInsuredMapper.updateById(defInsured) <= 0) {
                throw new ArithmeticException("提交失败");
            }
        }

        return "成功";
    }
}
