package com.trkj.framework.jpa.service.ImpI;

import com.trkj.framework.jpa.dao.StaffDao;
import com.trkj.framework.jpa.entity.StaffEntity;
import com.trkj.framework.jpa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public StaffEntity selectStaff(Integer id) {
        return staffDao.findStaffEntityByDeptId(id);
    }
}
