package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.models.auth.In;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private SystemClinetService systemClinetService =null;

    /***
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    public AjaxResponse selectNoticeAll(@RequestBody Notice notice){
        return AjaxResponse.success(systemClinetService.selectNoticeAll(notice)) ;
    }

    /***
     * 复选删除公告列表
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    public AjaxResponse checkNoticeDelete(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(systemClinetService.checkNoticeDelete(list));
    }

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/selectDeptList")
    public  AjaxResponse selectDeptList(){
        return AjaxResponse.success(systemClinetService.selectDeptList());
    }

    /***
     * 新增公告
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    public AjaxResponse insertNotice(@RequestBody Notice notice){
        return AjaxResponse.success(systemClinetService.insertNotice(notice));
    }

    /***
     * 查询当前公告绑定的部门
     * @param id
     * @return
     */
    @GetMapping("/selectPossessDeptList")
    public AjaxResponse selectPossessDeptList(@RequestParam("id") Integer id){
        return AjaxResponse.success(systemClinetService.selectPossessDeptList(id));
    }

    /***
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/updateNotice")
    public AjaxResponse updateNotice(@RequestBody Notice notice){
       return AjaxResponse.success(systemClinetService.updateNotice(notice));
    }

    /***
     * 已看公告人员
     * @param id
     * @return
     */
    @GetMapping("/peropleNoticeViewed")
    public AjaxResponse peropleNoticeViewed(@RequestParam("id") Integer id){
        return AjaxResponse.success(systemClinetService.peropleNoticeViewed(id));
    }

    /**
     * 未看公告人员
     * @param id
     * @return
     */
    @GetMapping("/unseenNoticePerson")
    public AjaxResponse unseenNoticePerson(@RequestParam("id") Integer id){
        return AjaxResponse.success(systemClinetService.unseenNoticePerson(id));
    }
}
