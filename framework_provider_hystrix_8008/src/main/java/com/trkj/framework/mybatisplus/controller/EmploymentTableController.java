package com.trkj.framework.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 录用表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@RestController
public class EmploymentTableController {
    @Autowired
    private EmploymentTableService employmentTableService;

    /**
     * 查询已录用待入职的员工
     */
    @GetMapping("/selectpage")
    public Object selecthirepage(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        Page<HireVo> page = new Page<>(currentPage,pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",employmentTableService.selectpage(page));
        return map;
    }

    /**
     * 查询已经淘汰的员工
     */
    @GetMapping("/selectabandon")
    public Object selectanandon(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        Page<HireVo> page = new Page<>(currentPage,pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",employmentTableService.selectabandon(page));
        return map;

    }

    /**
     * 查询工作经历
     */
    @GetMapping("/selectwork")
    public Object selectwork(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        Page<WorkVo> page = new Page<>(currentPage,pagesize);
        Map<String,Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",employmentTableService.selectwork(page));
        return map;

    }

    /**
     * 查询转正记录
     */
    @GetMapping("/selectpost")
    public Object selectpost(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        Page<FullVo> page = new Page<>(currentPage,pagesize);
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("succeed",employmentTableService.selectpost(page));
        return map;
    }
}

