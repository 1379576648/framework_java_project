package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    /***
     * 查询所有的员工并且离职没有隔月的员工
     * @return
     */
    @Select("select staff.STAFF_NAME,staff.STAFF_STATE, dept.DEPT_NAME,DEPT_POST.POST_NAME from staff INNER JOIN dept on staff.DEPT_ID= dept.DEPT_ID INNER JOIN DEPT_POST on staff.DEPT_POST_ID=DEPT_POST.DEPT_POST_ID\n" +
            "LEFT JOIN QUIT on staff.STAFF_NAME = QUIT.STAFF_NAME where QUIT_STATE=0  or   to_date(to_char(QUIT.FORMAL_QUIT_DATE,'YYYY-MM'),'YYYY-MM')>= to_date(to_char(sysdate,'YYYY-MM'),'YYYY-MM')   or QUIT_STATE is null  ")
    List<Staff> selectListOrState();



}
