package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.MoneyPigeonhole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper
public interface MoneyPigeonholeMapper extends BaseMapper<MoneyPigeonhole> {
    /**
     * 查询未归档工资表
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM MONEYPIGEONHOLE ${ew.customSqlSegment}")
    IPage<MoneyPigeonhole> selectMoney(Page<MoneyPigeonhole> page, @Param(Constants.WRAPPER) QueryWrapper<MoneyPigeonhole> queryWrapper);

    /**
     * 查询已归档工资表
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM MONEYPIGEONHOLE ${ew.customSqlSegment}")
    IPage<MoneyPigeonhole> selectMoneys(Page<MoneyPigeonhole> page, @Param(Constants.WRAPPER) QueryWrapper<MoneyPigeonhole> queryWrapper);

    /**
     * 根据月份分组查询已归档的数据统计
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM')  as payMonth  , count(to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM')) as countPerson from MONEYPIGEONHOLE ${ew.customSqlSegment}   GROUP BY to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM') ORDER BY to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM') desc")
    IPage<MoneyPigeonhole> selectPage(Page<MoneyPigeonhole> page, @Param(Constants.WRAPPER) QueryWrapper<MoneyPigeonhole> queryWrapper);

    /**
     * 薪酬统计
     * @param queryWrapper
     * @return
     */
    @Select("select to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM')  as payMonth  , count(to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM')) as countPerson from MONEYPIGEONHOLE ${ew.customSqlSegment}   GROUP BY to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM') ORDER BY to_date(to_char(ADD_MONTHS(CREATED_TIME,-1),'YYYY-MM'),'YYYY-MM') desc")
    List<MoneyPigeonhole> selectstatcis(@Param(Constants.WRAPPER) QueryWrapper<MoneyPigeonhole> queryWrapper);

    /**
     * 薪酬统计
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM MONEYPIGEONHOLE ${ew.customSqlSegment}")
    List<MoneyPigeonhole> selectstatc(@Param(Constants.WRAPPER) QueryWrapper<MoneyPigeonhole> queryWrapper);
 }
