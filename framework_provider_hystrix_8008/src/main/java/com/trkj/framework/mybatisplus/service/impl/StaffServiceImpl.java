package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

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

    /**
     * 修改转正日期
     * @param staff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWorkerDate(Staff staff) {
        final var i = staffMapper.updateById(staff);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 快要转正名单
     * @param fullVo
     * @return
     */
    @Override
    public IPage<FullVo> selectQuick(FullVo fullVo) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar = Calendar.getInstance();
        //过去7天
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-7);
        Date d = calendar.getTime();
        Page<FullVo> page = new Page<>(fullVo.getCurrentPage(),fullVo.getPagesize());
        QueryWrapper<FullVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_STATE",0);
        queryWrapper.lt("WORKER_DATE",d);
        return staffMapper.selectQuick(page,queryWrapper);
    }

    /**
     * 统计快要转正名单
     * @param
     * @return
     */
    @Override
    public List<Staff> countByStaffState() {
        return staffMapper.countByStaffState();

    }

    /**
     * 转正已生效
     * @param fullVo
     * @return
     */
    @Override
    public IPage<FullVo> selectStateOne(FullVo fullVo) {
        Page<FullVo> page = new Page<>(fullVo.getCurrentPage(),fullVo.getPagesize());
        QueryWrapper<FullVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_STATE",1);
        return staffMapper.selectStateOne(page,queryWrapper);
    }

    /**
     * 统计转正已生效
     * @return
     */
    @Override
    public List<Staff> countStateOne() {
        return staffMapper.countStateOne();
    }

    /**
     * 统计试用期人员
     * @return
     */
    @Override
    public List<Staff> countStateTwo() {
        return staffMapper.countStateTwo();
    }


}
