package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     *  根据审批类型的加班/审批人查询待处理的审批
     * @param page
     * @return
     */
    @Override
    public IPage<Auditflowone> selectPageVo(Page<Auditflowone> page) {
        return auditflowMapper.one(page);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     * @param page
     * @return
     */
    @Override
    public IPage<Auditflowone> selectPageVo1(Page<Auditflowone> page) {
        return auditflowMapper.two(page);
    }
}
