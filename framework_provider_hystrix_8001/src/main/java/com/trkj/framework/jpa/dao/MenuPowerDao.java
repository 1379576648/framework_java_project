package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.MenuPowerEntity;
import com.trkj.framework.entity.jpa.StaffEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 13795
 */
@Repository
public interface MenuPowerDao extends CrudRepository<MenuPowerEntity,Integer> {
    /***
     *通过id查询菜单列表
     * @param id
     * @return
     */
    @Query("select  e from MenuPowerEntity  e where e.menuPowerId=?1 and e.isDeleted=0 and e.menuPowerState=0")
    public MenuPowerEntity selectMenuPower(Integer id);
}
