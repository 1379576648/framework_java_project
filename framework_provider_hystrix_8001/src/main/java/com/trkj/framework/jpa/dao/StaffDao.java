package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.StaffEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 13795
 */
@Repository
public interface StaffDao extends CrudRepository<StaffEntity,Integer> {
    /***
     *通过id查询用户信息
     * @param staffId
     * @return
     */
    @Query("select  a from StaffEntity a where a.staffId=?1")
    public StaffEntity selectId(Integer staffId);

    /***
     * 通过手机号码以及密码查询用户信息
     * @param phone
     * @return
     */
    @Query("select a from  StaffEntity  a where a.staffPhone=?1")
     public StaffEntity findStaffByPhoneAndPass(Long phone);
}
