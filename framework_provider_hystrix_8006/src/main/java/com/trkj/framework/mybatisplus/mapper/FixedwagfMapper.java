package com.trkj.framework.mybatisplus.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.vo.FixedwageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 13795
 */
@Mapper
public interface FixedwagfMapper extends BaseMapper<Fixedwagf> {

    /**
     * 查询固定工资
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.STAFF_NAME,s.WORKER_DATE,p.POST_NAME,s.STAFF_HIREDATE,s.STAFF_STATE,f.FIXEDWAGE_ID,f.FIXEDWAGE_PERIODMONEY,f.FIXEDWAGE_PERIODPOSTMONEY,d.DEPT_NAME FROM STAFF s LEFT JOIN DEPT_POST p on p.DEPT_POST_ID=s.DEPT_POST_ID LEFT JOIN FIXEDWAGE f on f.STAFF_NAME=s.STAFF_NAME LEFT JOIN DEPT d on d.DEPT_ID=s.DEPT_ID ${ew.customSqlSegment}")
    IPage<FixedwageVo> selectFixedwage(Page<FixedwageVo> page, @Param(Constants.WRAPPER) QueryWrapper<FixedwageVo> queryWrapper);
}
