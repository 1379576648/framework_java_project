package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.mybatisplus.mapper.ResumeMapper;
import com.trkj.framework.mybatisplus.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 牛蛙
 * @since 2021-12-23
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, ResumeVo> implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    /**
     * 新简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectPageVo(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",0);
        return resumeMapper.selectPageVo(page,queryWrapper);
    }

    /**
     * 全部简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectAll(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNotNull("RESUME_ZT");
        return resumeMapper.selectAll(page,queryWrapper);
    }
    /**
     * 候选人简历查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectCandidate(ResumeVo resumeVo) {
        Page<ResumeVo> page=new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",1);
        return resumeMapper.selectCandidate(page,queryWrapper);
    }
    /**
     * 淘汰库查询
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectEliminate(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",2);
        return resumeMapper.selectEliminate(page,queryWrapper);
    }
    /**
     * 面试候选人
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectInterviewCandidate(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",3);
        return resumeMapper.selectInterviewCandidate(page,queryWrapper);
    }
    /**
     * 已邀约
     * @param
     * @return
     */
    @Override
    public IPage<ResumeVo> selectInvite(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrentPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("RESUME_ZT",4);
        return resumeMapper.selectInvite(page,queryWrapper);
    }

    @Override
    public String addResume(ResumeVo resume) {
        int insert = resumeMapper.insert(resume);
        if (insert <= 0){
            return "添加失败";
        }
        return "成功";
    }
}
