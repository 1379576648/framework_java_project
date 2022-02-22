package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.service.client.wage.WageClientService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.FixedwageVo;
import com.trkj.framework.vo.WageVo;
import com.trkj.framework.vo.WorkSchemeVo;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class WageController {

    @Autowired
    private WageClientService wageClientService = null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;
    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    public AjaxResponse selectFixedwage(@RequestBody FixedwageVo fixedwageVo){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectFixedwage(fixedwageVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    public AjaxResponse updateFixedwage(@RequestBody Fixedwagf fixedwagf){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateFixedwage(fixedwagf);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    public AjaxResponse insertSalary(@RequestBody Salary salary){
        Map<String, Object> map = (Map<String, Object>) wageClientService.insertSalary(salary);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    public AjaxResponse selectSalary(@RequestBody WageVo wageVo){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectSalary(wageVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    public AjaxResponse selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectWorkScheme(workSchemeVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    public AjaxResponse insertWorkScheme(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>) wageClientService.insertWorkScheme(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    public AjaxResponse updateWorkSchemeState(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateWorkSchemeState(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    public AjaxResponse updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>)wageClientService.updateWorkSchemeStateTwo(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除加班方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteWorkScheme/{id}")
    public AjaxResponse deleteWorkScheme(@PathVariable("id") Integer id){
        Map<String, Object> map = (Map<String, Object>) wageClientService.deleteWorkScheme(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeAll")
    public AjaxResponse selectWorkSchemeAll(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectWorkSchemeAll(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkScheme")
    public AjaxResponse updateWorkScheme(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateWorkScheme(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @PostMapping("/selectAttendandce")
    public AjaxResponse selectAttendandce(@RequestBody AttendandceVo attendandceVo){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectAttendandce(attendandceVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
