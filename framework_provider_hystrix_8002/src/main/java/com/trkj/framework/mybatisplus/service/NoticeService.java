package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
public interface NoticeService {

    /***
     * 通过员工编号查询公告信息
     * @param integer
     * @return
     */
    Object selectNoticeStaffId(Integer integer);

    /***
     * 通过公告编号修改公告员工状态
     * @param integer1
     * @param integer2
     * @return
     */
    String updateNoticeOrId(Integer integer1,Integer integer2);
}
