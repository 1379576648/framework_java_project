package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.service.client.wage.WageClientService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.FixedwageVo;
import com.trkj.framework.vo.WageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WageController {

    @Autowired
    private WageClientService wageClientService = null;

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    public AjaxResponse selectFixedwage(@RequestBody FixedwageVo fixedwageVo){
        return AjaxResponse.success(wageClientService.selectFixedwage(fixedwageVo));
    }

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    public AjaxResponse updateFixedwage(@RequestBody Fixedwagf fixedwagf){
        return AjaxResponse.success(wageClientService.updateFixedwage(fixedwagf));
    }

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    public AjaxResponse insertSalary(@RequestBody Salary salary){
        return AjaxResponse.success(wageClientService.insertSalary(salary));
    }

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    public AjaxResponse selectSalary(@RequestBody WageVo wageVo){
        return AjaxResponse.success(wageClientService.selectSalary(wageVo));
    }
}
