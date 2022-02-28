package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.service.client.organize.OrganizeService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//降级~
@Component
public class OrganizeServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new OrganizeService() {
            @Override
            public  Map<String, Object> selectDept(Dept dept) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> selectDeptPost(DeptPost deptPost) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> scDeptPost(Integer id) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> xzDeptPost(DeptPost deptPost) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> xzDept(Dept dept) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> cxDept(){
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectStaffF(){return fuseUtil.main(throwable);}

            @Override
            public Map<String,Object> upDept(Dept dept){return fuseUtil.main(throwable);}
        };
    }
}
