package com.trkj.framework.annotation;

import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.mybatisplus.mapper.OperatLogMapper;
import com.trkj.framework.util.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-08-24 10:58
 **/
@Slf4j
@Order
@Aspect
@Component
public class OperationAspect {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private OperatLogMapper operatLogMapper;

    @AfterReturning(value = "@annotation(io.swagger.annotations.ApiOperation)" ,returning = "value")
    public void OperationHandler(JoinPoint joinPoint,Object value) throws InstantiationException, IllegalAccessException {
        log.info("开始记录操作日志》》》》》》》》》》》》》");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token =request.getHeader("Authorization").split(" ")[1];
        OperatLog operatLog = new OperatLog();
        //员工名称
        operatLog.setOperatLogPeople(jwtTokenUtil.getUsernameFromToken(token));
        //员工编号
        operatLog.setStaffId(Long.valueOf(jwtTokenUtil.getUserIdFromToken(token)));
        //员工职位
        operatLog.setOperatLogPost(jwtTokenUtil.getUserPostNameFromToken(token));
        // 获取注解
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //请求方法
        operatLog.setOperatLogMethod(method.getDeclaringClass().getName()+method.getName());
        //请求参数
        operatLog.setOperatLogRequestParameter(Arrays.toString(joinPoint.getArgs()));
        //返回参数
        operatLog.setOperatLogReturnParameters(value.toString());
//        Map<String,Object> map = (Map<String, Object>) value;
//        IPage<DefInsured> page = (IPage<DefInsured>) map.get("info");
//        System.out.println(page.getRecords());
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        //操作模块
        operatLog.setOperatLogModule(apiOperation.notes());
        //操作类型
        operatLog.setOperatLogType(apiOperation.nickname());
        //请求方法
        operatLog.setOperatLogRequest(apiOperation.httpMethod());
        //请求地址
        operatLog.setOperatLogUrl(apiOperation.produces());
        //操作内容
        operatLog.setOperatLogContent(apiOperation.value());
        operatLogMapper.insert(operatLog);
        log.info("结束记录操作日志》》》》》》》》》》》》》");
    }

}