
package com.trkj.framework.mybatisplus.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.util.Fuse8006Util;
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
    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @PostMapping("/insertSalary")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public  Map<String, Object> insertSalary(@RequestBody Salary salary){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",salaryService.insertSalary(salary));
        return map1;
    }

    //备选方案
    public  Map<String, Object> hystixGet(@RequestBody Salary salary){
        return fuse8006Util.main();
    }

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @PostMapping("/selectSalary")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public  Map<String, Object> selectSalary(@RequestBody WageVo wageVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",salaryService.selectSalary(wageVo));
        return map1;
    }

    //备选方案
    public  Map<String, Object> hystixGet2(@RequestBody WageVo wageVo){
        return fuse8006Util.main();
    }

    /**
     * 本月调薪
     * @return
     */
    @PostMapping("/counttx")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> counttx() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", salaryService.counttx());
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet3() {
        return fuse8006Util.main();
    }

}
