package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.service.client.workbench.WorkbenchClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private SystemClinetService systemClinetService = null;
    @Autowired
    private WorkbenchClinetService workbenchClinetService=null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;



    /***
     * 通过员工编号查询公告信息
     * @param integer
     * @return
     */
    @GetMapping("/selectNoticeStaffId/{id}")
    @ApiOperation(value = "通过员工编号查询公告信息", notes = "工作台", httpMethod = "GET", nickname = "查询", produces = "/selectNoticeStaffId/{id}")
    public AjaxResponse selectNoticeStaffId(@PathVariable("id") Integer integer) {
        Map<String, Object> map = (Map<String, Object>) workbenchClinetService.selectNoticeStaffId(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过公告编号修改公告员工状态
     * @param integer1
     * @param integer2
     * @return
     */
    @PutMapping("/updateNoticeOrId/{id1}/{id2}")
    @ApiOperation(value = "通过公告编号修改公告员工状态", notes = "工作台", httpMethod = "PUT", nickname = "修改", produces = "/updateNoticeOrId/{id1}/{id2}")
    public AjaxResponse updateNoticeOrId(@PathVariable("id1") Integer integer1 ,@PathVariable("id2") Integer integer2) {
        Map<String, Object> map = (Map<String, Object>) workbenchClinetService.updateNoticeOrId(integer1,integer2);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    @ApiOperation(value = "分页查询所有公告数据", notes = "系统模块", httpMethod = "POST", nickname = "查询", produces = "/selectNoticeAll")
    public AjaxResponse selectNoticeAll(@RequestBody Notice notice) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.selectNoticeAll(notice);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 复选删除公告列表
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    @ApiOperation(value = "复选删除公告列表", notes = "系统模块", httpMethod = "DELETE", nickname = "删除", produces = "/checkNoticeDelete")
    public AjaxResponse checkNoticeDelete(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.checkNoticeDelete(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/selectDeptList")
    @ApiOperation(value = "查询所有的部门列表", notes = "系统模块", httpMethod = "GET", nickname = "查询", produces = "/selectDeptList")
    public AjaxResponse selectDeptList() {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.selectDeptList();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 新增公告
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    @ApiOperation(value = "新增公告", notes = "系统模块", httpMethod = "POST", nickname = "添加", produces = "/insertNotice")
    public AjaxResponse insertNotice(@RequestBody Notice notice) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.insertNotice(notice);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询当前公告绑定的部门
     * @param id
     * @return
     */
    @GetMapping("/selectPossessDeptList")
    @ApiOperation(value = "修改社保方案状态", notes = "系统模块", httpMethod = "GET", nickname = "查询", produces = "/selectPossessDeptList")
    public AjaxResponse selectPossessDeptList(@RequestParam("id") Integer id) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.selectPossessDeptList(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/updateNotice")
    @ApiOperation(value = "修改公告", notes = "系统模块", httpMethod = "PUT", nickname = "修改", produces = "/updateNotice")
    public AjaxResponse updateNotice(@RequestBody Notice notice) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.updateNotice(notice);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 已看公告人员
     * @param id
     * @return
     */
    @GetMapping("/peropleNoticeViewed")
    @ApiOperation(value = "查询已看公告人员", notes = "系统模块", httpMethod = "GET", nickname = "查询", produces = "/peropleNoticeViewed")
    public AjaxResponse peropleNoticeViewed(@RequestParam("id") Integer id) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.peropleNoticeViewed(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 未看公告人员
     *
     * @param id
     * @return
     */
    @GetMapping("/unseenNoticePerson")
    @ApiOperation(value = "查询未看公告人员", notes = "系统模块", httpMethod = "GET", nickname = "查询", produces = "/unseenNoticePerson")
    public AjaxResponse unseenNoticePerson(@RequestParam("id") Integer id) {
        Map<String, Object> map = (Map<String, Object>) systemClinetService.unseenNoticePerson(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
