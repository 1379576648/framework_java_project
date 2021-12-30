package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.RegisterLog;

import java.util.ArrayList;

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

    /***
     * 多选删除
     * @param list
     * @return
     */
    String checkDelete(ArrayList<Integer> list);

    /**
     * 清空数据
     * @return
     */
    String emptyList();

}
