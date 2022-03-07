package com.trkj.framework.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Archive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArchiveMapper extends BaseMapper<Archive> {

    @Select("select ARCHIVE_NAME,count(1) as Number1  from (select * from ARCHIVE order by CREATED_TIME ASC )  GROUP BY ARCHIVE_NAME ")
    IPage<Archive> selectCountArchive(Page<Archive> page, @Param(Constants.WRAPPER) QueryWrapper<Archive> queryWrapper);
}
