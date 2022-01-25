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


    /**
     * 添加离职
     * @param quit
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertQuit(Quit quit) {
        String s = "成功";
        //离职
        Quit quit2 = new Quit();
        //如果数据不为空
        if(quit!=null){
            //员工名称
            quit2.setStaffName(quit.getStaffName());
            //离职原因
            quit2.setQuitType(quit.getQuitType());
            //离职时间
            quit2.setFormalQuitDate(quit.getFormalQuitDate());
            //备注
            quit2.setQuitExplain(quit.getQuitExplain());

            //添加到离职表
            int row = quitMapper.insert(quit2);

            //如果添加成功
            if(row>=1){
                s="成功";
            }else {
                return "添加失败";
            }
        }
        return s;
    }
}
