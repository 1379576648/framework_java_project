package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.social.SocialClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
public class SocialClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;

    @Override
    public Object create(Throwable throwable) {
        return new SocialClinetService() {
            @Override
            public Object selectDefInsured(DefInsured defInsured) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object deleteDefInsured(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object updateDefInsuredState(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDefInsuredId(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object listSelectDefScheme(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public AjaxResponse addDefInsured(Map<String,Object> map) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public AjaxResponse updateDefInsured(Map<String,Object> map) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDefInsuredName(String name) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDefInsuredListName() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object pageStaff(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object deptList() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object insuredSubmit(Map<String,Object> map) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectPageIsuredDetail(InsuredDetail insuredDetail) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object deleteInsuredDetail(InsuredDetail insuredDetail) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object pigeonhole() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object archived(InsuredArchive insuredArchive) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object archivedInMonth(String name) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object deleteArchivedInName(Map<String,Object> map) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectPostName(String name) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectListScheme(Integer integer) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectInsuredLog(String name, String month) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object pageSelectInsuredArchive(InsuredArchive insuredArchive) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectListInsuredArchive(@RequestBody InsuredArchive insuredArchive) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }
        };
    }
}
