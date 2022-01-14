package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.RoleStaffEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 13795
 */
@Repository
public interface RoleStaffDao extends CrudRepository<RoleStaffEntity,Integer> {

    /***
     * 通过员工编号查询角色列表
     * @param integer
     * @return
     */
    @Query("select e from RoleStaffEntity  e inner join RoleEntity  d  on e.roleId=d.roleId  where e.staffId=?1   and d.roleState=0 and d.isDeleted=0")
    public List<RoleStaffEntity> selectRoleStaff(Integer integer);
}
