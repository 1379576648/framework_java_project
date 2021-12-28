package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.RegisterLog;

/**
 * <p>
 * 登录日志表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
public interface RegisterLogService {
    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    IPage<RegisterLog> selectRegisterLogAll( RegisterLog registerLog);
}
