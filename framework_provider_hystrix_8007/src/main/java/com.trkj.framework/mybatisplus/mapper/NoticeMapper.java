package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    /***
     *分页查询所有公告数据
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select * from NOTICE ${ew.customSqlSegment}")
    IPage<Notice> selectNoticeAll(Page<Notice> page,@Param(Constants.WRAPPER)  QueryWrapper<Notice> queryWrapper);
}
