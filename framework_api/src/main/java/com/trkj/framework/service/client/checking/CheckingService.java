package com.trkj.framework.service.client.checking;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.CheckingServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "FRAMEWORK-ZUUL/8004/provider", fallbackFactory = CheckingServiceFallbackfactory.class)
public interface CheckingService {

    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    Object selectCardRecordAll(@RequestBody ClockRecord cardRecord);

    /**
     * 根据员工名称查询加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    Object selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask);

    /**
     * 删除打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteClock")
    Object deleteClock(@RequestBody ClockRecord cardRecord);

    /**
     * 删除加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteOverTime")
    Object deleteOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 开始加班
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateBeginOverTime")
    Object updateBeginOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 结束加班
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateEndOverTime")
    Object updateEndOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    Object selectLeaveRecordAll(@RequestBody Leave leave);

    /**
     * 删除打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteLeave")
    Object deleteLeave(@RequestBody Leave leave);

    /**
     * 根据员工名称查询出差记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    Object selectEvectionRecordAll(@RequestBody Travel travel);

    /**
     * 删除出差记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteEvection")
    Object deleteEvection(@RequestBody Travel travel);

    /**
     * 根据员工名称查询补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    Object selectReissueCardRecordAll(@RequestBody Card card);

    /**
     * 删除补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteCard")
    Object deleteCard(@RequestBody Card card);

    /**
     * 查询所有班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClassesAll")
    Object selectClassesAll(@RequestBody Classes classes);

    /**
     * 查询所有加班方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/submitFormClasses")
    Object submitFormClasses(@RequestBody Classes classes);

    /**
     * 查询所有加班方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/inquireClasses")
    Object inquireClasses(@RequestBody Classes classes);

    /**
     * 删除班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteClasses")
    Object deleteClasses(@RequestBody Classes classes);

    /**
     * 查询所有班次方案1
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClasses")
    Object selectClasses(@RequestBody Classes classes);

    /**
     * 修改班次方案状态(启用)
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClassesState")
    Object updateClassesState(@RequestBody Classes classes);

    /**
     * 修改班次方案状态(禁用)
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClassesStateTwo")
    Object updateClassesStateTwo(@RequestBody Classes classes);

    /**
     * 根据班次编号去查询班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectClassesByID")
    Object selectClassesByID(@RequestBody Classes classes);

    /**
     * 修改班次方案
     * @param
     * @param
     * @return
     */
    @PostMapping("/updateClasses")
    Object updateClasses(@RequestBody Classes classes);

    /**
     * 导入打卡记录
     * @param name
     * @param file
     * @return
     */
    @PostMapping(value="/import/{name}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    Object importCard(@PathVariable("name") String name,MultipartFile file);
}
