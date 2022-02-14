package com.trkj.framework.annotation;

import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.mybatisplus.mapper.OperatLogMapper;
import com.trkj.framework.util.CompressUtil;
import com.trkj.framework.util.JwtTokenUtil;
import io.jsonwebtoken.SignatureException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private CompressUtil compressUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @AfterReturning(value = "@annotation(io.swagger.annotations.ApiOperation)", returning = "value")
    public void OperationHandler(JoinPoint joinPoint, Object value) throws InstantiationException, IllegalAccessException {
        log.info("开始记录操作日志》》》》》》》》》》》》》");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        byte [] gzip = null;
        HttpServletRequest request = attributes.getRequest();
        OperatLog operatLog = new OperatLog();
        String token = "";
        try {
            token = request.getHeader("Authorization").split(" ")[1];
        } catch (Exception e) {
            throw new SignatureException("未登录，请先登录");
        }
        try {
            //员工名称
            operatLog.setOperatLogPeople(jwtTokenUtil.getUsernameFromToken(token));
            //员工编号
            operatLog.setStaffId(Long.valueOf(jwtTokenUtil.getUserIdFromToken(token)));
            //员工职位
            operatLog.setOperatLogPost(jwtTokenUtil.getUserPostNameFromToken(token));
        } catch (Exception e) {
            throw new SignatureException("登录失效，请重新登录");
        }
        // 获取注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //请求方法
        gzip=compressUtil.gZip((method.getDeclaringClass().getName() + method.getName()).getBytes());
        operatLog.setOperatLogMethod(gzip.toString());
        redisTemplate.opsForValue().set("Clob:"+ gzip.toString()
                ,gzip);
        //请求参数
        gzip=compressUtil.gZip(Arrays.toString(joinPoint.getArgs()).getBytes());
        operatLog.setOperatLogRequestParameter(gzip.toString());
        redisTemplate.opsForValue().set("Clob:"+
                        gzip.toString()
                , gzip);
        //返回参数
        gzip=compressUtil.gZip(value.toString().getBytes());
        operatLog.setOperatLogReturnParameters(gzip.toString());
        redisTemplate.opsForValue().set("Clob:"+
                        gzip.toString()
                , gzip);

        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        //操作模块
        operatLog.setOperatLogModule(apiOperation.notes());
        //操作类型
        operatLog.setOperatLogType(apiOperation.nickname());
        //请求方式
        operatLog.setOperatLogRequest(apiOperation.httpMethod());
        //请求地址
        gzip=compressUtil.gZip(apiOperation.produces().getBytes());
        operatLog.setOperatLogUrl(gzip.toString());
        redisTemplate.opsForValue().set("Clob:"+
                        gzip.toString()
                ,gzip);
        //操作内容
        gzip=compressUtil.gZip(apiOperation.value().getBytes());
        operatLog.setOperatLogContent(gzip.toString());
        redisTemplate.opsForValue().set("Clob:"+
                        gzip.toString()
                , gzip);
        operatLogMapper.insert(operatLog);
        //删除缓存数据
        redisTemplate.delete(redisTemplate.keys("OperatLogPage:*"));
        //添加缓存
        redisTemplate.opsForValue().set("OperatLog:"+operatLog.toString(),operatLog);
        log.info("结束记录操作日志》》》》》》》》》》》》》");
    }

}