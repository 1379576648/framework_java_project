package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 13795
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    /***
     * 通过条件查询员工数据
     * @param staffPage
     * @param queryWrapper
     * @return
     */
    @Select("SELECT A.*,B.POST_NAME FROM  STAFF A  INNER JOIN DEPT_POST B  ON A.DEPT_POST_ID=B.DEPT_POST_ID ${ew.customSqlSegment}")
    IPage<Staff>  selectStaffInState(Page<Staff> staffPage,@Param(Constants.WRAPPER) QueryWrapper<Staff> queryWrapper);
}
