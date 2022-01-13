package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.RoleMenuPowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 13795
 */
@Repository
public interface RoleMenuPowerDao extends CrudRepository<RoleMenuPowerEntity,Integer> {
    /**
     * 通过角色编号获取所拥有的菜单
     * @param integer
     * @return
     */
    @Query("select  e from RoleMenuPowerEntity  e where  e.roleId=?1 ")
    public List<RoleMenuPowerEntity> selectRoleMenuPower(Integer integer);
}
