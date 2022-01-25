package com.trkj.framework.service.client.social;

import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.DefScheme;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.fallbackfactory.SocialClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.StatisticsClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8005/provider" , fallbackFactory = SocialClinetServiceFallbackfactory.class)
public interface SocialClinetService {

    /****
     * 分页查询社保方案
     * @param defInsured
     * @return
     */
    @PostMapping("/selectDefInsured")
    public Object selectDefInsured(@RequestBody DefInsured defInsured);

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @DeleteMapping("/deleteDefInsured/{id}")
    public Object deleteDefInsured(@PathVariable("id") Integer integer);

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @PutMapping("/updateDefInsuredState/{id}")
    public Object updateDefInsuredState(@PathVariable("id") Integer integer);


    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @GetMapping("/selectDefInsuredId/{id}")
    public Object selectDefInsuredId(@PathVariable("id") Integer integer);

    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    @GetMapping("/listSelectDefScheme/{id}")
    public Object listSelectDefScheme(@PathVariable("id") Integer integer);

    /***
     * 添加社保方案
     * @param map
     * @return
     */
    @PostMapping("/addDefInsured")
    public  Object  addDefInsured(@RequestBody Map<String,Object> map);

    /***
     * 修改社保方案
     * @param map
     * @return
     */
    @PutMapping("/updateDefInsured")
    public  Object  updateDefInsured(@RequestBody Map<String,Object> map);


    /***
     * 查询社保方案名称
     * @param name
     * @return
     */
    @GetMapping("/selectDefInsuredName/{name}")
    public Object selectDefInsuredName(@PathVariable("name") String name);

    /***
     * 查询所有的社保方案
     * @return
     */
    @GetMapping("/selectDefInsuredListName")
    public Object selectDefInsuredListName();

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @PostMapping("/pageStaff")
    public Object pageStaff(@RequestBody Staff staff);

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/deptList")
    public  Object deptList();

    /***
     * 参保提交
     * @param map
     * @return
     */
    @PostMapping("/insuredSubmit")
    public Object insuredSubmit(@RequestBody Map<String,Object> map);
}
