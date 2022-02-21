package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeStaffMapper noticeStaffMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private DeptPostMapper deptPostMapper;


    /****
     * 通过员工编号查询公告信息
     * @param integer
     * @return
     */
    @Override
    public Object selectNoticeStaffId(Integer integer) {
        List<NoticeStaff> noticeStaffList = noticeStaffMapper.selectList(new QueryWrapper<NoticeStaff>().eq("STAFF_ID", integer));
        List<Notice> notices = new ArrayList<>();
        for (NoticeStaff noticeStaff : noticeStaffList) {
            Notice notice = noticeMapper.selectById(noticeStaff.getNoticeId());
            notice.setState(noticeStaff.getNoticeState());
            notices.add(notice);
        }
        return notices;
    }

    /***
     * 通过公告编号修改公告员工状态
     * @param integer1
     * @param integer2
     * @return
     */
    @Override
    public String updateNoticeOrId(Integer integer1, Integer integer2) {
        NoticeStaff noticeStaff = new NoticeStaff();
        noticeStaff.setNoticeState(1L);
        int row = noticeStaffMapper.update(noticeStaff, new QueryWrapper<NoticeStaff>().eq("NOTICE_ID", integer1).eq("STAFF_ID", integer2));
        if (row <= 0) {
            return "查看失败";
        }
        return "成功";
    }
}
