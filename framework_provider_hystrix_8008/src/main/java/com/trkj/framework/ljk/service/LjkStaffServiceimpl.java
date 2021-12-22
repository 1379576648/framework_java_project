package com.trkj.framework.ljk.service;

import com.trkj.framework.entity.StaffEntity;
import com.trkj.framework.ljk.manpper.ljkStaffmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LjkStaffServiceimpl implements ljkStaffService {
    @Autowired
    private ljkStaffmapper mapper;

    @Override
    public List<StaffEntity> findCreatedById(Long id) {
       return mapper.findCreatedById(id);
    }

    @Override
    public List<StaffEntity> findCreatedLikeByName(String name){
        return mapper.findCreatedLikeByName(name);
    }

    @Override
    public List<StaffEntity> findCreated() {
        return mapper.findCreated();
    }
}
