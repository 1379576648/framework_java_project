package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Notice;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
public interface NoticeService  {
    /***
     * 分页查询所有公告数据
     * @param registerLog
     * @return
     */
    IPage<Notice> selectNoticeAll(Notice registerLog);

}
