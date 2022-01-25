package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.TravelMapper;
import com.trkj.framework.mybatisplus.service.TraveService;
import com.trkj.framework.vo.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TraveServicelmpl implements TraveService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private TravelMapper travelMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectTravelAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //根据申请人名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "出差");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEndTravelAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //用户名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        // eq 等于 ne 不等于
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 0);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "出差");
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @Override
    public List<TravelDetailsVo> selectDetailsTrave(TravelDetailsVo travelDetailsVo) {
        QueryWrapper<TravelDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", travelDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", travelDetailsVo.getAuditflowId());
        queryWrapper.eq("t.STAFF_NAME", travelDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsTrave(queryWrapper);
    }

    @Override
    public List<TravelDetailsVo> selectEvectionExamine(TravelDetailsVo travelDetailsVo) {
        QueryWrapper<TravelDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", travelDetailsVo.getStaffName1());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = travelMapper.selectEvectionExamine(queryWrapper);
        return i;
    }


    /**
     * 添加出差 添加三个审批人
     *
     * @param travelVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToTravel3(TravelVo travelVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(travelVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(travelVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(travelVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", travelVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", travelVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(travelVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(travelVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(travelVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加出差表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Travel travel = new Travel();
                // 出差表-审批编号
                travel.setAuditflowId(auditflow1.getAuditflowId());
                // 出差表-员工名称
                travel.setStaffName(travelVo.getStaffName());
                // 出差表-部门名称
                travel.setDeptName(travelVo.getDeptName());
                // 出差表-出差地点
                travel.setTravelPlace(travelVo.getTravelPlace());
                // 出差表-出差事由
                travel.setTravelMatter(travelVo.getTravelMatter());
                // 出差表-出差开始时间
                travel.setTravelSDate(travelVo.getTravelSDate());
                // 出差表-出差结束时间
                travel.setTravelEDate(travelVo.getTravelEDate());
                // 出差表-出差总时长
                travel.setTravelSDate(travelVo.getTravelTotalDate());
                final val i4 = travelMapper.insert(travel);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加出差 添加两个审批人
     *
     * @param travelVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToTravel2(TravelVo travelVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(travelVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(travelVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(travelVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", travelVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", travelVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(travelVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(travelVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 如果三个审批明细表添加成功，则添加出差表
            if (i1 == 1 && i2 == 1) {
                Travel travel = new Travel();
                // 出差表-审批编号
                travel.setAuditflowId(auditflow1.getAuditflowId());
                // 出差表-员工名称
                travel.setStaffName(travelVo.getStaffName());
                // 出差表-部门名称
                travel.setDeptName(travelVo.getDeptName());
                // 出差表-出差地点
                travel.setTravelPlace(travelVo.getTravelPlace());
                // 出差表-出差事由
                travel.setTravelMatter(travelVo.getTravelMatter());
                // 出差表-出差开始时间
                travel.setTravelSDate(travelVo.getTravelSDate());
                // 出差表-出差结束时间
                travel.setTravelEDate(travelVo.getTravelEDate());
                // 出差表-出差总时长
                travel.setTravelSDate(travelVo.getTravelTotalDate());
                final val i4 = travelMapper.insert(travel);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加出差 添加一个审批人
     *
     * @param travelVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer submitToTravel1(TravelVo travelVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(travelVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(travelVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(travelVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", travelVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", travelVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(travelVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);
            // 如果三个审批明细表添加成功，则添加出差表
            Travel travel = new Travel();
            // 出差表-审批编号
            travel.setAuditflowId(auditflow1.getAuditflowId());
            // 出差表-员工名称
            travel.setStaffName(travelVo.getStaffName());
            // 出差表-部门名称
            travel.setDeptName(travelVo.getDeptName());
            // 出差表-出差地点
            travel.setTravelPlace(travelVo.getTravelPlace());
            // 出差表-出差事由
            travel.setTravelMatter(travelVo.getTravelMatter());
            // 出差表-出差开始时间
            travel.setTravelSDate(travelVo.getTravelSDate());
            // 出差表-出差结束时间
            travel.setTravelEDate(travelVo.getTravelEDate());
            // 出差表-出差总时长
            travel.setTravelSDate(travelVo.getTravelTotalDate());
            final val i4 = travelMapper.insert(travel);
            if (i1 == 1 && i4 == 1) {
                return 1111;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
