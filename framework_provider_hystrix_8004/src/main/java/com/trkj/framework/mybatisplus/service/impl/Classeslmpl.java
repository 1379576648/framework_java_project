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

import java.util.Date;
import java.util.List;


@Service
public class Classeslmpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

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

    @Override
    public Integer submitFormClasses(Classes classes) {
        Classes classes1 = new Classes();
        classes1.setClassesName(classes.getClassesName());
        classes1.setClassesBeginDate(classes.getClassesBeginDate());
        classes1.setClassesEndDate(classes.getClassesEndDate());
        return classesMapper.insert(classes1);
    }

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

    @Override
    public Integer deleteClasses(Classes classes) {
        final var classesId = classes.getClassesId();
        Classes classes1 = new Classes();
        classes1.setIsDeleted(1L);
        classes1.setClassesId(classesId);
        classes1.setUpdatedTime(new Date());
        return classesMapper.deleteById(classes1);
    }
}
