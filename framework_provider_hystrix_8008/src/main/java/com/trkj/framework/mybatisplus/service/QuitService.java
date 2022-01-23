package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.entity.mybatisplus.WorkExperience;

/**
 * <p>
 * 离职表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface QuitService {

    /**
     * 添加离职
     * @param quit
     * @return
     */
    String insertQuit(Quit quit);


}
