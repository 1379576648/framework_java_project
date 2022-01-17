package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
//降级~
@Component
public class SystemClinetServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new SystemClinetService() {
            @Override
            public AjaxResponse selectRegisterLogAll(@RequestBody RegisterLog registerLog) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object checkDelete(@RequestBody ArrayList<Integer> list) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object emptyList(RegisterLog registerLog) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectNoticeAll(@RequestBody Notice notice) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object checkNoticeDelete(@RequestBody ArrayList<Integer> list) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public AjaxResponse selectDeptList() {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object insertNotice(@RequestBody Notice notice) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectPossessDeptList(Integer id) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object updateNotice(Notice notice) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object peropleNoticeViewed(Integer id) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object unseenNoticePerson(Integer id) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectRoleAll(Role role) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object checkRoleDelete(ArrayList<Integer> list) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object menuPowerList() {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object addRole(Role role) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectRoleRoleName(String name, String value) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object menuPowerListInRoleId(Integer integer) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object updateRole(Role role) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object allotMenu(Role role) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectRoleStaff(RoleStaff roleStaff) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object cancelImpower(ArrayList<Integer> list) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectStaffInState(Staff staff) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object allotStaff(RoleStaff roleStaff) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object menuPowerInCondition(MenuPower menuPower) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object menuPowerAddSingle(MenuPower menuPower) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object menuPowerInPid(Integer integer) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                throwable.printStackTrace();
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
