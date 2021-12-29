package com.trkj.framework.service.client.examine;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8003/provider", fallbackFactory = AuditflowClinetServiceFallbackfactory.class)
public interface AuditflowService {

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectAuditflow")
    Object selectAuditflowoneAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    Object selectEnddAuditflow(@RequestBody Auditflowone auditflowone);
}
