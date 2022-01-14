package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.mybatisplus.mapper.GloryMapper;
import com.trkj.framework.mybatisplus.mapper.QuitMapper;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.mybatisplus.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 奖励表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class GloryServiceImpl implements GloryService {

    @Autowired
    private GloryMapper gloryMapper;


}
