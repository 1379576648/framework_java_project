package com.trkj.framework.mybatisplus.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.vo.WageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {

    /**
     * 查询调薪
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_ID,y.STAFF_NAME,d.DEPT_NAME,p.POST_NAME,y.FRONT_SALARY,y.AFTER_SALARY,y.TAKE_EFFECT_DATE,y.SALARY_TYPE,y.SALARY_REMARKS,y.operator,y.SALARY_STATE FROM SALARY y LEFT JOIN STAFF s on s.STAFF_NAME=y.STAFF_NAME LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<WageVo> selectSalary(Page<WageVo> page, @Param(Constants.WRAPPER)QueryWrapper<WageVo> queryWrapper);

    /**
     * 本月调薪
     * @return
     */
    @Select("SELECT COUNT(STAFF_NAME) tx FROM SALARY WHERE TO_CHAR(CREATED_TIME,'yyyy-mm')=TO_CHAR(SYSDATE,'yyyy-mm')")
    List<Salary> counttx();


}
