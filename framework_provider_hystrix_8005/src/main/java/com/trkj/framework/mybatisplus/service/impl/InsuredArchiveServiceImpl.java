package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.mybatisplus.mapper.InsuredArchiveMapper;
import com.trkj.framework.mybatisplus.service.InsuredArchiveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参保归档表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Service
public class InsuredArchiveServiceImpl implements InsuredArchiveService {
    @Autowired
    private InsuredArchiveMapper insuredArchiveMapper;
    /***
     * 分页查询参保归档数据
     * @param insuredArchive
     * @return
     */
    @Override
    public Object pageSelectInsuredArchive(InsuredArchive insuredArchive) {
        //分页插件
        Page<InsuredArchive> page = new Page<InsuredArchive>(insuredArchive.getCurrenPage(), insuredArchive.getPageSize());
        //条件构造器
        QueryWrapper<InsuredArchive> queryWrapper = new QueryWrapper<InsuredArchive>();
        //判断传入的时间是否为空
        if (insuredArchive.getStartTime() != null || insuredArchive.getEndTime() != null) {
            //计薪时间范围查询
            queryWrapper.between("INS_ARCHIVE_SALARY_MONTH", insuredArchive.getStartTime(), insuredArchive.getEndTime());
        }
        //通过员工名称进行查询
        queryWrapper.eq("INS_ARCHIVE_STAFF_NAME",insuredArchive.getInsArchiveStaffName());
        queryWrapper.orderByDesc("INS_ARCHIVE_SALARY_MONTH");
        return insuredArchiveMapper.selectPage(page,queryWrapper);
    }

    /***
     * 通过计薪月份查询归档数据
     * @param insuredArchive
     * @return
     */
    @Override
    public Object selectListInsuredArchive(InsuredArchive insuredArchive) {
        int a=1/0;
        //分页插件
        Page<InsuredArchive> page = new Page<>(insuredArchive.getCurrenPage(), insuredArchive.getPageSize());
        //条件构造器
        QueryWrapper<InsuredArchive> queryWrapper  = new QueryWrapper<>();
        //当前月
        int year = insuredArchive.getInsArchiveSalaryMonth().getYear() + 1900;
       int  month = insuredArchive.getInsArchiveSalaryMonth().getMonth() + 1;
        queryWrapper.eq("to_char(INS_ARCHIVE_SALARY_MONTH,'YYYY-MM')",month > 9 ? year + "-" + month : year + "-" + "0" + month);
        queryWrapper.orderByDesc("INS_ARCHIVE_ID");
        //判断名称是否为空
        if (insuredArchive.getInsArchiveStaffName() != null && !insuredArchive.getInsArchiveStaffName().equals("")) {
            //根据姓名模糊查询
            queryWrapper.like("INS_ARCHIVE_STAFF_NAME", insuredArchive.getInsArchiveStaffName());
        }
        //判断部门列表是否为空
        if (insuredArchive.getListDept().size() > 0) {
            for (int i = 0; i < insuredArchive.getListDept().size(); i++) {
                //根据部门列表查询
                queryWrapper.eq("INS_ARCHIVE_DEPT_NAME", insuredArchive.getListDept().get(i));
            }
        }
        return insuredArchiveMapper.selectPage(page,queryWrapper);
    }
}
