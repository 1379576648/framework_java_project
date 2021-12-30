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
     * 查询已录用待入职的员工
     */
    @GetMapping("/selectpage")
    public Object selecthirepage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        return hireClientService.selecthirepage(currentPage,pagesize);
    }

    /**
     * 查询已经淘汰的员工
     */

    @GetMapping("/selectabandon")
    public Object selectabandon(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        return hireClientService.selectabandon(currentPage,pagesize);

    }

    /**
     * 查询工作经历
     */
    @GetMapping("/selectwork")
    public Object selectwork(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        return hireClientService.selectwork(currentPage,pagesize);
    }

    /**
     * 查询转正记录
     */

    @GetMapping("/selectpost")
    public Object selectpost(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        return hireClientService.selectpost(currentPage,pagesize);

    }

}
