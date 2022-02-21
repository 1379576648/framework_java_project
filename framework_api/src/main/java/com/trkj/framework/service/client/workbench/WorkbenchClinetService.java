package com.trkj.framework.service.client.workbench;

import com.trkj.framework.service.client.fallbackfactory.SystemClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.WorkbenchClinetServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8002/provider", fallbackFactory = WorkbenchClinetServiceFallbackfactory.class)
public interface WorkbenchClinetService {

    /***
     * 通过员工编号查询公告信息
     * @param integer
     * @return
     */
    @GetMapping("/selectNoticeStaffId/{id}")
    public Map<String, Object> selectNoticeStaffId(@PathVariable("id") Integer integer);

    /***
     * 通过公告编号修改公告员工状态
     * @param integer1
     * @param integer2
     * @return
     */
    @PutMapping("/updateNoticeOrId/{id1}/{id2}")
    public Map<String, Object> updateNoticeOrId(@PathVariable("id1") Integer integer1, @PathVariable("id2") Integer integer2);
}
