
package com.trkj.framework.mybatisplus.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.vo.WageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 调薪 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object insertSalary(@RequestBody Salary salary){
        return salaryService.insertSalary(salary);
    }

    //备选方案
    public Object HystixGet(@RequestBody Salary salary){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectSalary(@RequestBody WageVo wageVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",salaryService.selectSalary(wageVo));
        return map1;
    }

    //备选方案
    public Object HystixGet2(@RequestBody WageVo wageVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}
