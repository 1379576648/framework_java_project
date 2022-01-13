package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.mapper.QuitMapper;
import com.trkj.framework.mybatisplus.service.QuitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 离职表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class QuitServiceImpl implements QuitService {

    @Autowired
    private QuitMapper quitMapper;


}
