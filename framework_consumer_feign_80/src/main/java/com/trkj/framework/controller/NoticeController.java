package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.models.auth.In;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author 13795
 */
@RestController
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
    @DeleteMapping("/checkNoticeDelete")
    public AjaxResponse checkNoticeDelete(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(systemClinetService.checkNoticeDelete(list));
    }
}
