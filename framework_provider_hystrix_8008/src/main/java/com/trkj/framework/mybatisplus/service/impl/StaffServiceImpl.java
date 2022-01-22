package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @Override
    public IPage<StaffVo> selectStaff(StaffVo staffVo) {
        Staff staff = new Staff();
        Page<StaffVo> page = new Page<>(staffVo.getCurrentPage(),staffVo.getPagesize());
        QueryWrapper<StaffVo> queryWrapper = new QueryWrapper<>();
        //根据名称查询
        if(staffVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",staffVo.getStaffName());
        }
        queryWrapper.ne("s.STAFF_STATE",2);
        IPage<StaffVo> list = staffMapper.selectStaff(page,queryWrapper);
        for(StaffVo staffvo : list.getRecords()){
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            //放入入职日期和当前日期
            Period period = Period.between(LocalDate.parse(df.format(staffvo.getStaffHiredate())),
                    LocalDate.parse(df.format(new Date())));
            //将计算好的工龄放入vo视图中
            staffvo.setWorkAge(period.getYears()+"年"+period.getMonths()+"月"+period.getDays()+"日");
            //在数据库中修改
            //取当前循环的员工id
            staff.setStaffId(staffvo.getStaffId());
            //取当前循环员工的工龄
            staff.setWorkAge(staffvo.getWorkAge());
            staffMapper.updateById(staff);
        }
        return list;
    }

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    @Override
    public List<StaffVo> selectStaffAll(StaffVo staffVo) {
        QueryWrapper<StaffVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_ID",staffVo.getStaffId());
        return staffMapper.selectStaffAll(queryWrapper);
    }

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    @Override
    public IPage<StaffQuitVo> selectQuit(StaffQuitVo staffQuitVo) {
        Page<StaffQuitVo> page = new Page<>(staffQuitVo.getCurrentPage(),staffQuitVo.getPagesize());
        QueryWrapper<StaffQuitVo> queryWrapper = new QueryWrapper<>();
        //根据名称查询
        if(staffQuitVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",staffQuitVo.getStaffName());
        }
        queryWrapper.eq("s.STAFF_STATE",2);
        return staffMapper.selectQuit(page,queryWrapper);
    }



    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStaff(Staff staff) {
        final var i = staffMapper.updateById(staff);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStaffTwo(Staff staff) {
        final var i = staffMapper.updateById(staff);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改员工状态为正式
     * @param staff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStaffState(Staff staff) {
        final var i = staffMapper.updateById(staff);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 修改员工状态为离职
     * @param staff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStaffStateTwo(Staff staff) {
        final var i = staffMapper.updateById(staff);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }


}
