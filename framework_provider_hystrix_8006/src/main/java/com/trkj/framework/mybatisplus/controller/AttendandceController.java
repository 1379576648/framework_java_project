package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Attendandce;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.service.AttendandceService;
import com.trkj.framework.util.Fuse8006Util;
import com.trkj.framework.vo.AttendandceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AttendandceController {

    @Autowired
    private AttendandceService attendandceService;
    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @PostMapping("/selectAttendandce")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Map<String,Object> selectAttendandce(@RequestBody AttendandceVo attendandceVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",attendandceService.selectAttendandce(attendandceVo));
        return map1;
    }

    public Map<String,Object> HystixGet(@RequestBody AttendandceVo attendandceVo){
        return fuse8006Util.main();
    }

    /**
     * 添加考勤扣款方案
     *
     * @param attendandce
     * @return
     */
    @PostMapping("/insertAttendandce")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> insertAttendandce(@RequestBody Attendandce attendandce) {
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", attendandceService.insertAttendandce(attendandce));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet2(@RequestBody Attendandce attendandce) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为禁用
     *
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceState")
    @HystrixCommand(fallbackMethod = "updateAttendandceStateHystixGet")
    public Map<String, Object> updateAttendandceState(@RequestBody Attendandce attendandce) {
        attendandce.setAttendandceState(1);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", attendandceService.updateAttendandceState(attendandce));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateAttendandceStateHystixGet(@RequestBody Attendandce attendandce) {
        return fuse8006Util.main();
    }

    /**
     * 修改状态为启用
     *
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandceStateTwo")
    @HystrixCommand(fallbackMethod = "updateAttendandceStateTwoHystixGet")
    public Map<String, Object> updateAttendandceStateTwo(@RequestBody Attendandce attendandce) {
        attendandce.setAttendandceState(0);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", attendandceService.updateAttendandceStateTwo(attendandce));
        return map1;

    }

    //备选方案
    public Map<String, Object> updateAttendandceStateTwoHystixGet(@RequestBody Attendandce attendandce) {
        return fuse8006Util.main();
    }

    /**
     * 删除考勤扣款方案
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAttendandce/{id}")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> deleteAttendandce(@PathVariable("id") Integer id) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", attendandceService.deleteAttendandce(id));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet3(@PathVariable("id") Integer id) {
        return fuse8006Util.main();
    }

    /**
     * 根据id查询考勤扣款方案
     * @param attendandce
     * @return
     */
    @PostMapping("/selectAttendandceAll")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> selectAttendandceAll(@RequestBody Attendandce attendandce){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", attendandceService.selectAttendandceAll(attendandce));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet4(@RequestBody Attendandce attendandce){
        return fuse8006Util.main();
    }

    /**
     * 修改考勤扣款方案
     * @param attendandce
     * @return
     */
    @PutMapping("/updateAttendandce")
    @HystrixCommand(fallbackMethod = "hystixGet5")
    public Map<String, Object> updateAttendandce(@RequestBody Attendandce attendandce){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", attendandceService.updateAttendandce(attendandce));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet5(@RequestBody Attendandce attendandce){
        return fuse8006Util.main();
    }

    /**
     * 根据部门名称查询有无方案
     * @param attendandce
     * @return
     */
    @PostMapping("/selectAttendandceBydept")
    @HystrixCommand(fallbackMethod = "hystixGet6")
    public Map<String, Object> selectAttendandceBydept(@RequestBody Attendandce attendandce){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", attendandceService.selectAttendandceBydept(attendandce));
        return map1;
    }

    // 备选方案
    public Map<String, Object> hystixGet6(@RequestBody Attendandce attendandce){
        return fuse8006Util.main();
    }

}
