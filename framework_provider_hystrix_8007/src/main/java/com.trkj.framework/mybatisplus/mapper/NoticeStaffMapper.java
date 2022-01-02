package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.NoticeDept;
import com.trkj.framework.entity.mybatisplus.NoticeStaff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公告员工表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-31
 */
@Mapper
public interface NoticeStaffMapper extends BaseMapper<NoticeStaff> {
    /***
     * 物理删除公告员工表数据
     * @param queryWrapper
     * @return
     */
    @Delete("delete from NOTICE_STAFF ${ew.customSqlSegment}")
    int deleteNoticeStaff(@Param(Constants.WRAPPER) QueryWrapper<NoticeDept> queryWrapper);
}
