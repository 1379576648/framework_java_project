package com.trkj.framework.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.DefScheme;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.social.SocialClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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


    @Autowired
    private SocialClinetService socialClinetService=null;

    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 分页查询社保方案
     */
    @PostMapping("/selectDefInsured")
    @ApiOperation(value = "分页查询社保方案",notes = "社保模块",httpMethod = "POST",nickname="查询",produces = "/selectDefInsured")
    public AjaxResponse selectDefInsured(@RequestBody DefInsured defInsured){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectDefInsured(defInsured);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    @DeleteMapping("/deleteDefInsured/{id}")
    @ApiOperation(value = "删除社保方案",notes = "社保模块",httpMethod = "DELETE",nickname="删除",produces = "/deleteDefInsured/{id}")
    public AjaxResponse deleteDefInsured(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.deleteDefInsured(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    @PutMapping("/updateDefInsuredState/{id}")
    @ApiOperation(value = "修改社保方案状态",notes = "社保模块",httpMethod = "PUT",nickname="修改",produces = "/updateDefInsuredState/{id}")
    public AjaxResponse updateDefInsuredState(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.updateDefInsuredState(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    @GetMapping("/selectDefInsuredId/{id}")
    @ApiOperation(value = "通过编号查询社保方案数据",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectDefInsuredId/{id}")
    public AjaxResponse selectDefInsuredId(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectDefInsuredId(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    @GetMapping("/listSelectDefScheme/{id}")
    @ApiOperation(value = "通过外键查询方案数据",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/listSelectDefScheme/{id}")
    public AjaxResponse listSelectDefScheme(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.listSelectDefScheme(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    @PostMapping("/addDefInsured")
    @ApiOperation(value = "添加社保方案",notes = "社保模块",httpMethod = "POST",nickname="添加",produces = "/addDefInsured")
    public  AjaxResponse  addDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.addDefInsured(objectMap);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 修改社保方案
     * @param objectMap
     * @return
     */
    @PutMapping("/updateDefInsured")
    @ApiOperation(value = "修改社保方案",notes = "社保模块",httpMethod = "PUT",nickname="修改",produces = "/updateDefInsured")
    public  AjaxResponse  updateDefInsured(@RequestBody Map<String,Object> objectMap){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.updateDefInsured(objectMap);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询方案名称
     * @param name
     * @return
     */
    @GetMapping("/selectDefInsuredName/{name}")
    @ApiOperation(value = "查询方案名称",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectDefInsuredName/{name}")
    public AjaxResponse selectDefInsuredName(@PathVariable("name") String name){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectDefInsuredName(name);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有的社保方案
     * @return
     */
    @GetMapping("/selectDefInsuredListName")
    @ApiOperation(value = "查询所有的社保方案",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectDefInsuredListName")
    public AjaxResponse selectDefInsuredListName(){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectDefInsuredListName();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    @PostMapping("/pageStaff")
    @ApiOperation(value = "查询所有的员工",notes = "社保模块",httpMethod = "POST",nickname="查询",produces = "/pageStaff")
    public AjaxResponse pageStaff(@RequestBody Staff staff){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.pageStaff(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/deptList")
    @ApiOperation(value = "查询所有的部门列表",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/deptList")
    public AjaxResponse deptList(){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.deptList();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /***
     * 参保提交
     * @param map
     * @return
     */
    @PostMapping("/insuredSubmit")
    @ApiOperation(value = "参保提交",notes = "社保模块",httpMethod = "POST",nickname="添加",produces = "/insuredSubmit")
    public AjaxResponse insuredSubmit(@RequestBody Map<String,Object> map){
        Map<String,Object> map1 = (Map<String, Object>) socialClinetService.insuredSubmit(map);
        return AjaxResponse.success(carryTokenUtil.main(map1));
    }
}
