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
            public Object selectFixedwage(FixedwageVo fixedwageVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改固定工资
             * @param fixedwagf
             * @return
             */
            @Override
            public Object updateFixedwage(Fixedwagf fixedwagf) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加调薪
             * @param salary
             * @return
             */
            @Override
            public Object insertSalary(Salary salary) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询调薪
             * @param wageVo
             * @return
             */
            @Override
            public Object selectSalary(WageVo wageVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 查询加班方案
             * @param workSchemeVo
             * @return
             */
            @Override
            public Object selectWorkScheme(WorkSchemeVo workSchemeVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 添加加班方案
             * @param workScheme
             * @return
             */
            @Override
            public Object insertWorkScheme(WorkScheme workScheme) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改状态为禁用
             * @param workScheme
             * @return
             */
            @Override
            public Object updateWorkSchemeState(WorkScheme workScheme) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 修改状态为启用
             * @param workScheme
             * @return
             */
            @Override
            public Object updateWorkSchemeStateTwo(WorkScheme workScheme) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            /**
             * 删除加班方案
             * @param list
             * @return
             */
            @Override
            public Object deleteWorkScheme(ArrayList<Integer> list) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }
        };
    }
}
