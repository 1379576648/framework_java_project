package com.trkj.framework.service.client.hire;

import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.fallbackfactory.HireClientServiceFallbackfactory;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8008/provider", fallbackFactory = HireClientServiceFallbackfactory.class)
public interface HireClientService {

    /**
     * 查询已录用待入职的员工
     */
    @PostMapping ("/selectpage")
    Object selecthirepage(@RequestBody HireVo hireVo);

    /**
     * 查询已经淘汰的员工
     */
    @PostMapping("/selectabandon")
    Object selectabandon(@RequestBody HireVo hireVo);

    /**
     * 查询工作经历
     */
    @PostMapping("/selectwork")
    Object selectwork(@RequestBody WorkVo workVo);

    /**
     * 查询转正
     */
    @PostMapping("/selectpost")
    Object selectpost(@RequestBody FullVo fullVo);

    /**
     * 新增员工
     * @param hireVo
     * @return
     */
    @PostMapping("/insertStaff")
    Object insertStaff(@RequestBody HireVo hireVo);
}

