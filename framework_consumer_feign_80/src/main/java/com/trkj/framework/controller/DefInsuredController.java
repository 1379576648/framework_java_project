package com.trkj.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.DefScheme;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.social.SocialClinetService;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/social")
public class DefInsuredController {

    /**
     * 分页查询社保方案
     */
    @Autowired
    private SocialClinetService socialClinetService=null;
    @PostMapping("/selectDefInsured")
    public AjaxResponse selectDefInsured(@RequestBody DefInsured defInsured){
        return AjaxResponse.success(socialClinetService.selectDefInsured(defInsured));
    }

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @DeleteMapping("/deleteDefInsured/{id}")
    public AjaxResponse deleteDefInsured(@PathVariable("id") Integer integer){
        return AjaxResponse.success(socialClinetService.deleteDefInsured(integer));
    }

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @PutMapping("/updateDefInsuredState/{id}")
    public AjaxResponse updateDefInsuredState(@PathVariable("id") Integer integer){
        return AjaxResponse.success(socialClinetService.updateDefInsuredState(integer));
    }


    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @GetMapping("/selectDefInsuredId/{id}")
    public AjaxResponse selectDefInsuredId(@PathVariable("id") Integer integer){
        return AjaxResponse.success(socialClinetService.selectDefInsuredId(integer));
    }

    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    @GetMapping("/listSelectDefScheme/{id}")
    public AjaxResponse listSelectDefScheme(@PathVariable("id") Integer integer){
        return AjaxResponse.success(socialClinetService.listSelectDefScheme(integer));
    }

    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    @PostMapping("/addDefInsured")
    public  AjaxResponse  addDefInsured(@RequestBody Map<String,Object> objectMap){
        return AjaxResponse.success(socialClinetService.addDefInsured(objectMap));
    }

    /***
     * 修改社保方案
     * @param objectMap
     * @return
     */
    @PutMapping("/updateDefInsured")
    public  AjaxResponse  updateDefInsured(@RequestBody Map<String,Object> objectMap){
        return AjaxResponse.success(socialClinetService.updateDefInsured(objectMap));
    }

    /***
     * 查询方案名称
     * @param name
     * @return
     */
    @GetMapping("/selectDefInsuredName/{name}")
    public AjaxResponse selectDefInsuredName(@PathVariable("name") String name){
        return AjaxResponse.success(socialClinetService.selectDefInsuredName(name));
    }

    /***
     * 查询所有的社保方案
     * @return
     */
    @GetMapping("/selectDefInsuredListName")
    public AjaxResponse selectDefInsuredListName(){
        return AjaxResponse.success(socialClinetService.selectDefInsuredListName());
    }

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @PostMapping("/pageStaff")
    public AjaxResponse pageStaff(@RequestBody Staff staff){
        return AjaxResponse.success(socialClinetService.pageStaff(staff));
    }

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/deptList")
    public AjaxResponse deptList(){
        return AjaxResponse.success(socialClinetService.deptList());
    }


    /***
     * 参保提交
     * @param map
     * @return
     */
    @PostMapping("/insuredSubmit")
    public AjaxResponse insuredSubmit(@RequestBody Map<String,Object> map){
        return AjaxResponse.success(socialClinetService.insuredSubmit(map));
    }
}
