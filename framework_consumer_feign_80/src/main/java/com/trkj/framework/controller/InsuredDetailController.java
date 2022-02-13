package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.entity.mybatisplus.InsuredDetail;
import com.trkj.framework.service.client.social.SocialClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
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
@RequestMapping("/detail")
public class InsuredDetailController {

    @Autowired
    private SocialClinetService socialClinetService=null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

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

    /****
     * 分页查询参保明细
     * @param insuredDetail
     * @return
     */
    @PostMapping("/selectPageIsuredDetail")
    @ApiOperation(value = "分页查询参保明细",notes = "社保模块",httpMethod = "POST",nickname="查询",produces = "/selectPageIsuredDetail")
    public AjaxResponse selectPageIsuredDetail(@RequestBody InsuredDetail insuredDetail){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectPageIsuredDetail(insuredDetail);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 多选删除参保
     * @param insuredDetail
     * @return
     */
    @DeleteMapping("/deleteInsuredDetail")
    @ApiOperation(value = "多选删除参保",notes = "社保模块",httpMethod = "DELETE",nickname="删除",produces = "/deleteInsuredDetail")
    public AjaxResponse deleteInsuredDetail(@RequestBody InsuredDetail insuredDetail){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.deleteInsuredDetail(insuredDetail);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 归档
     * @return
     */
    @PostMapping("/pigeonhole")
    @ApiOperation(value = "归档",notes = "社保模块",httpMethod = "POST",nickname="添加",produces = "/pigeonhole")
    public AjaxResponse pigeonhole(){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.pigeonhole();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 归档分页查询
     * @param insuredArchive
     * @return
     */
    @PostMapping("/archived")
    @ApiOperation(value = "归档分页查询",notes = "社保模块",httpMethod = "POST",nickname="查询",produces = "/archived")
    public AjaxResponse archived (@RequestBody InsuredArchive insuredArchive){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.archived(insuredArchive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询某一个月份的归档明细
     * @param name
     * @return
     */
    @GetMapping("/archivedInMonth/{name}")
    @ApiOperation(value = "查询某一个月份的归档明细",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/archivedInMonth/{name}")
    public AjaxResponse archivedInMonth(@PathVariable("name") String name){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.archivedInMonth(name);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 删除某一个月的归档数据
     * @param map
     * @return
     */
    @DeleteMapping("/deleteArchived")
    @ApiOperation(value = "删除某一个月的归档数据",notes = "社保模块",httpMethod = "DELETE",nickname="删除",produces = "/deleteArchived")
    public AjaxResponse deleteArchivedInName(@RequestBody Map<String,Object> map){
        Map<String,Object> map1 = (Map<String, Object>) socialClinetService.deleteArchivedInName(map);
        return AjaxResponse.success(carryTokenUtil.main(map1));
    }

    /***
     * 通过员工名称获取职位名称
     * @param name
     * @return
     */
    @GetMapping("/selectPostName/{name}")
    @ApiOperation(value = "通过员工名称获取职位名称",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectPostName/{name}")
    public AjaxResponse selectPostName(@PathVariable("name") String name){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectPostName(name);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     *  通过明细编号查询
     * @param integer
     * @return
     */
    @GetMapping("/selectListScheme/{id}")
    @ApiOperation(value = "通过明细编号查询",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectListScheme/{id}")
    public AjaxResponse selectListScheme(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectListScheme(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /****
     * 查询某一个员工某一个月的参保日志
     * @param name
     * @param month
     * @return
     */
    @GetMapping("/selectInsuredLog/{name}/{month}")
    @ApiOperation(value = "查询某一个员工某一个月的参保日志",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/selectInsuredLog/{name}/{month}")
    public AjaxResponse selectInsuredLog(@PathVariable("name") String name,@PathVariable("month") String month){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectInsuredLog(name, month);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


}

