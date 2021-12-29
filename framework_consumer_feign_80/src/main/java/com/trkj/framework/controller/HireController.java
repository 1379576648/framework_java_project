package com.trkj.framework.controller;

import com.trkj.framework.service.client.hire.HireClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HireController {
    @Autowired
    private HireClientService hireClientService =null;

    /**
     *
     * @param currentPage
     * @param pagesize
     * @return
     */
    @GetMapping("/selectpage")
    public Object selecthirepage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        return hireClientService.selecthirepage(currentPage,pagesize);
    }


}
