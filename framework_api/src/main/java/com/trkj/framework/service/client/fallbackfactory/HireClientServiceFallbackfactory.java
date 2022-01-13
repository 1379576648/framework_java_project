package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Map;

@Component
public class HireClientServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new HireClientService() {
            /**
             * 查询已录用待入职的员工
             * @param hireVo
             * @return
             */
            @Override
            public Object selecthirepage(HireVo hireVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 查询已经淘汰的员工
             * @param hireVo
             * @return
             */
            @Override
            public Object selectabandon(HireVo hireVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectwork(WorkVo workVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 查询转正
             * @param fullVo
             * @return
             */
            @Override
            public Object selectpost(FullVo fullVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 新增员工
             * @param hireVo
             * @return
             */

            @Override
            public Object insertStaff(HireVo hireVo) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 修改录用表状态
             * @param employmentTable
             * @return
             */
            @Override
            public Object updateEmploymentState(EmploymentTable employmentTable) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 修改录用状态为已淘汰以及放弃原因
             * @param employmentTable
             * @return
             */
            @Override
            public Object updateEmploymentStateAndWaiveReasonInt(EmploymentTable employmentTable) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询员工花名册
             * @param staffVo
             * @return
             */
            @Override
            public Object selectStaff(StaffVo staffVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据id查询员工信息
             * @param staffVo
             * @return
             */
            @Override
            public Object selectStaffAll(StaffVo staffVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询历史花名册
             * @param staffQuitVo
             * @return
             */
            @Override
            public Object selectQuit(StaffQuitVo staffQuitVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询调动
             * @param transferVo
             * @return
             */
            @Override
            public Object selectTransfer(TransferVo transferVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 修改员工信息
             * @param staff
             * @return
             */
            @Override
            public Object updateStaff(Staff staff) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 修改员工信息2
             * @param staff
             * @return
             */
            @Override
            public Object updateStaffTwo(Staff staff) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询所有员工名称
             * @return
             */
            @Override
            public Object selectStaffName() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询所有的部门名称
             * @return
             */
            @Override
            public Object selectSect() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 查询所有的职位名称
             * @return
             */
            @Override
            public Object selectJob() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据名称查询部门名称和职位名称
             * @param transferTwoVo
             * @return
             */
            @Override
            public Object selectTransferByName(TransferTwoVo transferTwoVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectWorkAll(WorkVo workVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据id查询奖励
             * @param workVo
             * @return
             */
            @Override
            public Object selectGloryAll(WorkVo workVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据id查询惩罚
             * @param workVo
             * @return
             */
            @Override
            public Object selectPunishAll(WorkVo workVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据id查询教育经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectEducationAll(WorkVo workVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 添加工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Object insertWorkExperience(WorkExperience workExperience) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 根据工作经历id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectWorkOne(WorkVo workVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 修改工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Object updateWork(WorkExperience workExperience) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 删除工作经历
             * @param list
             * @return
             */
            @Override
            public Object deleteWork(ArrayList<Integer> list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

        };
    }
}
