package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.DeptPostEntity;
import com.trkj.framework.entity.jpa.MenuPowerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 13795
 */
@Repository
public interface DeptPostDao extends CrudRepository<DeptPostEntity,Integer> {

    /***
     * 通过编号查询职位名称
     * @param integer
     * @return
     */
    DeptPostEntity findDeptPostEntityByDeptPostId(Integer integer);
}
