package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.service.client.wage.WageClientService;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class WageClientServiceFallbackfactory implements FallbackFactory {

    @Autowired
    private FuseUtil fuseUtil;

    /**
     * 查询固定工资
     * @param throwable
     * @return
     */
    @Override
    public Object create(Throwable throwable) {
        return new WageClientService() {
            /**
             * 查询固定工资
             * @param fixedwageVo
             * @return
             */
            @Override
            public Map<String,Object> selectFixedwage(FixedwageVo fixedwageVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改固定工资
             * @param fixedwagf
             * @return
             */
            @Override
            public Map<String,Object> updateFixedwage(Fixedwagf fixedwagf) {
                return fuseUtil.main(throwable);
            }

            /**
             * 添加调薪
             * @param salary
             * @return
             */
            @Override
            public Map<String,Object> insertSalary(Salary salary) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询调薪
             * @param wageVo
             * @return
             */
            @Override
            public Map<String,Object> selectSalary(WageVo wageVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询加班方案
             * @param workSchemeVo
             * @return
             */
            @Override
            public Map<String,Object> selectWorkScheme(WorkSchemeVo workSchemeVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 添加加班方案
             * @param workScheme
             * @return
             */
            @Override
            public Map<String,Object> insertWorkScheme(WorkScheme workScheme) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为禁用
             * @param workScheme
             * @return
             */
            @Override
            public Map<String,Object> updateWorkSchemeState(WorkScheme workScheme) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为启用
             * @param workScheme
             * @return
             */
            @Override
            public Map<String,Object> updateWorkSchemeStateTwo(WorkScheme workScheme) {
                return fuseUtil.main(throwable);
            }

            /**
             * 删除加班方案
             * @param id
             * @return
             */
            @Override
            public Map<String,Object> deleteWorkScheme(Integer id) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询加班方案
             * @param workScheme
             * @return
             */
            @Override
            public Map<String,Object> selectWorkSchemeAll(WorkScheme workScheme) {
                return fuseUtil.main(throwable);            }

            /**
             * 修改加班方案
             * @param workScheme
             * @return
             */
            @Override
            public Map<String,Object> updateWorkScheme(WorkScheme workScheme) {
                return fuseUtil.main(throwable);            }

            /**
             * 查询考勤扣款方案
             * @param attendandceVo
             * @return
             */
            @Override
            public Map<String,Object> selectAttendandce(AttendandceVo attendandceVo) {
                return fuseUtil.main(throwable);            }

            /**
             * 添加考勤扣款方案
             * @param attendandce
             * @return
             */
            @Override
            public Map<String, Object> insertAttendandce(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询考勤扣款方案
             * @param attendandce
             * @return
             */
            @Override
            public Map<String, Object> selectAttendandceAll(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateAttendandce(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            /**
             * 删除考勤扣款方案
             * @param id
             * @return
             */
            @Override
            public Map<String, Object> deleteAttendandce(Integer id) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为禁用
             * @param attendandce
             * @return
             */
            @Override
            public Map<String, Object> updateAttendandceState(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为启用
             * @param attendandce
             * @return
             */
            @Override
            public Map<String, Object> updateAttendandceStateTwo(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询出差方案
             * @param businessVo
             * @return
             */
            @Override
            public Map<String, Object> selectBusiness(BusinessVo businessVo) {
                return fuseUtil.main(throwable);
            }

            /**
             * 添加出差方案
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> insertBusiness(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据id查询出差方案
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> selectBusinessAll(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改出差方案
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> updateBusiness(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 删除出差方案
             * @param id
             * @return
             */
            @Override
            public Map<String, Object> deleteBusiness(Integer id) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为禁用
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> updateBusinessState(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为启用
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> updateBusinessStateTwo(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询工资表
             * @param staff
             * @return
             */
            @Override
            public Map<String, Object> selectWage(Staff staff) {
                return fuseUtil.main(throwable);
            }

            /**
             * 统计工资表
             * @param staff
             * @return
             */
            @Override
            public Map<String, Object> countWage(Staff staff) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询未归档工资表
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> selectMoney(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 统计未归档工资表
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> countMoney(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 查询已归档工资表
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> selectMoneys(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 统计已归档工资表
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> countMoneys(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 修改状态为已归档
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> updateMoney(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据部门名称查询有无方案
             * @param business
             * @return
             */
            @Override
            public Map<String, Object> selectBusinessBydept(Business business) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据部门名称查询有无方案
             * @param attendandce
             * @return
             */
            @Override
            public Map<String, Object> selectAttendandceBydept(Attendandce attendandce) {
                return fuseUtil.main(throwable);
            }

            /**
             * 根据部门名称查询是否有方案
             * @param workScheme
             * @return
             */
            @Override
            public Map<String, Object> selectWorkSchemeBydept(WorkScheme workScheme) {
                return fuseUtil.main(throwable);
            }

            /**
             * 薪酬统计
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> selectstatcis(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 薪酬统计
             * @param moneyPigeonhole
             * @return
             */
            @Override
            public Map<String, Object> selectstatc(MoneyPigeonhole moneyPigeonhole) {
                return fuseUtil.main(throwable);
            }

            /**
             * 本月调薪
             * @return
             */
            @Override
            public Map<String, Object> counttx() {
                return fuseUtil.main(throwable);
            }
        };
    }
}
