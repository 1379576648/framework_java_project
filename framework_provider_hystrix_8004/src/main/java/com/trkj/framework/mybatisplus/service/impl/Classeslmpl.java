package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Classes;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.mapper.ClassesMapper;
import com.trkj.framework.mybatisplus.service.ClassesService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class Classeslmpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 查询所有班次方案
     *
     * @param classes
     * @return
     */
    @Override
    public IPage<Classes> selectClassesAll(Classes classes) {
        Page<Classes> page = new Page<>(classes.getCurrentPage(), classes.getPagesize());
        QueryWrapper<Classes> queryWrapper = new QueryWrapper<>();
        if (classes.getStartTime() != null || classes.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", classes.getStartTime(), classes.getEndTime());
        }
        if (classes.getClassesName() != null) {
            //班次方案名称模糊查询
            queryWrapper.like("CLASSES_NAME", classes.getClassesName());
        }
        return classesMapper.selectPage(page, queryWrapper);
    }

    /**
     * 添加班次方案
     *
     * @param classes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer submitFormClasses(Classes classes) throws ArithmeticException {
        Classes classes1 = new Classes();
        classes1.setClassesName(classes.getClassesName());
        classes1.setClassesBeginDate(classes.getClassesBeginDate());
        classes1.setClassesEndDate(classes.getClassesEndDate());
        final var insert = classesMapper.insert(classes1);
        if (insert == 1) {
            return 1;
        } else {
            throw new ArithmeticException("添加失败");
        }
    }

    /**
     * 查询班次方案
     *
     * @param classes
     * @return
     */
    @Override
    public List<Classes> inquireClasses(Classes classes) {
        QueryWrapper<Classes> queryWrapper = new QueryWrapper<>();
        if (classes.getClassesName() != null) {
            queryWrapper.eq("CLASSES_NAME", classes.getClassesName());
        }
        if (classes.getClassesId() != null) {
            queryWrapper.eq("CLASSES_ID", classes.getClassesId());
        }
        return classesMapper.selectList(queryWrapper);
    }

    /**
     * 删除班次方案
     *
     * @param classes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteClasses(Classes classes) throws ArithmeticException {
        final var classesId = classes.getClassesId();
        Classes classes1 = new Classes();
        classes1.setIsDeleted(1L);
        classes1.setClassesId(classesId);
        classes1.setUpdatedTime(new Date());
        final var i = classesMapper.deleteById(classes1);
        if (i == 1) {
            return i;
        }
        throw new ArithmeticException("删除失败");
    }

    /**
     * 查询所有班次方案
     *
     * @param classes
     * @return
     */
    @Override
    public List<Classes> selectClasses(Classes classes) {
        QueryWrapper<Classes> queryWrapper = new QueryWrapper<>();
        return classesMapper.selectList(queryWrapper);
    }

    /**
     * 修改班次方案状态(启用)
     *
     * @param classes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateClassesState(Classes classes) throws ArithmeticException {
        Classes classes1 = new Classes();
        classes1.setClassesId(classes.getClassesId());
        classes1.setClassesState(0);
        final var i = classesMapper.updateById(classes1);
        if (i == 1) {
            return i;
        } else {
            throw new ArithmeticException("启用失败");
        }

    }

    /**
     * 修改班次方案状态(禁用)
     *
     * @param classes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateClassesStateTwo(Classes classes) throws ArithmeticException {
        Classes classes1 = new Classes();
        classes1.setClassesId(classes.getClassesId());
        classes1.setClassesState(1);
        final var i = classesMapper.updateById(classes1);
        if (i == 1) {
            return i;
        } else {
            throw new ArithmeticException("禁用失败");
        }
    }

    /**
     * 根据班次编号去查询
     *
     * @param classes
     * @return
     */
    @Override
    public Classes selectClassesByID(Classes classes) {
        Classes classes1 = new Classes();
        classes1.setClassesId(classes.getClassesId());
        return classesMapper.selectById(classes1);
    }

    /**
     * 修改班次方案
     *
     * @param classes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateClasses(Classes classes) throws ArithmeticException {
        Classes classes1 = new Classes();
        classes1.setClassesId(classes.getClassesId());
        classes1.setClassesName(classes.getClassesName());
        classes1.setClassesBeginDate(classes.getClassesBeginDate());
        classes1.setClassesEndDate(classes.getClassesEndDate());
        final var i = classesMapper.updateById(classes1);
        if (i >= 1) {
            return i;
        } else {
            throw new ArithmeticException("修改失败");
        }
    }
}
