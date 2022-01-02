package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 审批主表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@Service
public class AuditflowServiceImpl implements AuditflowService {
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;


    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectAuditflowoneAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "加班");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEnddAuditflow(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "加班");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param auditflowDetailsVo
     * @return
     */
    @Override
    public List<AuditflowDetailsVo> selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo) {
        QueryWrapper<AuditflowDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", auditflowDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", auditflowDetailsVo.getAuditflowId());
        queryWrapper.eq("o.STAFF_NAME", auditflowDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsAuditflow(queryWrapper);
    }

    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateApprovalState(Auditflowdetail auditflowdetail) {
        final var i = auditflowdetailMapper.updateById(auditflowdetail);
        if (i == 1) {
            final var auditflowdetailId2 = auditflowdetail.getAuditflowdetailId2();
            QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
            final var i1 = auditflowdetailMapper.updateApprovalState(queryWrapper);
            return i1;
        } else {
            return 999;
        }
    }

    /**
     * 根据审批明细表ID修改其状态 驳回
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int rejectApprovalState(Auditflowdetail auditflowdetail) {
        final var i = auditflowdetailMapper.updateById(auditflowdetail);
        if (i == 1) {
            final var auditflowdetailId2 = auditflowdetail.getAuditflowdetailId2();
            QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
            final var i1 = auditflowdetailMapper.rejectApprovalState(queryWrapper);
            if (i1 == 1) {
                final var auditflowdetailId3 = auditflowdetail.getAuditflowdetailId3();
                QueryWrapper<Auditflowdetail> queryWrapper1 = new QueryWrapper<>();
                queryWrapper1.eq("auditflowdetail_Id", auditflowdetailId3);
                final var i2 = auditflowdetailMapper.rejectApprovalState2(queryWrapper1);
                if (i2 == 1) {
                    final var auditflowId = auditflowdetail.getAuditflowId();
                    System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111");
                    System.out.println(auditflowId);
                    System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111");
                    QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("auditflow_Id", auditflowId);
                    final var i3 = auditflowMapper.rejectApprovalState(queryWrapper2);
                    return i3;
                } else {
                    return 999;
                }
            } else {
                return 999;
            }
        } else {
            return 999;
        }
    }

    /**
     * 根据审批编号查询对应的审批明细表编号 部门经理
     *
     * @param auditflowdetail
     * @return
     */
    @Override
    public List<Auditflowdetail> queryDetail(Auditflowdetail auditflowdetail) {
        QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("AUDITFLOW_ID", auditflowdetail.getAuditflowId());
        queryWrapper.ne("AUDITFLOWDETAI_STATE", 2);
        queryWrapper.ne("AUDITFLOWDETAI_STATE", 3);
        return auditflowdetailMapper.selectListAuditflow(queryWrapper);
    }
}
