package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.checking.CheckingService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 112729
 */
@Component
public class CheckingServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;

    @Override
    public Object create(Throwable throwable) {
        return new CheckingService() {
            @Override
            public Map<String, Object> selectCardRecordAll(ClockRecord cardRecord) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectOverTimeRecordAll(Overtimeask overtimeask) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteClock(ClockRecord cardRecord) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteOverTime(Overtimeask overtimeask) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateBeginOverTime(Overtimeask overtimeask) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateEndOverTime(Overtimeask overtimeask) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectLeaveRecordAll(Leave leave) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteLeave(Leave leave) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateBeginLeave(Leave leave) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateEndLeave(Leave leave) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectEvectionRecordAll(Travel travel) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteEvection(Travel travel) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateBeginTravel(Travel travel) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateEndTravel(Travel travel) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectReissueCardRecordAll(Card card) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteCard(Card card) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectClassesAll(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> submitFormClasses(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> inquireClasses(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> deleteClasses(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectClasses(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateClassesState(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateClassesStateTwo(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectClassesByID(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateClasses(Classes classes) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> importCardRecord(String name, MultipartFile file) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectCardRecordAllByName(ClockRecord cardRecord) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
