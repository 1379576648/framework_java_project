package com.trkj.framework.ljk.service;

import com.trkj.framework.entity.StaffEntity;

import java.util.List;

/**
 * @author 29447
 */
public interface ljkStaffService {
    public List<StaffEntity> findCreatedById(Long id);
    public List<StaffEntity> findCreatedLikeByName(String name);
    public List<StaffEntity> findCreated();
}
