package com.trkj.framework.service.client.examine;

import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8003/provider", fallbackFactory = AuditflowClinetServiceFallbackfactory.class)
public interface AuditflowService {

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param currentPage
     * @param pagesize
     * @return
     */
    @GetMapping("/selectAuditflow")
    Object queryemp(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize);

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param currentPage
     * @param pagesize
     * @return
     */
    @GetMapping("/selectEndAuditflow")
    Object queryemp1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize);
}
