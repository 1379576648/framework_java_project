package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.service.client.wage.WageClientService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    public AjaxResponse selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo){
        return AjaxResponse.success(wageClientService.selectWorkScheme(workSchemeVo));
    }

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    public AjaxResponse insertWorkScheme(@RequestBody WorkScheme workScheme){
        return AjaxResponse.success(wageClientService.insertWorkScheme(workScheme));
    }

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    public AjaxResponse updateWorkSchemeState(@RequestBody WorkScheme workScheme){
        return AjaxResponse.success(wageClientService.updateWorkSchemeState(workScheme));
    }

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    public AjaxResponse updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme){
        return AjaxResponse.success(wageClientService.updateWorkSchemeStateTwo(workScheme));
    }

    /**
     * 删除加班方案
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWorkScheme")
    public AjaxResponse deleteWorkScheme(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(wageClientService.deleteWorkScheme(list));
    }

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeAll")
    public AjaxResponse selectWorkSchemeAll(@RequestBody WorkScheme workScheme){
        return AjaxResponse.success(wageClientService.selectWorkSchemeAll(workScheme));
    }

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkScheme")
    public AjaxResponse updateWorkScheme(@RequestBody WorkScheme workScheme){
        return AjaxResponse.success(wageClientService.updateWorkScheme(workScheme));
    }

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @PostMapping("/selectAttendandce")
    public AjaxResponse selectAttendandce(@RequestBody AttendandceVo attendandceVo){
        return AjaxResponse.success(wageClientService.selectAttendandce(attendandceVo));
    }
}
