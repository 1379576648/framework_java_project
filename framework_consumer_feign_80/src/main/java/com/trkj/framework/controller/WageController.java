package com.trkj.framework.controller;

import com.sun.jersey.core.spi.scanning.uri.BundleSchemeScanner;
import com.trkj.framework.entity.mybatisplus.*;
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

    /**
     * 添加考勤扣款方案
     * @param attendandce
     * @return
     */
    @PostMapping("/insertAttendandce")
    public AjaxResponse insertAttendandce(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.insertAttendandce(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询考勤扣款方案
     * @param attendandce
     * @return
     */
    @PostMapping("/selectAttendandceAll")
    public AjaxResponse selectAttendandceAll(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectAttendandceAll(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改考勤扣款方案
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandce")
    public AjaxResponse updateAttendandce(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateAttendandce(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除考勤扣款方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAttendandce/{id}")
    public AjaxResponse deleteAttendandce(@PathVariable("id") Integer id){
        Map<String, Object> map = (Map<String, Object>) wageClientService.deleteAttendandce(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为禁用
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceState")
    public AjaxResponse updateAttendandceState(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateAttendandceState(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为启用
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceStateTwo")
    public AjaxResponse updateAttendandceStateTwo(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateAttendandceStateTwo(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询出差方案
     * @param businessVo
     * @return
     */
    @PostMapping("/selectBusiness")
    public AjaxResponse selectBusiness(@RequestBody BusinessVo businessVo){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectBusiness(businessVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加出差方案
     * @param business
     * @return
     */
    @PostMapping("/insertBusiness")
    public AjaxResponse insertBusiness(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.insertBusiness(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据id查询出差方案
     * @param business
     * @return
     */
    @PostMapping("/selectBusinessAll")
    public AjaxResponse selectBusinessAll(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectBusinessAll(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改出差方案
     * @param business
     * @return
     */
    @PutMapping("/updateBusiness")
    public AjaxResponse updateBusiness(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateBusiness(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 删除出差方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteBusiness/{id}")
    public AjaxResponse deleteBusiness(@PathVariable("id") Integer id){
        Map<String, Object> map = (Map<String, Object>) wageClientService.deleteBusiness(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为禁用
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessState")
    public AjaxResponse updateBusinessState(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateBusinessState(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为启用
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessStateTwo")
    public AjaxResponse updateBusinessStateTwo(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateBusinessStateTwo(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询工资表
     * @param staff
     * @return
     */
    @PostMapping("/selectWage")
    public AjaxResponse selectWage(@RequestBody Staff staff){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectWage(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计工资表
     * @param staff
     * @return
     */
    @PostMapping("/countWage")
    public AjaxResponse countWage(@RequestBody Staff staff){
        Map<String, Object> map =  (Map<String, Object>) wageClientService.countWage(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/selectMoney")
    public AjaxResponse selectMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectMoney(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计未归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/countMoney")
    public AjaxResponse countMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.countMoney(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/selectMoneys")
    public AjaxResponse selectMoneys(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectMoneys(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 统计已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    @PostMapping("/countMoneys")
    public AjaxResponse countMoneys(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.countMoneys(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 修改状态为已归档
     * @param moneyPigeonhole
     * @return
     */
    @PutMapping("/updateMoney")
    public AjaxResponse updateMoney(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.updateMoney(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门名称查询有无方案
     * @param business
     * @return
     */
    @PostMapping("/selectBusinessBydept")
    public AjaxResponse selectBusinessBydept(@RequestBody Business business){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectBusinessBydept(business);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门名称查询有无方案
     * @param attendandce
     * @return
     */
    @PostMapping("/selectAttendandceBydept")
    public AjaxResponse selectAttendandceBydept(@RequestBody Attendandce attendandce){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectAttendandceBydept(attendandce);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门名称查询是否有方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeBydept")
    public AjaxResponse selectWorkSchemeBydept(@RequestBody WorkScheme workScheme){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectWorkSchemeBydept(workScheme);
        return AjaxResponse.success(carryTokenUtil.main(map));
     }

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
     @PostMapping("/selectstatcis")
     public AjaxResponse selectstatcis(@RequestBody MoneyPigeonhole moneyPigeonhole){
        Map<String, Object> map = (Map<String, Object>) wageClientService.selectstatcis(moneyPigeonhole);
        return AjaxResponse.success(carryTokenUtil.main(map));
     }

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
     @PostMapping("/selectstatc")
     public AjaxResponse selectstatc(@RequestBody MoneyPigeonhole moneyPigeonhole){
         Map<String, Object> map = (Map<String, Object>) wageClientService.selectstatc(moneyPigeonhole);
         return AjaxResponse.success(carryTokenUtil.main(map));
     }

    /**
     * 本月调薪
     * @return
     */
    @PostMapping("/counttx")
    public AjaxResponse counttx(){
         Map<String, Object> map = (Map<String, Object>) wageClientService.counttx();
         return AjaxResponse.success(carryTokenUtil.main(map));
     }
}
