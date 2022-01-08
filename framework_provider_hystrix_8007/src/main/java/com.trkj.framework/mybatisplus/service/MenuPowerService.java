package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.MenuPower;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
public interface MenuPowerService  {
    /***
     * 获取数据库级联菜单列表
     * @return
     */
    Object menuPowerList();
}
