package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.AttendandceService;
import com.trkj.framework.vo.AttendandceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AttendandceController {

    @Autowired
    private AttendandceService attendandceService;

    /**
     * 查询考勤扣款方案
     * @param attendandceVo
     * @return
     */
    @PostMapping("/selectAttendandce")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectAttendandce(@RequestBody AttendandceVo attendandceVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",attendandceService.selectAttendandce(attendandceVo));
        return map1;
    }

    //备选方案
    public Object HystixGet(@RequestBody AttendandceVo attendandceVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

//    /**
//     * 添加加班方案
//     * @param workScheme
//     * @return
//     */
//    @PostMapping("/insertWorkScheme")
//    @HystrixCommand(fallbackMethod = "HystixGet2")
//    public Object insertWorkScheme(@RequestBody WorkScheme workScheme){
//        return workSchemeService.insertWorkScheme(workScheme);
//    }
//
//    //备选方案
//    public Object HystixGet2(@RequestBody WorkScheme workScheme){
//        Map<String,Object> map1 = new HashMap<>(2);
//        map1.put("state",300);
//        map1.put("info","服务发生雪崩");
//        return map1;
//    }
//
//    /**
//     * 修改状态为禁用
//     * @param workScheme
//     * @return
//     */
//    @PutMapping("/updateWorkSchemeState")
//    public int updateWorkSchemeState(@RequestBody WorkScheme workScheme){
//        workScheme.setWorkschemeState(1);
//        final var i = workSchemeService.updateWorkSchemeState(workScheme);
//        if (i==999){
//            return 666;
//        }else {
//            return 100;
//        }
//    }
//
//    /**
//     * 修改状态为启用
//     * @param workScheme
//     * @return
//     */
//    @PutMapping("/updateWorkSchemeStateTwo")
//    public int updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme){
//        workScheme.setWorkschemeState(0);
//        final var i = workSchemeService.updateWorkSchemeStateTwo(workScheme);
//        if (i==999){
//            return 666;
//        }else {
//            return 100;
//        }
//    }
//
//    /**
//     * 删除加班方案
//     * @param list
//     * @return
//     */
//    @DeleteMapping("/deleteWorkScheme")
//    @HystrixCommand(fallbackMethod = "HystixGet3")
//    public Object deleteWorkScheme(@RequestBody ArrayList<Integer> list){
//        Map<String ,Object> map1 = new HashMap<>(2);
//        //状态码
//        map1.put("state",200);
//        //返回结果
//        map1.put("info",workSchemeService.deleteWorkScheme(list));
//        return map1;
//    }
//
//    //备选方案
//    public Object HystixGet3(@RequestBody ArrayList<Integer> list){
//        Map<String,Object> map1 = new HashMap<>(2);
//        map1.put("state",300);
//        map1.put("info","服务发生雪崩");
//        return map1;
//    }
//
//    /**
//     * 根据id查询加班方案
//     * @param workScheme
//     * @return
//     */
//    @PostMapping("/selectWorkSchemeAll")
//    @HystrixCommand(fallbackMethod = "HystixGet4")
//    public Object selectWorkSchemeAll(@RequestBody WorkScheme workScheme){
//        Map<String, Object> map1 = new HashMap<>(2);
//        map1.put("state", 200);
//        map1.put("info", workSchemeService.selectWorkSchemeAll(workScheme));
//        System.out.println(workScheme);
//        return map1;
//    }
//
//    // 备选方案
//    public Object HystixGet4(@RequestBody WorkScheme workScheme){
//        Map<String,Object> map1 = new HashMap<>(2);
//        map1.put("state",300);
//        map1.put("info","服务发生雪崩");
//        return map1;
//    }
//
//    /**
//     * 修改加班方案
//     * @param workScheme
//     * @return
//     */
//    @PutMapping("/updateWorkScheme")
//    public Object updateWorkScheme(@RequestBody WorkScheme workScheme){
//        //方案名称
//        workScheme.setWorkschemeName(workScheme.getWorkschemeName());
//        //工作日加班工资
//        workScheme.setWorkschemeWorkratio(workScheme.getWorkschemeWorkratio());
//        //节假日加班工资
//        workScheme.setWorkschemeHolidayratio(workScheme.getWorkschemeHolidayratio());
//        //休息日加班工资
//        workScheme.setWorkschemeDayoffratio(workScheme.getWorkschemeDayoffratio());
//        //适用对象
//        workScheme.setDeptName(workScheme.getDeptName());
//        //备注
//        workScheme.setWorkschemeRemark(workScheme.getWorkschemeRemark());
//        final var i = workSchemeService.updateWorkScheme(workScheme);
//        if (i==999){
//            return 666;
//        }else {
//            return 100;
//        }
//    }

}
