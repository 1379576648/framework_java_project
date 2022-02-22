package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Archive;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.ArchiveMapper;
import com.trkj.framework.mybatisplus.mapper.CardRecordMapper;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.MonthStatisticsService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class MonthStatisticslmpl implements MonthStatisticsService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private CardRecordMapper cardRecordMapper;
    @Autowired
    private ArchiveMapper archiveMapper;


    /**
     * 查询所有员工的考勤状态次数
     *
     * @param staff
     * @return
     */
    @Override
    public IPage<Staff> selectStaffNameAll(Staff staff) {
        Page<Staff> page = new Page<>(staff.getCurrentPage(), staff.getPageSize());
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        if (staff.getStaffName1() != null) {
            //根据名称名称模糊查询
            queryWrapper.like("STAFF_NAME", staff.getStaffName1());
        }
        queryWrapper.ne("STAFF_NAME", staff.getStaffName());
        // 根据条件查询到相应的员工数据
        final var staff1 = staffMapper.selectPage(page, queryWrapper);
        for (int i = 0; i < staff1.getRecords().size(); i++) {
            // 再根据对应的员工数据循环查询其部门数据
            Dept dept = deptMapper.selectById(staff1.getRecords().get(i).getDeptId());
            if (dept == null) {
                return staff1;
            }
            // 根据查询到的部门数据 取到部门名称
            staff1.getRecords().get(i).setDeptName(dept.getDeptName());
            QueryWrapper<ClockRecord> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("STAFF_NAME", staff1.getRecords().get(i).getStaffName());
            // 当前日期转格式
            Date now = new Date();
            LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date newDate = java.sql.Date.valueOf(localDate);
            // 再转成string型
            java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String date = formatter.format(newDate);
            queryWrapper1.apply("TO_CHAR(CREATED_TIME,'yyyy-mm' ) like {0}", date);
            // 根据员工名称查询对应的打卡记录数据
            final var clockRecords = cardRecordMapper.selectCountState(queryWrapper1);
            staff1.getRecords().get(i).setList(clockRecords);
        }
        return staff1;
    }

    /**
     * 添加归档表
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String archivedData(Staff staff) throws ArithmeticException {
        // 查询归档表中有无当月记录
        QueryWrapper<Archive> apply = new QueryWrapper<>();
        // 当前日期转格式
        Date now1 = new Date();
        LocalDate localDate1 = now1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate1 = java.sql.Date.valueOf(localDate1);
        // 再转成string型
        java.text.SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM");
        String date1 = formatter1.format(newDate1);
        apply.like("ARCHIVE_NAME", date1);
        final var archives = archiveMapper.selectList(apply);
        if (archives.size() != 0) {
            return "已归档";
        }
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        if (staff.getStaffName1() != null) {
            //根据部门名称名称模糊查询
            queryWrapper.like("STAFF_NAME", staff.getStaffName1());
        }
        queryWrapper.ne("STAFF_NAME", staff.getStaffName());
        // 根据条件查询到相应的员工数据
        final var staff1 = staffMapper.selectList(queryWrapper);
        for (int i = 0; i < staff1.size(); i++) {
            // 再根据对应的员工数据循环查询其部门数据
            Dept dept = deptMapper.selectById(staff1.get(i).getDeptId());
            if (dept == null) {
                throw new ArithmeticException("查询失败");
            }
            // 根据查询到的部门数据 取到部门名称
            staff1.get(i).setDeptName(dept.getDeptName());
            QueryWrapper<ClockRecord> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("STAFF_NAME", staff1.get(i).getStaffName());
            // 当前日期转格式
            Date now = new Date();
            LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date newDate = java.sql.Date.valueOf(localDate);
            // 再转成string型
            java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String date = formatter.format(newDate);
            queryWrapper1.apply("TO_CHAR(CREATED_TIME,'yyyy-mm' ) like {0}", date);
            // 根据员工名称查询对应的打卡记录数据
            final var clockRecords = cardRecordMapper.selectCountState(queryWrapper1);
            staff1.get(i).setList(clockRecords);
        }

        var insert = 0;
        for (int i = 0; i < staff1.size(); i++) {
            // 当前日期转格式
            Date now = new Date();
            LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date newDate = java.sql.Date.valueOf(localDate);
            // 再转成string型
            java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String date = formatter.format(newDate);
            Archive archive1 = new Archive();
            archive1.setArchiveName(date + "月考勤报表");
            archive1.setStaffName(staff1.get(i).getStaffName());
            archive1.setDeptName(staff1.get(i).getDeptName());
            archive1.setNormalFrequency(0);
            archive1.setLateFrequency(0);
            archive1.setAbsenteeismFrequency(0);
            archive1.setLeaveEarlyFrequency(0);
            for (int j = 0; j < staff1.get(i).getList().size(); j++) {
                if (Objects.equals(staff1.get(i).getList().get(j).getCheckState(), "正常")) {
                    archive1.setNormalFrequency(staff1.get(i).getList().get(j).getStateNumber());
                } else if (Objects.equals(staff1.get(i).getList().get(j).getCheckState(), "早退")) {
                    archive1.setLeaveEarlyFrequency(staff1.get(i).getList().get(j).getStateNumber());
                } else if (Objects.equals(staff1.get(i).getList().get(j).getCheckState(), "迟到")) {
                    archive1.setLateFrequency(staff1.get(i).getList().get(j).getStateNumber());
                } else if (Objects.equals(staff1.get(i).getList().get(j).getCheckState(), "旷工")) {
                    archive1.setAbsenteeismFrequency(staff1.get(i).getList().get(j).getStateNumber());
                }
                if (archive1.getLeaveEarlyFrequency() >= 1 || archive1.getLateFrequency() >= 1 || archive1.getAbsenteeismFrequency() >= 1) {
                    archive1.setPresent("否");
                } else {
                    archive1.setPresent("是");
                }
            }
            insert = archiveMapper.insert(archive1);
        }
        if (insert == 1) {
            return "归档成功";
        } else {
            return "归档失败";
        }
    }

    /**
     * 查询所有考勤归档
     *
     * @param archive
     * @return
     */
    @Override
    public IPage<Archive> selectArchiveAll(Archive archive) {
        Page<Archive> page = new Page<>(archive.getCurrentPage(), archive.getPageSize());
        QueryWrapper<Archive> queryWrapper = new QueryWrapper<>();
        return archiveMapper.selectCountArchive(page, queryWrapper);
    }

    /**
     * 根据名称查询考勤归档
     *
     * @param archive
     * @return
     */
    @Override
    public List<Archive> selectArchiveByName(Archive archive) {
        QueryWrapper query = new QueryWrapper<>();
        query.eq("ARCHIVE_NAME", archive.getArchiveName());
        return archiveMapper.selectList(query);
    }

    /**
     * 根据名称查询考勤归档
     *
     * @param archive
     * @return
     */
    @Override
    public IPage<Archive> selectArchiveByNameAndIPage(Archive archive) {
        Page<Archive> page = new Page<>(archive.getCurrentPage(), archive.getPageSize());
        QueryWrapper query = new QueryWrapper<>();
        if (archive.getStaffName() != null) {
            //根据名称名称模糊查询
            query.like("STAFF_NAME", archive.getStaffName());
        }
        query.eq("ARCHIVE_NAME", archive.getArchiveName());
        return archiveMapper.selectPage(page,query);
    }
}

