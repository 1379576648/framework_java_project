package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.mybatisplus.service.InsuredArchiveService;
import com.trkj.framework.util.Fuse8005Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 参保归档表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@RestController
public class InsuredArchiveController {

    @Autowired
    private InsuredArchiveService insuredArchiveService;
    @Autowired
    private Fuse8005Util fuse8005Util;
    /****
     * 分页查询参保归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/pageSelectInsuredArchive")
    @HystrixCommand(fallbackMethod = "pageSelectInsuredArchiveHystrix")
    public Object pageSelectInsuredArchive(@RequestBody InsuredArchive insuredArchive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredArchiveService.pageSelectInsuredArchive(insuredArchive));
        return map1;
    }

    //备选方案
    public Object pageSelectInsuredArchiveHystrix(@RequestBody InsuredArchive insuredArchive){
        return fuse8005Util.main();
    }
    /****
     * 通过计薪月份查询归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/selectListInsuredArchive")
    @HystrixCommand(fallbackMethod = "selectListInsuredArchiveHystrix")
    public Object selectListInsuredArchive(@RequestBody InsuredArchive insuredArchive){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", insuredArchiveService.selectListInsuredArchive(insuredArchive));
        return map1;
    }
    //备选方案
    public Object selectListInsuredArchiveHystrix(@RequestBody InsuredArchive insuredArchive){
        return fuse8005Util.main();
    }


}

