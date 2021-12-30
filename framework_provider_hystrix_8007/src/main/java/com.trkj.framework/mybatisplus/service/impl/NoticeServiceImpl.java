package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.mapper.NoticeMapper;
import com.trkj.framework.mybatisplus.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /****
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @Override
    public IPage<Notice> selectNoticeAll(Notice notice) {
        Page<Notice> page = new Page<Notice>(notice.getCurrenPage(),notice.getPageSize());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        if (notice.getNoticeTitle()!=null&&!notice.getNoticeTitle().equals("")){
            //公告标题模糊查询
            queryWrapper.like("NOTICE_TITLE",notice.getNoticeTitle());
        }
        if (notice.getNoticePeople()!=null&&!notice.getNoticePeople().equals("")){
            //发布人模糊查询
            queryWrapper.like("NOTICE_PEOPLE",notice.getNoticePeople());
        }
        if (notice.getNoticeType()!=null){
            //类型模糊查询
            queryWrapper.like("NOTICE_TYPE",notice.getNoticeType());
        }
        if (notice.getStartTime()!=null||notice.getEndTime()!=null){
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME",notice.getStartTime(),notice.getEndTime());
        }
        //逻辑删除查询
        queryWrapper.eq("IS_DELETED",0);
        return noticeMapper.selectNoticeAll(page,queryWrapper);
    }

    @Override
    @Transactional
    public String checkNoticeDelete(ArrayList<Integer> list) {
        for (int i = 0; i <list.size() ; i++) {
            if (noticeMapper.deleteById(list.get(i))<=0){
                return "失败";
            }
        }
        return "成功";
    }
}
