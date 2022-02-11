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
            public Map<String,Object> selectDefInsured(DefInsured defInsured) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> deleteDefInsured(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> updateDefInsuredState(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDefInsuredId(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> listSelectDefScheme(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> addDefInsured(Map<String,Object> map) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> updateDefInsured(Map<String,Object> map) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDefInsuredName(String name) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDefInsuredListName() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> pageStaff(Staff staff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> deptList() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> insuredSubmit(Map<String,Object> map) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectPageIsuredDetail(InsuredDetail insuredDetail) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> deleteInsuredDetail(InsuredDetail insuredDetail) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> pigeonhole() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> archived(InsuredArchive insuredArchive) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> archivedInMonth(String name) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> deleteArchivedInName(Map<String,Object> map) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectPostName(String name) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectListScheme(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectInsuredLog(String name, String month) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> pageSelectInsuredArchive(InsuredArchive insuredArchive) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectListInsuredArchive(@RequestBody InsuredArchive insuredArchive) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
