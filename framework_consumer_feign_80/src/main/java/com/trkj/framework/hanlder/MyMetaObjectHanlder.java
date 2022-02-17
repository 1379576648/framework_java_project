package com.trkj.framework.hanlder;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component//一定不要忘记把处理器加到IOC容器中！
public class MyMetaObjectHanlder implements MetaObjectHandler {
    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....    ");
        this.setFieldValByName("createdTime", new Date(), metaObject);
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....    ");
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }
}