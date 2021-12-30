package com.trkj.framework.service.client.hire;

import com.trkj.framework.service.client.fallbackfactory.HireClientServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8008/provider", fallbackFactory = HireClientServiceFallbackfactory.class)
public interface HireClientService {

    /**
     * 查询已录用待入职的员工
     */
    @GetMapping("/selectpage")
    Object selecthirepage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize);

    /**
     * 查询已经淘汰的员工
     */
    @GetMapping("/selectabandon")
    Object selectabandon(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize);

    /**
     * 查询工作经历
     */
    @GetMapping("/selectwork")
    Object selectwork(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize);

    /**
     * 查询转正记录
     */
    @GetMapping("/selectpost")
    Object selectpost(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize);
}

