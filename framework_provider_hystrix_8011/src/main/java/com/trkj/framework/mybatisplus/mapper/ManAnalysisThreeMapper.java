package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */
@Mapper
public interface ManAnalysisThreeMapper extends BaseMapper<StaffVo> {

        /**
         * 员工性别查询
         * @return
         */
        @Select("select STAFF_SEX,COUNT(STAFF_SEX) as rs FROM STAFF GROUP BY STAFF_SEX")
        List<Map<String, Object>> selectStaffSex();

}
