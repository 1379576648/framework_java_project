package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

/**
 * @author 13795
 */
//降级~
@Component
public class SystemClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new SystemClinetService() {
            @Override
            public AjaxResponse selectRegisterLogAll(@RequestBody RegisterLog registerLog) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object checkDelete(@RequestBody ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object emptyList(RegisterLog registerLog) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectNoticeAll(@RequestBody Notice notice) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object checkNoticeDelete(@RequestBody ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public AjaxResponse selectDeptList() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object insertNotice(@RequestBody Notice notice) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectPossessDeptList(Integer id) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object updateNotice(Notice notice) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object peropleNoticeViewed(Integer id) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object unseenNoticePerson(Integer id) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectRoleAll(Role role) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object checkRoleDelete(ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerList() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object addRole(Role role) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectRoleRoleName(String name, String value) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerListInRoleId(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object updateRole(Role role) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object allotMenu(Role role) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectRoleStaff(RoleStaff roleStaff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object cancelImpower(ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectStaffInState(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object allotStaff(RoleStaff roleStaff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerInCondition(MenuPower menuPower) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerAddSingle(MenuPower menuPower) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerInPid(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerUpdate(MenuPower menuPower) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerDelete(Integer id) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object menuPowerAdd(MenuPower menuPower) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }
        };
    }
}
