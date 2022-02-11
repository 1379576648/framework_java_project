package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HireClientServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
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
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询已经淘汰的员工
             * @param hireVo
             * @return
             */
            @Override
            public Object selectabandon(HireVo hireVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectwork(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询转正
             * @param fullVo
             * @return
             */
            @Override
            public Object selectpost(FullVo fullVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 新增员工
             * @param hireVo
             * @return
             */

            @Override
            public Object insertStaff(HireVo hireVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改录用表状态
             * @param employmentTable
             * @return
             */
            @Override
            public Object updateEmploymentState(EmploymentTable employmentTable) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改录用状态为已淘汰以及放弃原因
             * @param employmentTable
             * @return
             */
            @Override
            public Object updateEmploymentStateAndWaiveReasonInt(EmploymentTable employmentTable) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询员工花名册
             * @param staffVo
             * @return
             */
            @Override
            public Object selectStaff(StaffVo staffVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据id查询员工信息
             * @param staffVo
             * @return
             */
            @Override
            public Object selectStaffAll(StaffVo staffVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询历史花名册
             * @param staffQuitVo
             * @return
             */
            @Override
            public Object selectQuit(StaffQuitVo staffQuitVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询调动
             * @param transferVo
             * @return
             */
            @Override
            public Object selectTransfer(TransferVo transferVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改员工信息
             * @param staff
             * @return
             */
            @Override
            public Object updateStaff(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改员工信息2
             * @param staff
             * @return
             */
            @Override
            public Object updateStaffTwo(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询所有员工名称
             * @return
             */
            @Override
            public Object selectStaffName() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询所有的部门名称
             * @return
             */
            @Override
            public Object selectSect() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询所有的职位名称
             * @return
             */
            @Override
            public Object selectJob() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据名称查询部门名称和职位名称
             * @param transferTwoVo
             * @return
             */
            @Override
            public Object selectTransferByName(TransferTwoVo transferTwoVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectWorkAll(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据id查询奖励
             * @param workVo
             * @return
             */
            @Override
            public Object selectGloryAll(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据id查询惩罚
             * @param workVo
             * @return
             */
            @Override
            public Object selectPunishAll(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据id查询教育经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectEducationAll(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Object insertWorkExperience(WorkExperience workExperience) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据工作经历id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectWorkOne(WorkVo workVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Object updateWork(WorkExperience workExperience) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 删除工作经历
             * @param list
             * @return
             */
            @Override
            public Object deleteWork(ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据奖励id查询奖励
             * @param workVo
             * @return
             */
            @Override
            public Object selectGloryOne(WorkVo workVo) { return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加奖励
             * @param glory
             * @return
             */
            @Override
            public Object insertGlory(Glory glory) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改奖励
             * @param glory
             * @return
             */
            @Override
            public Object updateGlory(Glory glory) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 删除奖励
             * @param list
             * @return
             */
            @Override
            public Object deleteGlory(ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据惩罚id查询惩罚
             * @param workVo
             * @return
             */
            @Override
            public Object selectPunishOne(WorkVo workVo) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加惩罚
             * @param punish
             * @return
             */
            @Override
            public Object insertPunish(Punish punish) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改惩罚
             * @param punish
             * @return
             */
            @Override
            public Object updatePunish(Punish punish) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 删除惩罚
             * @param list
             * @return
             */
            @Override
            public Object deletePunish(ArrayList<Integer> list) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据教育经历id查询教育经历
             * @param workVo
             * @return
             */
            @Override
            public Object selectEducationOne(WorkVo workVo) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加教育经历
             * @param education
             * @return
             */
            @Override
            public Object insertEducation(Education education) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改教育经历
             * @param education
             * @return
             */
            @Override
            public Object updateEducation(Education education) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 删除教育经历
             * @param list
             * @return
             */
            @Override
            public Object deleteEducation(ArrayList<Integer> list) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 根据员工姓名查询调动记录
             * @param transfer
             * @return
             */
            @Override
            public Object selectTransferAlls(Transfer transfer) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加调动记录
             * @param transfer
             * @return
             */
            @Override
            public Object insertTransfer(Transfer transfer) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改调动后的部门
             * @param dept
             * @return
             */
            @Override
            public Object updateDeptName(Dept dept) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改调动后的职位
             * @param deptPost
             * @return
             */
            @Override
            public Object updateDeptPostName(DeptPost deptPost) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询奖励和惩罚
             * @param punishGloryVo
             * @return
             */
            @Override
            public Object selectPunishGlory(PunishGloryVo punishGloryVo) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加转正
             * @param fullVo
             * @return
             */
            @Override
            public Object insertWorker(FullVo fullVo) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改员工状态为正式
             * @param staff
             * @return
             */
            @Override
            public Object updateStaffState(Staff staff) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加离职
             * @param quit
             * @return
             */
            @Override
            public Object insertQuit(Quit quit) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改员工状态为离职
             * @param staff
             * @return
             */
            @Override
            public Object updateStaffStateTwo(Staff staff) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改转正日期
             * @param staff
             * @return
             */
            @Override
            public Object updateWorkerDate(Staff staff) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 快转正名单
             * @param fullVo
             * @return
             */
            @Override
            public Object selectQuick(FullVo fullVo) {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 统计快要转正名单
             * @return
             */
            @Override
            public Object countByStaffState() {
                 return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 转正已生效
             * @param fullVo
             * @return
             */
            @Override
            public Object selectStateOne(FullVo fullVo) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 统计转正已生效
             * @return
             */
            @Override
            public Object countStateOne() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 统计试用期人员
             * @return
             */
            @Override
            public Object countStateTwo() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 本月离职
             * @return
             */
            @Override
            public Object countStateThree() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 正式
             * @return
             */
            @Override
            public Object countStateFour() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 试用
             * @return
             */
            @Override
            public Object countStateFive() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            /**
             * 本月新入职
             * @return
             */
            @Override
            public Object countStateSix() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

        };
    }
}
