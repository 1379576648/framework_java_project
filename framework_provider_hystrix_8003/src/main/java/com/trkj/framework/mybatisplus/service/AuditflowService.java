package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.Auditflowone;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 审批主表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
public interface AuditflowService {

    /**
     *  根据审批类型的加班/审批人查询待处理的审批
     * @param page
     * @return
     */
    IPage<Auditflowone> selectPageVo(Page<Auditflowone> page);

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     * @param page
     * @return
     */
    IPage<Auditflowone> selectPageVo1(Page<Auditflowone> page);

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     */
    List<Auditflowone> selectDetailsAuditflow(HashMap<String, Object> map);
}
