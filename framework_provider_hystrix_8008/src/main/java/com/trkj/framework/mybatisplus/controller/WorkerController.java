package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.mybatisplus.service.WorkerService;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    @PostMapping("/insertWorker")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object insertWorker(@RequestBody FullVo fullVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",workerService.insertWorker(fullVo));
        return map1;
    }
    //备选方案
    public Object HystixGet(@RequestBody FullVo fullVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


}
