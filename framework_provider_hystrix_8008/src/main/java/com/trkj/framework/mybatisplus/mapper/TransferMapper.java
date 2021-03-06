package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Transfer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.TransferTwoVo;
import com.trkj.framework.vo.TransferVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 调动记录表 Mapper 接口
 * </p>
 *
 * @author suki
 * @since 2022-01-10
 */
@Mapper
public interface TransferMapper extends BaseMapper<Transfer> {

    /**
     * 查询调动管理
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_NAME,t.TRANSFER_TYPE,t.CREATED_DEPT_NAME,t.UPDATED_DEPT_NAME,t.transfer_rawpost_NAME,t.transfer_afterpost_NAME,TAKE_EFFECT_DATE FROM TRANSFER t LEFT JOIN STAFF s on s.STAFF_NAME=t.STAFF_NAME ${ew.customSqlSegment}")
    IPage<TransferVo> selectTransfer(Page<TransferVo> page, @Param(Constants.WRAPPER) QueryWrapper<TransferVo> queryWrapper);

    /**
     * 查询所有员工姓名
     * @return
     */
    @Select("SELECT STAFF_NAME FROM STAFF")
    List<Staff> selectStaffName();

    /**
     * 查询所有的部门名称
     * @return
     */
    @Select("SELECT distinct DEPT_NAME FROM DEPT")
    List<Dept> selectSect();

    /**
     * 根据名字查询部门名称和职位名称
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,d.DEPT_ID,p.DEPT_POST_ID,d.DEPT_NAME,p.POST_NAME FROM STAFF s LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID ${ew.customSqlSegment}")
    List<TransferTwoVo> selectTransferByName(@Param(Constants.WRAPPER) QueryWrapper<TransferTwoVo> queryWrapper);

    /**
     * 根据员工姓名查询调动记录
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM TRANSFER ${ew.customSqlSegment}")
    List<Transfer> selectTransferAlls(@Param(Constants.WRAPPER) QueryWrapper<Transfer> queryWrapper);

    /**
     * 根据部门查询部门职位名称
     * @param queryWrapper
     * @return
     */
    @Select("SELECT d.DEPT_ID,p.DEPT_POST_ID,p.POST_NAME FROM DEPT_POST p LEFT JOIN DEPT d on d.DEPT_ID=p.DEPT_ID ${ew.customSqlSegment}")
    List<TransferTwoVo> selectPostName(@Param(Constants.WRAPPER) QueryWrapper<TransferTwoVo> queryWrapper);
}
