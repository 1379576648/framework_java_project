package com.trkj.framework.service.client.wage;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.service.client.fallbackfactory.WageClientServiceFallbackfactory;
import com.trkj.framework.vo.FixedwageVo;
import com.trkj.framework.vo.WageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
