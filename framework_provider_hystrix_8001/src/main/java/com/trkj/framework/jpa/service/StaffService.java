package com.trkj.framework.jpa.service;

import com.trkj.framework.jpa.entity.StaffEntity;

/**
 * @author 13795
 */
public interface StaffService {

    /****
     * 通过ID查询用户信息
     * @param id
     * @return
     */
    public StaffEntity selectStaff(Integer id);
}
