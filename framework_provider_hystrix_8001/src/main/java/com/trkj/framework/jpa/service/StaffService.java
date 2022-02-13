package com.trkj.framework.jpa.service;

import com.trkj.framework.entity.jpa.DeptPostEntity;
import com.trkj.framework.entity.jpa.StaffEntity;

import java.util.Map;
import java.util.Optional;

/**
 * @author 13795
 */
public interface StaffService {
    /***
     * 通过ID查询用户信息
     * @param map
     * @return
     */
    public StaffEntity staffId(Map<String ,Object> map);

    /***
     * 通过手机号码以及密码查询用户信息
     * @param map
     * @return
     */
    public StaffEntity findStaffByPhoneAndPass(Map<String,Object> map);

    /***
     * 查询用户角色下菜单列表
     * @param id
     * @return
     */
    public Object  menuList(Integer id);

    /***
     * 通过员工编号查询职位名称
     * @param integer
     * @return
     */
    public String selectPostName(Integer integer);
}
