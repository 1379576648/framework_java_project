package com.trkj.framework.jpa.service.ImpI;

import com.trkj.framework.entity.jpa.StaffEntity;
import com.trkj.framework.jpa.dao.StaffDao;
import com.trkj.framework.jpa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 13795
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    /****
     * 通过id查询密码
     * @param id
     * @return
     */
    @Override
    public StaffEntity staffId(Integer id) {
        return staffDao.selectId(id);
    }

    /***
     * 通过手机号码以及密码进行登录
     * @param phone
     * @param pass
     * @return
     */
    @Override
    public StaffEntity findStaffByPhoneAndPass(Integer phone, String pass) {
        return findStaffByPhoneAndPass(phone,pass);
    }
}
