package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.mapper.WorkExperienceMapper;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertWorkExperience(WorkExperience workExperience) {
        return workExperienceMapper.insert(workExperience);
    }

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWork(WorkExperience workExperience) {
        final var i = workExperienceMapper.updateById(workExperience);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }

    /**
     * 删除工作经历
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteWork(ArrayList<Integer> list) {
       String s = "成功";
       for(int i =0;i<list.size();i++){
           //通过工作经历编号删除工作经历
           if(workExperienceMapper.delete(new QueryWrapper<WorkExperience>().eq("WORK_EXPERIENCE_ID",list.get(i)))<=0){
               return "删除工作经历失败";
           }else if(workExperienceMapper.delete(new QueryWrapper<WorkExperience>().eq("WORK_EXPERIENCE_ID",list.get(i)))>=1){
               return "删除工作经历成功";
           }
       }
       return s;
    }
}
