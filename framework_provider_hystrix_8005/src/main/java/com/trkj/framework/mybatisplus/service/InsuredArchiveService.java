package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;

/**
 * <p>
 * 参保归档表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
public interface InsuredArchiveService  {
    /***
     * 分页查询参保归档数据
     * @param insuredArchive
     * @return
     */
    Object pageSelectInsuredArchive(InsuredArchive insuredArchive);

    /**
     * 通过计薪月份查询归档数据
     * @param insuredArchive
     * @return
     */
    Object selectListInsuredArchive(InsuredArchive insuredArchive);
}
