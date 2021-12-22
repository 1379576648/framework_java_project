package com.trkj.framework.jpa.dao;

import com.trkj.framework.entity.jpa.StaffEntity;
import com.trkj.framework.jpa.entity.StaffEntity;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

public interface StaffDao extends CrudRepository<StaffEntity,Long> {
        public StaffEntity findStaffEntityByDeptId(Integer id);
}
