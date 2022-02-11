package com.trkj.framework.service.client.social;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.SocialClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.StatisticsClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /****
     * 分页查询参保明细
     * @param insuredDetail
     * @return
     */
    @PostMapping("/selectPageIsuredDetail")
    public Object selectPageIsuredDetail(@RequestBody InsuredDetail insuredDetail);


    /***
     * 多选删除参保
     * @param insuredDetail
     * @return
     */
    @DeleteMapping("/deleteInsuredDetail/{name}")
    public Object deleteInsuredDetail(@RequestBody InsuredDetail insuredDetail);

    /**
     * 归档
     * @return
     */
    @PostMapping("/pigeonhole")
    public Object pigeonhole();

    /***
     * 归档分页查询
     * @param insuredArchive
     * @return
     */
    @PostMapping("/archived")
    public Object archived(@RequestBody InsuredArchive insuredArchive);


    /***
     * 查询某一个月份的归档明细
     * @param name
     * @return
     */
    @GetMapping("/archivedInMonth/{name}")
    public Object archivedInMonth(@PathVariable("name") String name);

    /***
     * 删除某一个月的归档数据
     * @param map
     * @return
     */
    @DeleteMapping("/deleteArchived")
    public Object deleteArchivedInName(@RequestBody Map<String,Object> map);

    /***
     * 通过员工名称获取职位名称
     * @param name
     * @return
     */
    @GetMapping("/selectPostName/{name}")
    public Object selectPostName(@PathVariable("name") String name);

    /***
     * 通过明细编号查询
     * @param integer
     * @return
     */
    @GetMapping("/selectListScheme/{id}")
    public Object selectListScheme(@PathVariable("id") Integer integer);

    /****
     * 查询某一个员工某一个月的参保日志
     * @param name
     * @param month
     * @return
     */
    @GetMapping("/selectInsuredLog/{name}/{month}")
    public Object selectInsuredLog(@PathVariable("name") String name ,@PathVariable("month") String month);

    /***
     * 分页查询参保归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/pageSelectInsuredArchive")
    public Object pageSelectInsuredArchive(@RequestBody InsuredArchive insuredArchive);


    /****
     * 通过计薪月份查询归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/selectListInsuredArchive")
    public Object selectListInsuredArchive(@RequestBody InsuredArchive insuredArchive);
}
