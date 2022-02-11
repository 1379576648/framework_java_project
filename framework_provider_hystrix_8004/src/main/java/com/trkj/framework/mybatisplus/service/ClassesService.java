package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Classes;

import java.util.List;


/**
 * 班次方案 服务类
 *
 * @author 里予
 * @since 2022-1-29
 */
public interface ClassesService {

    /**
     * 查询所有班次方案
     * @param classes
     * @return
     */
    IPage<Classes> selectClassesAll(Classes classes);

    /**
     * 添加班次方案
     * @param classes
     * @return
     */
    Integer submitFormClasses(Classes classes);

    /**
     * 查询班次方案
     * @param classes
     * @return
     */
    List<Classes>inquireClasses(Classes classes);

    /**
     * 删除班次方案
     * @param classes
     * @return
     */
    Integer deleteClasses(Classes classes);

    /**
     * 查询所有班次方案
     * @param classes
     * @return
     */
    List<Classes> selectClasses(Classes classes);

    /**
     * 修改班次方案状态(启用)
     * @param classes
     * @return
     */
    Integer updateClassesState(Classes classes);

    /**
     * 修改班次方案状态(禁用)
     * @param classes
     * @return
     */
    Integer updateClassesStateTwo(Classes classes);

    /**
     * 根据班次编号去查询
     * @param classes
     * @return
     */
    Classes selectClassesByID(Classes classes);

    /**
     * 修改班次方案
     * @param classes
     * @return
     */
    Integer updateClasses(Classes classes);
}
