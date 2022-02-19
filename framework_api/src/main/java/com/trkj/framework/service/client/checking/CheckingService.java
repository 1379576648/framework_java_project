package com.trkj.framework.service.client.checking;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.CheckingServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@FeignClient(value = "FRAMEWORK-ZUUL/8004/provider", fallbackFactory = CheckingServiceFallbackfactory.class)
public interface CheckingService {

    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    Map<String,Object> selectCardRecordAll(@RequestBody ClockRecord cardRecord);

    /**
     * 根据员工名称查询加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    Map<String,Object> selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask);

    /**
     * 删除打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteClock")
    Map<String,Object> deleteClock(@RequestBody ClockRecord cardRecord);

    /**
     * 删除加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteOverTime")
    Map<String,Object> deleteOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 开始加班
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateBeginOverTime")
    Map<String,Object> updateBeginOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 结束加班
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateEndOverTime")
    Map<String,Object> updateEndOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 根据员工名称查询请假记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    Map<String,Object> selectLeaveRecordAll(@RequestBody Leave leave);

    /**
     * 删除请假记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteLeave")
    Map<String,Object> deleteLeave(@RequestBody Leave leave);

    /**
     * 开始请假
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateBeginLeave")
    Map<String,Object> updateBeginLeave(@RequestBody Leave leave);

    /**
     * 结束请假
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateEndLeave")
    Map<String,Object> updateEndLeave(@RequestBody Leave leave);

    /**
     * 根据员工名称查询出差记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    Map<String,Object> selectEvectionRecordAll(@RequestBody Travel travel);

    /**
     * 删除出差记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteEvection")
    Map<String,Object> deleteEvection(@RequestBody Travel travel);

    /**
     * 开始出差
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateBeginTravel")
    Map<String,Object> updateBeginTravel(@RequestBody Travel travel);

    /**
     * 结束出差
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateEndTravel")
    Map<String,Object> updateEndTravel(@RequestBody Travel travel);

    /**
     * 根据员工名称查询补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    Map<String,Object> selectReissueCardRecordAll(@RequestBody Card card);

    /**
     * 删除补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteCard")
    Map<String,Object> deleteCard(@RequestBody Card card);

    /**
     * 查询所有班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClassesAll")
    Map<String,Object> selectClassesAll(@RequestBody Classes classes);

    /**
     * 查询所有加班方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/submitFormClasses")
    Map<String,Object> submitFormClasses(@RequestBody Classes classes);

    /**
     * 查询所有加班方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/inquireClasses")
    Map<String,Object> inquireClasses(@RequestBody Classes classes);

    /**
     * 删除班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteClasses")
    Map<String,Object> deleteClasses(@RequestBody Classes classes);

    /**
     * 查询所有班次方案1
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClasses")
    Map<String,Object> selectClasses(@RequestBody Classes classes);

    /**
     * 修改班次方案状态(启用)
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClassesState")
    Map<String,Object> updateClassesState(@RequestBody Classes classes);

    /**
     * 修改班次方案状态(禁用)
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClassesStateTwo")
    Map<String,Object> updateClassesStateTwo(@RequestBody Classes classes);

    /**
     * 根据班次编号去查询班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClassesByID")
    Map<String,Object> selectClassesByID(@RequestBody Classes classes);

    /**
     * 修改班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClasses")
    Map<String,Object> updateClasses(@RequestBody Classes classes);

    /**
     * 导入打卡记录
     * @param name
     * @param file
     * @return
     */
    @PostMapping(value="/importCardRecord/{name}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    Map<String,Object> importCardRecord(@PathVariable("name") String name,MultipartFile file);


    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectCardRecordAllByName")
    Map<String,Object> selectCardRecordAllByName(@RequestBody ClockRecord cardRecord);
}
