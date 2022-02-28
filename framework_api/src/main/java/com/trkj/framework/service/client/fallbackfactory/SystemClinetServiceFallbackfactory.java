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
import java.util.Map;

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
            public Map<String, Object> selectRegisterLogAll(@RequestBody RegisterLog registerLog) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> checkDelete(@RequestBody ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> emptyList(RegisterLog registerLog) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectOperatLogAll(OperatLog operatLog) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> checkOperatLogDelete(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> emptyOperatLogList(OperatLog operatLog) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectNoticeAll(@RequestBody Notice notice) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> checkNoticeDelete(@RequestBody ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectDeptList() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> insertNotice(@RequestBody Notice notice) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectPossessDeptList(Integer id) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> updateNotice(Notice notice) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> peropleNoticeViewed(Integer id) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> unseenNoticePerson(Integer id) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectRoleAll(Role role) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> checkRoleDelete(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerList() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> addRole(Role role) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectRoleRoleName(String name, String value) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerListInRoleId(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> updateRole(Role role) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> allotMenu(Role role) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectRoleStaff(RoleStaff roleStaff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> cancelImpower(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectStaffInState(Staff staff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> allotStaff(RoleStaff roleStaff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerInCondition(MenuPower menuPower) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerAddSingle(MenuPower menuPower) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerInPid(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerUpdate(MenuPower menuPower) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerDelete(Integer id) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> menuPowerAdd(MenuPower menuPower) {
                return fuseUtil.main(throwable);
            }
            @Override
            public Map<String, Object> selectDeptPostAll() {
                return fuseUtil.main(throwable);
            }
        };
    }
}
