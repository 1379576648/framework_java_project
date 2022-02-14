package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.entity.mybatisplus.InsuredDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 参保归档表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Mapper
public interface InsuredArchiveMapper extends BaseMapper<InsuredArchive> {

    /***
     * 归档分页查询
     * @param insuredArchivePage
     * @return
     */
    public IPage<InsuredArchive> archived(Page<InsuredArchive> insuredArchivePage);
}
