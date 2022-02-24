package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.DefInsuredService;
import com.trkj.framework.util.Fuse8005Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
    @Autowired
    private Fuse8005Util fuse8005Util;

    /***
     * 分页查询社保方案
     * @param defInsured
     * @return
     */
    @PostMapping("/selectDefInsured")
    @HystrixCommand(fallbackMethod = "selectDefInsuredHystrix")
    public Map<String,Object> selectDefInsured(@RequestBody DefInsured defInsured){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsured(defInsured));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectDefInsuredHystrix(@RequestBody DefInsured defInsured){
       return fuse8005Util.main();
    }

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @DeleteMapping("/deleteDefInsured/{id}")
    @HystrixCommand(fallbackMethod = "deleteDefInsuredHystrix")
    public Map<String,Object> deleteDefInsured(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.deleteDefInsured(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> deleteDefInsuredHystrix(@PathVariable("id") Integer integer){
       return fuse8005Util.main();
    }

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @PutMapping("/updateDefInsuredState/{id}")
    @HystrixCommand(fallbackMethod = "updateDefInsuredStateHystrix")
    public Map<String,Object> updateDefInsuredState(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.updateDefInsuredState(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> updateDefInsuredStateHystrix(@PathVariable("id") Integer integer){
       return fuse8005Util.main();
    }

    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @GetMapping("/selectDefInsuredId/{id}")
    @ApiOperation(value = "添加部门，成功后进入show页面，显示部门信息", notes = "查询", httpMethod = "GET")
    @HystrixCommand(fallbackMethod = "selectDefInsuredIdHystrix")
    public Map<String,Object> selectDefInsuredId(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsuredId(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectDefInsuredIdHystrix(@PathVariable("id") Integer integer){
       return fuse8005Util.main();
    }

    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    @GetMapping("/listSelectDefScheme/{id}")
    @HystrixCommand(fallbackMethod = "listSelectDefSchemeHystrix")
    public Map<String,Object> listSelectDefScheme(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.listSelectDefScheme(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> listSelectDefSchemeHystrix(@PathVariable("id") Integer integer){
       return fuse8005Util.main();
    }

    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    @PostMapping("/addDefInsured")
    @HystrixCommand(fallbackMethod = "addDefInsuredHystrix")
    public Map<String,Object> addDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", defInsuredService.addDefInsured(objectMap));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> addDefInsuredHystrix(@RequestBody Map<String,Object> objectMap){
       return fuse8005Util.main();
    }


    /***
     * 修改社保方案
     * @param objectMap
     * @return
     */
    @PutMapping("/updateDefInsured")
    @HystrixCommand(fallbackMethod = "updateDefInsuredHystrix")
    public Map<String,Object> updateDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", defInsuredService.updateDefInsured(objectMap));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> updateDefInsuredHystrix(@RequestBody Map<String,Object> objectMap){
       return fuse8005Util.main();
    }

    /***
     * 查询方案名称
     * @param name
     * @return
     */
    @GetMapping("/selectDefInsuredName/{name}")
    @HystrixCommand(fallbackMethod = "selectDefInsuredNameHystrix")
    public Map<String,Object> selectDefInsuredName(@PathVariable("name") String name){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.selectDefInsuredName(name));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectDefInsuredNameHystrix(@PathVariable("name") String name){
       return fuse8005Util.main();
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
    public Map<String,Object> selectDefInsuredListNameHystrix(){
       return fuse8005Util.main();
    }

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @PostMapping("/pageStaff")
    @HystrixCommand(fallbackMethod = "pageStaffHystrix")
    public Map<String,Object> pageStaff(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.pageStaff(staff));
        return map1;
    }
    //备选方案
    public Map<String,Object> pageStaffHystrix(@RequestBody Staff staff){
       return fuse8005Util.main();
    }

    /***
     * 查询所有的部门信息
     * @return
     */
    @GetMapping("/deptList")
    @HystrixCommand(fallbackMethod = "deptListHystrix")
    public Map<String,Object> deptList(){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", defInsuredService.deptList());
        return map1;
    }

    //备选方案
    public Map<String,Object> deptListHystrix(){
       return fuse8005Util.main();
    }

    /***
     * 参保提交
     * @param map
     * @return
     */
    @PostMapping("/insuredSubmit")
    @HystrixCommand(fallbackMethod = "insuredSubmitHystrix")
    public Map<String,Object> insuredSubmit(@RequestBody Map<String,Object> map){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try{
            map1.put("info", defInsuredService.insuredSubmit(map));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> insuredSubmitHystrix(Map<String,Object> map){
       return fuse8005Util.main();
    }
}

