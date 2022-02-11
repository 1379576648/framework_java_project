package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.entity.mybatisplus.InsuredDetail;
import com.trkj.framework.mybatisplus.service.InsuredDetailService;
import com.trkj.framework.util.Fuse8005Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 参保明细表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@RestController
public class InsuredDetailController {

    @Autowired
    private InsuredDetailService insuredDetailServicel;
    
    @Autowired
    private Fuse8005Util fuse8005Util;

    /****
     * 分页查询参保明细
     * @param insuredDetail
     * @return
     */
    @PostMapping("/selectPageIsuredDetail")
    @HystrixCommand(fallbackMethod = "selectPageIsuredDetailHystrix")
    public Map<String,Object> selectPageIsuredDetail(@RequestBody InsuredDetail insuredDetail){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.selectPageIsuredDetail(insuredDetail));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectPageIsuredDetailHystrix(@RequestBody InsuredDetail insuredDetail){
         return fuse8005Util.main();
    }

    /***
     * 多选删除参保
     * @param insuredDetail
     * @return
     */
    @DeleteMapping("/deleteInsuredDetail")
    @HystrixCommand(fallbackMethod = "deleteInsuredDetailHystrix")
    public Map<String,Object> deleteInsuredDetail(@RequestBody InsuredDetail insuredDetail){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.deleteInsuredDetail(insuredDetail));
        return map1;
    }
    //备选方案
    public Map<String,Object> deleteInsuredDetailHystrix(@RequestBody InsuredDetail insuredDetail){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 归档
     * @return
     */
    @PostMapping("/pigeonhole")
    @HystrixCommand(fallbackMethod = "pigeonholeHystrix")
    public Map<String,Object> pigeonhole(){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.pigeonhole());
        return map1;
    }

    //备选方案
    public Map<String,Object> pigeonholeHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 归档分页查询
     * @param insuredArchive
     * @return
     */
    @PostMapping("/archived")
    @HystrixCommand(fallbackMethod = "archivedHystrix")
    public Map<String,Object> archived(@RequestBody InsuredArchive insuredArchive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.archived(insuredArchive));
        return map1;
    }

    //备选方案
    public Map<String,Object> archivedHystrix(@RequestBody InsuredArchive insuredArchive){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询某一个月份的归档明细
     * @param name
     * @return
     */
    @GetMapping("/archivedInMonth/{name}")
    @HystrixCommand(fallbackMethod = "archivedInMonthHystrix")
    public Map<String,Object> archivedInMonth(@PathVariable("name") String name){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.archivedInMonth(name));
        return map1;
    }

    //备选方案
    public Map<String,Object> archivedInMonthHystrix(@PathVariable("name") String name){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 删除某一个月的归档数据
     * @param map
     * @return
     */
    @DeleteMapping("/deleteArchived")
    @HystrixCommand(fallbackMethod = "deleteArchivedHystrix")
    public Map<String,Object> deleteArchivedInName(@RequestBody Map<String,Object> map){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.deleteArchivedInName(map));
        return map1;
    }

    //备选方案
    public Map<String,Object> deleteArchivedHystrix(@RequestBody Map<String,Object> map){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 通过员工名称获取职位名称
     * @param name
     * @return
     */
    @GetMapping("/selectPostName/{name}")
    @HystrixCommand(fallbackMethod = "selectPostNameHystrix")
    public Map<String,Object> selectPostName(@PathVariable("name") String name){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.selectPostName(name));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectPostNameHystrix(@PathVariable("name") String name){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 通过明细编号查询
     * @param integer
     * @return
     */
    @GetMapping("/selectListScheme/{id}")
    @HystrixCommand(fallbackMethod = "selectListSchemeHystrix")
    public Map<String,Object> selectListScheme(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.selectListScheme(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectListSchemeHystrix(@PathVariable("id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /****
     * 查询某一个员工某一个月的参保日志
     * @param name
     * @param month
     * @return
     */
    @GetMapping("/selectInsuredLog/{name}/{month}")
    @HystrixCommand(fallbackMethod = "selectInsuredLogHystrix")
    public Map<String,Object> selectInsuredLog(@PathVariable("name") String name,@PathVariable("month") String month){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredDetailServicel.selectInsuredLog(name,month));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectInsuredLogHystrix(@PathVariable("name") String name,@PathVariable("month") String month){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


}

