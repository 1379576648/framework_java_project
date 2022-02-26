package com.trkj.framework.service.client.wage;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.WageClientServiceFallbackfactory;
import com.trkj.framework.vo.*;
import jdk.nashorn.internal.objects.annotations.Attribute;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@FeignClient(value = "FRAMEWORK-ZUUL/8006/provider", fallbackFactory = WageClientServiceFallbackfactory.class)
public interface WageClientService {

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    Map<String,Object> selectFixedwage(@RequestBody FixedwageVo fixedwageVo);

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    Map<String,Object> updateFixedwage(@RequestBody Fixedwagf fixedwagf);

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    Map<String,Object> insertSalary(@RequestBody Salary salary);

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    Map<String,Object> selectSalary(@RequestBody WageVo wageVo);

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    Map<String,Object> selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo);

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    Map<String,Object> insertWorkScheme(@RequestBody WorkScheme workScheme);

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    Map<String,Object> updateWorkSchemeState(@RequestBody WorkScheme workScheme);

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    Map<String,Object> updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme);

    /**
     * 删除加班方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteWorkScheme/{id}")
    Map<String,Object> deleteWorkScheme(@PathVariable("id") Integer id);

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeAll")
    Map<String,Object> selectWorkSchemeAll(@RequestBody WorkScheme workScheme);

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkScheme")
    Map<String,Object> updateWorkScheme(@RequestBody WorkScheme workScheme);

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @PostMapping("/selectAttendandce")
    Map<String,Object> selectAttendandce(@RequestBody AttendandceVo attendandceVo);

    /**
     * 添加考勤扣款方案
     * @param attendandce
     * @return
     */
    @PostMapping("/insertAttendandce")
    Map<String, Object> insertAttendandce(@RequestBody Attendandce attendandce);

    /**
     * 根据id查询考勤扣款方案
     * @param attendandce
     * @return
     */
    @PostMapping("/selectAttendandceAll")
    Map<String, Object> selectAttendandceAll(@RequestBody Attendandce attendandce);

    /**
     * 修改考勤扣款方案
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandce")
    Map<String, Object> updateAttendandce(@RequestBody Attendandce attendandce);

    /**
     * 删除考勤扣款方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAttendandce/{id}")
    Map<String,Object> deleteAttendandce(@PathVariable("id") Integer id);

    /**
     * 修改状态为禁用
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceState")
    Map<String, Object> updateAttendandceState(@RequestBody Attendandce attendandce);

    /**
     * 修改状态为启用
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceStateTwo")
    Map<String, Object> updateAttendandceStateTwo(@RequestBody Attendandce attendandce);

    /**
     * 查询出差方案
     * @param businessVo
     * @return
     */
    @PostMapping("/selectBusiness")
    Map<String,Object> selectBusiness(@RequestBody BusinessVo businessVo);

    /**
     * 添加出差方案
     * @param business
     * @return
     */
    @PostMapping("/insertBusiness")
    Map<String, Object> insertBusiness(@RequestBody Business business);

    /**
     * 根据id查询出差方案
     * @param business
     * @return
     */
    @PostMapping("/selectBusinessAll")
    Map<String, Object> selectBusinessAll(@RequestBody Business business);

    /**
     * 修改出差方案
     * @param business
     * @return
     */
    @PutMapping("/updateBusiness")
    Map<String, Object> updateBusiness(@RequestBody Business business);

    /**
     * 删除出差方案
     * @param id
     * @return
     */
    @DeleteMapping("/deleteBusiness/{id}")
    Map<String,Object> deleteBusiness(@PathVariable("id") Integer id);

    /**
     * 修改状态为禁用
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessState")
    Map<String, Object> updateBusinessState(@RequestBody Business business);

    /**
     * 修改状态为启用
     * @param business
     * @return
     */
    @PutMapping("/updateBusinessStateTwo")
    Map<String, Object> updateBusinessStateTwo(@RequestBody Business business);

    /**
     * 查询工资表
     * @param staff
     * @return
     */
    @PostMapping("/selectWage")
    Map<String, Object> selectWage(@RequestBody Staff staff);

    /**
     * 统计工资表
     * @param staff
     * @return
     */
    @PostMapping("/countWage")
    Map<String, Object> countWage(@RequestBody Staff staff);
}
