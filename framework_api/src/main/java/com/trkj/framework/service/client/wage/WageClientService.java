package com.trkj.framework.service.client.wage;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.service.client.fallbackfactory.WageClientServiceFallbackfactory;
import com.trkj.framework.vo.FixedwageVo;
import com.trkj.framework.vo.WageVo;
import com.trkj.framework.vo.WorkSchemeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@FeignClient(value = "FRAMEWORK-ZUUL/8006/provider", fallbackFactory = WageClientServiceFallbackfactory.class)
public interface WageClientService {

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    Object selectFixedwage(@RequestBody FixedwageVo fixedwageVo);

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    Object updateFixedwage(@RequestBody Fixedwagf fixedwagf);

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    Object insertSalary(@RequestBody Salary salary);

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    Object selectSalary(@RequestBody WageVo wageVo);

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    Object selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo);

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    Object insertWorkScheme(@RequestBody WorkScheme workScheme);

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    Object updateWorkSchemeState(@RequestBody WorkScheme workScheme);

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    Object updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme);

    /**
     * 删除加班方案
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWorkScheme")
    Object deleteWorkScheme(@RequestBody ArrayList<Integer> list);

    /**
     * 根据id查询加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/selectWorkSchemeAll")
    Object selectWorkSchemeAll(@RequestBody WorkScheme workScheme);

    /**
     * 修改加班方案
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkScheme")
    Object updateWorkScheme(@RequestBody WorkScheme workScheme);
}
