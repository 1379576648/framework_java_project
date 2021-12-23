package com.trkj.framework.jpa.service.ImpI;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import com.trkj.framework.entity.jpa.RegisterLogEntity;
import com.trkj.framework.entity.jpa.StaffEntity;
import com.trkj.framework.jpa.dao.RegisterLogDao;
import com.trkj.framework.jpa.dao.StaffDao;
import com.trkj.framework.jpa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 13795
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private RegisterLogDao registerLogDao;

    /***
     * 通过id查询用户信息
     * @param map
     * @return
     */
    @Override
    @Transactional
    public StaffEntity staffId(Map<String, Object> map) {
        StaffEntity staffEntity = staffDao.selectId(Integer.parseInt(map.get("成功").toString()));
        RegisterLogEntity registerLog = new RegisterLogEntity();
        //登录类型
        registerLog.setRegisterLogGenre(1);
        //登录手机号码
        registerLog.setRegisterLogPhone(staffEntity.getStaffPhone());
        //登录用户名
        registerLog.setRegisterLogPeople(staffEntity.getStaffName());
        //登录成功
        registerLog.setRegisterLogState(0);
        //创建时间
        registerLog.setCreatedTime(new Date());
        //修改时间
        registerLog.setUpdatedTime(new Date());
        //浏览器名称
        registerLog.setRegisterLogBrowser(map.get("browserName").toString());
        //IP地址
        registerLog.setRegisterLogIp(map.get("ip").toString());
        //设备类型
        registerLog.setRegisterLogType(map.get("deviceType").toString());
        //ip所在地
        registerLog.setRegisterLogIpName(map.get("ipName").toString());
        //逻辑删除
        registerLog.setIsDeleted(0);
        //乐观锁
        registerLog.setRevision(1);
        registerLogDao.save(registerLog);
        return staffEntity;
    }

    /****
     * 通过手机号码以及密码进行登录
     * @param map
     * @return
     */
    @Override
    @Transactional
    public Object findStaffByPhoneAndPass(Map<String, Object> map) {
        //系统当前时间
        Date date = new Date();
        List<RegisterLogEntity> registerLogEntities = registerLogDao.selectRegisterNumber(Long.decode(map.get("phone").toString()));
        if (registerLogEntities.size() >= 3) {
            //返回需要等待的时间
            return 30 - (date.getTime() - registerLogEntities.get(0).getCreatedTime().getTime()) / (1000 * 60);
        } else {
            StaffEntity staffEntity = staffDao.findStaffByPhoneAndPass(Long.decode(map.get("phone").toString()), map.get("pass").toString());
            RegisterLogEntity registerLog = new RegisterLogEntity();
            //登录类型
            registerLog.setRegisterLogGenre(1);
            //登录手机号码
            registerLog.setRegisterLogPhone(Long.decode(map.get("phone").toString()));
            //状态
            if (staffEntity == null) {
                //登录失败
                registerLog.setRegisterLogState(1);
            } else {
                //登录用户名
                registerLog.setRegisterLogPeople(staffEntity.getStaffName());
                //登录成功
                registerLog.setRegisterLogState(0);
            }
            //创建时间
            registerLog.setCreatedTime(new Date());
            //修改时间
            registerLog.setUpdatedTime(new Date());
            //浏览器名称
            registerLog.setRegisterLogBrowser(map.get("browserName").toString());
            //IP地址
            registerLog.setRegisterLogIp(map.get("ip").toString());
            //设备类型
            registerLog.setRegisterLogType(map.get("deviceType").toString());
            //ip所在地
            registerLog.setRegisterLogIpName(map.get("ipName").toString());
            //逻辑删除
            registerLog.setIsDeleted(0);
            //乐观锁
            registerLog.setRevision(1);
            registerLogDao.save(registerLog);
            return staffEntity;
        }
    }
}
