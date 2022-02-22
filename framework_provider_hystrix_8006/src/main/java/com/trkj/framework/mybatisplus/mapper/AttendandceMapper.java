package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.vo.AttendandceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttendandceMapper extends BaseMapper<Attendandce> {

    /**
     * 查询考勤扣款方案
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT a.ATTENDANDCE_ID,a.ATTENDANDCE_LITEMONEY,a.ATTENDANDCE_NAME,a.ATTENDANDCE_LEAVEMONEY,a.ATTENDANDCE_DIDNOTMONEY,a.ATTENDANDCE_DIDBACKMONEY,a.ATTENDANDCE_ABSCNTMONEY,a.ATTENDANDCE_STATE,a.ATTENDANDCE_REMARK, a.IS_DELETED,d.DEPT_NAME FROM ATTENDANDCE a LEFT JOIN DEPT d on d.DEPT_NAME=a.DEPT_NAME ${ew.customSqlSegment}")
    IPage<AttendandceVo> selectAttendandce(Page<AttendandceVo> page, @Param(Constants.WRAPPER)QueryWrapper<AttendandceVo> queryWrapper);

    /**
     * 根据id查询考勤扣款方案
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM ATTENDANDCE ${ew.customSqlSegment}")
    List<Attendandce> selectAttendandceAll(@Param(Constants.WRAPPER) QueryWrapper<Attendandce> queryWrapper);
}
