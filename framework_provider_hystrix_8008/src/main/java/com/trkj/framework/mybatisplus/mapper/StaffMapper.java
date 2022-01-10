package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 查询员工花名册
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,s.STAFF_NAME,s.STAFF_SEX,s.STAFF_PHONE,s.STAFF_EMAIL,s.STAFF_PICTURE,s.STAFF_BIRTHDAY,s.STAFF_OUTLOOK,s.STAFF_EDUCATION,s.STAFF_PASS,s.STAFF_HIREDATE,s.STAFF_IDENTITY,s.STAFF_MAJOR,s.STAFF_EMERGENCY,s.STAFF_WECHAT,s.STAFF_QQ,s.STAFF_CREDIT,s.STAFF_BLOOD,s.STAFF_SIGN,s.STAFF_MARITAL,s.STAFF_REGISTERED,s.STAFF_SCHOOL,s.STAFF_ADDRESS,s.STAFF_STATE,s.WORK_AGE,d.DEPT_NAME,p.POST_NAME,w.WORKER_DATE FROM STAFF s LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID LEFT JOIN WORKER w on w.WORKER_ID=s.WORKER_ID ${ew.customSqlSegment}")
    IPage<StaffVo> selectStaff(Page<StaffVo> page, @Param(Constants.WRAPPER) QueryWrapper<StaffVo> queryWrapper);

    /**
     * 根据id查询所有员工信息
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,s.STAFF_NAME,s.STAFF_SEX,s.STAFF_PHONE,s.STAFF_EMAIL,s.STAFF_PICTURE,s.STAFF_BIRTHDAY,s.STAFF_OUTLOOK,s.STAFF_EDUCATION,s.STAFF_PASS,s.STAFF_HIREDATE,s.STAFF_IDENTITY,s.STAFF_MAJOR,s.STAFF_EMERGENCY,s.STAFF_WECHAT,s.STAFF_QQ,s.STAFF_CREDIT,s.STAFF_BLOOD,s.STAFF_SIGN,s.STAFF_MARITAL,s.STAFF_REGISTERED,s.STAFF_SCHOOL,s.STAFF_ADDRESS,s.STAFF_STATE,s.WORK_AGE,d.DEPT_NAME,p.POST_NAME,w.WORKER_DATE FROM STAFF s LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID LEFT JOIN WORKER w on w.WORKER_ID=s.WORKER_ID ${ew.customSqlSegment}")
    List<StaffVo> selectStaffAll(@Param(Constants.WRAPPER) QueryWrapper<StaffVo> queryWrapper);

    /**
     * 查询历史花名册
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_NAME,s.STAFF_STATE,d.DEPT_NAME,p.POST_NAME,s.STAFF_PHONE,s.STAFF_EMAIL,s.WORK_AGE,s.STAFF_HIREDATE,q.FORMAL_QUIT_DATE,q.QUIT_TYPE FROM STAFF s LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID LEFT JOIN QUIT q on q.STAFF_NAME=s.STAFF_NAME ${ew.customSqlSegment}")
    IPage<StaffQuitVo> selectQuit(Page<StaffQuitVo> page, @Param(Constants.WRAPPER) QueryWrapper<StaffQuitVo> queryWrapper);

    /**
     * 查询调动管理
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_NAME,t.TRANSFER_TYPE,t.CREATED_DEPT_NAME,t.UPDATED_DEPT_NAME,t.transfer_rawpost_NAME,t.transfer_afterpost_NAME,TAKE_EFFECT_DATE FROM TRANSFER t LEFT JOIN STAFF s on s.STAFF_NAME=t.STAFF_NAME ${ew.customSqlSegment}")
    IPage<TransferVo> selectTransfer(Page<TransferVo> page,@Param(Constants.WRAPPER) QueryWrapper<TransferVo> queryWrapper);


}
