package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.RegisterLogEntity;
import com.trkj.framework.entity.jpa.StaffEntity;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 13795
 */
@Repository
public interface RegisterLogDao  extends CrudRepository<RegisterLogEntity,Integer> {
        /***
         * 通过手机号查询30分钟内登录错误次数
         * @param phone
         * @return
         */
        @Query("select a from RegisterLogEntity  a  where a.createdTime>sysdate-30/(24*60) and a.registerLogState =1 and a.registerLogPhone=?1 ORDER BY a.createdTime")
        List<RegisterLogEntity> selectRegisterNumber(Long phone);

}
