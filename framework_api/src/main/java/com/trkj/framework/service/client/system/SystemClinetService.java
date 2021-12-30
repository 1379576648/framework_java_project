package com.trkj.framework.service.client.system;

import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.RegisterLog;

import com.trkj.framework.service.client.fallbackfactory.SystemClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

/**
 * @author 13795
 */
@FeignClient(value = "REGISTER-8007/provider", fallbackFactory = SystemClinetServiceFallbackfactory.class)
public interface SystemClinetService {
    /***
     *  登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    public Object selectRegisterLogAll(@RequestBody  RegisterLog registerLog);

    /***
     * 登录日志复选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkRegisterLogDelete")
    public Object checkDelete(@RequestBody ArrayList<Integer> list);

    /***
     * 登录日志清空数据
     * @return
     */
    @DeleteMapping("/emptyRegisterLogList")
    public Object emptyList();

    /***
     *分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    public Object selectNoticeAll(@RequestBody Notice notice);

    /***
     * 公告复选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    public Object checkNoticeDelete(@RequestBody ArrayList<Integer> list);
}
