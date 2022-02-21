package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.service.client.wage.WageClientService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.FixedwageVo;
import com.trkj.framework.vo.WageVo;
import com.trkj.framework.vo.WorkSchemeVo;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
             * @param list
             * @return
             */
            @Override
            public Map<String,Object> deleteWorkScheme(ArrayList<Integer> list) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
