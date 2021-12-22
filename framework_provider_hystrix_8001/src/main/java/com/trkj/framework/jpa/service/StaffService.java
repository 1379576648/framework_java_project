package com.trkj.framework.jpa.service;

import com.trkj.framework.entity.jpa.StaffEntity;

/**
 * @author 13795
 */
public interface StaffService {
    /****
     * 通过ID查询用户信息
     * @param id
     * @return
     */
    public StaffEntity staffId(Integer id);

    /***
     * 通过手机号码以及密码查询用户信息
     * @param phone
     * @param pass
     * @return
     */
    public StaffEntity findStaffByPhoneAndPass(Integer phone, String pass);

}
