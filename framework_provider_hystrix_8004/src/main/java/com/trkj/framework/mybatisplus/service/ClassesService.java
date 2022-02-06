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

    IPage<Classes> selectClassesAll(Classes classes);

    Integer submitFormClasses(Classes classes);

    List<Classes>inquireClasses(Classes classes);

    Integer deleteClasses(Classes classes);
}
