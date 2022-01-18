package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.mybatisplus.Education;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.mapper.EducationMapper;
import com.trkj.framework.mybatisplus.mapper.PunishMapper;
import com.trkj.framework.mybatisplus.service.EducationService;
import com.trkj.framework.mybatisplus.service.PunishService;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 惩罚表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationMapper educationMapper;


    /**
     * 根据教育经历id查询教育经历
     * @param workVo
     * @return
     */
    @Override
    public List<WorkVo> selectEducationOne(WorkVo workVo) {
        QueryWrapper<WorkVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("EDUCATION_ID",workVo.getEducationId());
        return educationMapper.selectEducationOne(queryWrapper);
    }

    /**
     * 添加教育经历
     * @param education
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertEducation(Education education) {
        return educationMapper.insert(education);
    }

    /**
     * 修改教育经历
     * @param education
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateEducation(Education education) {
        final var i = educationMapper.updateById(education);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 删除教育经历
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteEducation(ArrayList<Integer> list) {
        String s = "成功";
        for(int i =0;i<list.size();i++){
            //通过惩罚编号删除惩罚
            if(educationMapper.delete(new QueryWrapper<Education>().eq("EDUCATION_ID",list.get(i)))<=0){
                return "删除教育经历失败";
            }else if(educationMapper.delete(new QueryWrapper<Education>().eq("EDUCATION_ID",list.get(i)))>=1){
                return "删除教育经历成功";
            }
        }
        return s;
    }
}
