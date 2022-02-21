package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
            public Map<String,Object> selecthirepage(HireVo hireVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询已经淘汰的员工
             * @param hireVo
             * @return
             */
            @Override
            public Map<String,Object> selectabandon(HireVo hireVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectwork(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询转正
             * @param fullVo
             * @return
             */
            @Override
            public Map<String,Object> selectpost(FullVo fullVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 新增员工
             * @param hireVo
             * @return
             */

            @Override
            public Map<String,Object> insertStaff(HireVo hireVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改录用表状态
             * @param employmentTable
             * @return
             */
            @Override
            public Map<String,Object> updateEmploymentState(EmploymentTable employmentTable) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改录用状态为已淘汰以及放弃原因
             * @param employmentTable
             * @return
             */
            @Override
            public Map<String,Object> updateEmploymentStateAndWaiveReasonInt(EmploymentTable employmentTable) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询员工花名册
             * @param staffVo
             * @return
             */
            @Override
            public Map<String,Object> selectStaff(StaffVo staffVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询员工信息
             * @param staffVo
             * @return
             */
            @Override
            public Map<String,Object> selectStaffAll(StaffVo staffVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询历史花名册
             * @param staffQuitVo
             * @return
             */
            @Override
            public Map<String,Object> selectQuit(StaffQuitVo staffQuitVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询调动
             * @param transferVo
             * @return
             */
            @Override
            public Map<String,Object> selectTransfer(TransferVo transferVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改员工信息
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateStaff(Staff staff) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改员工信息2
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateStaffTwo(Staff staff) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询所有员工名称
             * @return
             */
            @Override
            public Map<String,Object> selectStaffName() {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询所有的部门名称
             * @return
             */
            @Override
            public Map<String,Object> selectSect() {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询所有的职位名称
             * @return
             */
            @Override
            public Map<String,Object> selectJob() {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据名称查询部门名称和职位名称
             * @param transferTwoVo
             * @return
             */
            @Override
            public Map<String,Object> selectTransferByName(TransferTwoVo transferTwoVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据部门查询部门职位
             * @param transferTwoVo
             * @return
             */
            @Override
            public Map<String, Object> selectPostName(TransferTwoVo transferTwoVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectWorkAll(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询奖励
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectGloryAll(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询惩罚
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectPunishAll(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询教育经历
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectEducationAll(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 添加工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Map<String,Object> insertWorkExperience(WorkExperience workExperience) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据工作经历id查询工作经历
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectWorkOne(WorkVo workVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改工作经历
             * @param workExperience
             * @return
             */
            @Override
            public Map<String,Object> updateWork(WorkExperience workExperience) {
                return fuseUtil.main(throwable);
            }

            /**
             * 删除工作经历
             * @param list
             * @return
             */
            @Override
            public Map<String,Object> deleteWork(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据奖励id查询奖励
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectGloryOne(WorkVo workVo) { return fuseUtil.main(throwable);
            }

            /**
             * 添加奖励
             * @param glory
             * @return
             */
            @Override
            public Map<String,Object> insertGlory(Glory glory) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改奖励
             * @param glory
             * @return
             */
            @Override
            public Map<String,Object> updateGlory(Glory glory) {
                return fuseUtil.main(throwable);
            }

            /**
             * 删除奖励
             * @param list
             * @return
             */
            @Override
            public Map<String,Object> deleteGlory(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据惩罚id查询惩罚
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectPunishOne(WorkVo workVo) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 添加惩罚
             * @param punish
             * @return
             */
            @Override
            public Map<String,Object> insertPunish(Punish punish) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改惩罚
             * @param punish
             * @return
             */
            @Override
            public Map<String,Object> updatePunish(Punish punish) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 删除惩罚
             * @param list
             * @return
             */
            @Override
            public Map<String,Object> deletePunish(ArrayList<Integer> list) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 根据教育经历id查询教育经历
             * @param workVo
             * @return
             */
            @Override
            public Map<String,Object> selectEducationOne(WorkVo workVo) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 添加教育经历
             * @param education
             * @return
             */
            @Override
            public Map<String,Object> insertEducation(Education education) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改教育经历
             * @param education
             * @return
             */
            @Override
            public Map<String,Object> updateEducation(Education education) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 删除教育经历
             * @param list
             * @return
             */
            @Override
            public Map<String,Object> deleteEducation(ArrayList<Integer> list) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 根据员工姓名查询调动记录
             * @param transfer
             * @return
             */
            @Override
            public Map<String,Object> selectTransferAlls(Transfer transfer) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 添加调动记录
             * @param transfer
             * @return
             */
            @Override
            public Map<String,Object> insertTransfer(Transfer transfer) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改调动后的部门
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateDeptName(Staff staff) {
                 return fuseUtil.main(throwable);
            }


            /**
             * 查询奖励和惩罚
             * @param punishGloryVo
             * @return
             */
            @Override
            public Map<String,Object> selectPunishGlory(PunishGloryVo punishGloryVo) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 添加转正
             * @param fullVo
             * @return
             */
            @Override
            public Map<String,Object> insertWorker(FullVo fullVo) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改员工状态为正式
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateStaffState(Staff staff) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 添加离职
             * @param quit
             * @return
             */
            @Override
            public Map<String,Object> insertQuit(Quit quit) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改员工状态为离职
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateStaffStateTwo(Staff staff) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 修改转正日期
             * @param staff
             * @return
             */
            @Override
            public Map<String,Object> updateWorkerDate(Staff staff) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 快转正名单
             * @param fullVo
             * @return
             */
            @Override
            public Map<String,Object> selectQuick(FullVo fullVo) {
                 return fuseUtil.main(throwable);
            }

            /**
             * 统计快要转正名单
             * @return
             */
            @Override
            public Map<String,Object> countByStaffState() {
                return fuseUtil.main(throwable);
            }

            /**
             * 转正已生效
             * @param fullVo
             * @return
             */
            @Override
            public Map<String,Object> selectStateOne(FullVo fullVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 统计转正已生效
             * @return
             */
            @Override
            public Map<String,Object> countStateOne() {
                return fuseUtil.main(throwable);
            }

            /**
             * 统计试用期人员
             * @return
             */
            @Override
            public Map<String,Object> countStateTwo() {
                return fuseUtil.main(throwable);
            }

            /**
             * 本月离职
             * @return
             */
            @Override
            public Map<String,Object> countStateThree() {
                return fuseUtil.main(throwable);
            }

            /**
             * 正式
             * @return
             */
            @Override
            public Map<String,Object> countStateFour() {
                return fuseUtil.main(throwable);
            }

            /**
             * 试用
             * @return
             */
            @Override
            public Map<String,Object> countStateFive() {
                return fuseUtil.main(throwable);
            }

            /**
             * 本月新入职
             * @return
             */
            @Override
            public Map<String,Object> countStateSix() {
                return fuseUtil.main(throwable);
            }

        };
    }
}
