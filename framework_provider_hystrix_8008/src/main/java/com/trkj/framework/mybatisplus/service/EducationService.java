package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.Education;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.vo.WorkVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 受教育经历表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
public interface EducationService {

    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    List<WorkVo> selectEducationOne(WorkVo workVo);

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    int insertEducation(Education education);

    /**
     * 修改教育经历
     * @param education
     * @return
     */
    int updateEducation(Education education);

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    String deleteEducation(ArrayList<Integer> list);


}
