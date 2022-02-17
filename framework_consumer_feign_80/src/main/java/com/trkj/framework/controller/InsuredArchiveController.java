package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.service.client.social.SocialClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/archive")
public class InsuredArchiveController {
    @Autowired
    private SocialClinetService socialClinetService=null;
    @Autowired
    CarryTokenUtil carryTokenUtil;
    /***
     *分页查询参保归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/pageSelectInsuredArchive")
    @ApiOperation(value = "分页查询参保归档数据",notes = "社保模块",httpMethod = "GET",nickname="查询",produces = "/pageSelectInsuredArchive")
    public AjaxResponse pageSelectInsuredArchive(@RequestBody InsuredArchive insuredArchive){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.pageSelectInsuredArchive(insuredArchive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /****
     * 通过计薪月份查询归档数据
     * @param insuredArchive
     * @return
     */
    @PostMapping("/selectListInsuredArchive")
    @ApiOperation(value = "通过计薪月份查询归档数据",notes = "社保模块",httpMethod = "POST",nickname="查询",produces = "/selectListInsuredArchive")
    public AjaxResponse selectListInsuredArchive(@RequestBody InsuredArchive insuredArchive){
        Map<String,Object> map = (Map<String, Object>) socialClinetService.selectListInsuredArchive(insuredArchive);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}

