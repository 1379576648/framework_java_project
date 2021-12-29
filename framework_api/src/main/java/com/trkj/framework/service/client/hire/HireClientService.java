package com.trkj.framework.service.client.hire;

import com.trkj.framework.service.client.fallbackfactory.HireClientServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8008/provider", fallbackFactory = HireClientServiceFallbackfactory.class)
public interface HireClientService {

    @GetMapping("/selectpage")
    Object selecthirepage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize);
}

