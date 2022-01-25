package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.DefScheme;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.DefInsuredService;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-19
 */
@RestController
public class DefInsuredController {


    @Autowired
    private DefInsuredService defInsuredService;

    /***
     * 分页查询社保方案
     * @param defInsured
     * @return
     */
    @PostMapping("/selectDefInsured")
    @HystrixCommand(fallbackMethod = "selectDefInsuredHystrix")
    public Object selectDefInsured(@RequestBody DefInsured defInsured){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsured(defInsured));
        return map1;
    }

    //备选方案
    public Object selectDefInsuredHystrix(@RequestBody DefInsured defInsured){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @DeleteMapping("/deleteDefInsured/{id}")
    @HystrixCommand(fallbackMethod = "deleteDefInsuredHystrix")
    public Object deleteDefInsured(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.deleteDefInsured(integer));
        return map1;
    }

    //备选方案
    public Object deleteDefInsuredHystrix(@PathVariable("id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @PutMapping("/updateDefInsuredState/{id}")
    @HystrixCommand(fallbackMethod = "updateDefInsuredStateHystrix")
    public Object updateDefInsuredState(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.updateDefInsuredState(integer));
        return map1;
    }

    //备选方案
    public Object updateDefInsuredStateHystrix(@PathVariable("id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @GetMapping("/selectDefInsuredId/{id}")
    @HystrixCommand(fallbackMethod = "selectDefInsuredIdHystrix")
    public Object selectDefInsuredId(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsuredId(integer));
        return map1;
    }

    //备选方案
    public Object selectDefInsuredIdHystrix(@PathVariable("id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    @GetMapping("/listSelectDefScheme/{id}")
    @HystrixCommand(fallbackMethod = "listSelectDefSchemeHystrix")
    public Object listSelectDefScheme(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.listSelectDefScheme(integer));
        return map1;
    }

    //备选方案
    public Object listSelectDefSchemeHystrix(@PathVariable("id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    @PostMapping("/addDefInsured")
    @HystrixCommand(fallbackMethod = "addDefInsuredHystrix")
    public Object addDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.addDefInsured(objectMap));
        return map1;
    }

    //备选方案
    public Object addDefInsuredHystrix(@RequestBody Map<String,Object> objectMap){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }


    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    @PutMapping("/updateDefInsured")
    @HystrixCommand(fallbackMethod = "updateDefInsuredHystrix")
    public Object updateDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.updateDefInsured(objectMap));
        return map1;
    }

    //备选方案
    public Object updateDefInsuredHystrix(@RequestBody Map<String,Object> objectMap){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 查询方案名称
     * @param name
     * @return
     */
    @GetMapping("/selectDefInsuredName/{name}")
    @HystrixCommand(fallbackMethod = "selectDefInsuredNameHystrix")
    public Object selectDefInsuredName(@PathVariable("name") String name){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsuredName(name));
        return map1;
    }

    //备选方案
    public Object selectDefInsuredNameHystrix(@PathVariable("name") String name){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 查询所有的社保方案
     * @return
     */
    @GetMapping("/selectDefInsuredListName")
    @HystrixCommand(fallbackMethod = "selectDefInsuredListNameHystrix")
    public  Object selectDefInsuredListName(){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsuredListName());
        return map1;
    }

    //备选方案
    public Object selectDefInsuredListNameHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @PostMapping("/pageStaff")
    @HystrixCommand(fallbackMethod = "pageStaffHystrix")
    public Object pageStaff(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.pageStaff(staff));
        return map1;
    }
    //备选方案
    public Object pageStaffHystrix(@RequestBody Staff staff){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    @GetMapping("/deptList")
    @HystrixCommand(fallbackMethod = "deptListHystrix")
    public Object deptList(){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.deptList());
        return map1;
    }

    //备选方案
    public Object deptListHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 参保提交
     * @param map
     * @return
     */
    @PostMapping("/insuredSubmit")
    @HystrixCommand(fallbackMethod = "insuredSubmitHystrix")
    public Object insuredSubmit(@RequestBody Map<String,Object> map){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.insuredSubmit(map));
        return map1;
    }

    //备选方案
    public Object insuredSubmitHystrix(Map<String,Object> map){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}

