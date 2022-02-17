package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.mybatisplus.mapper.OperatLogMapper;
import com.trkj.framework.mybatisplus.service.OperatLogService;
import com.trkj.framework.util.UncompressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 13795
 */
@Service
public class OperatLogServiceImpl implements OperatLogService {
    @Autowired
    private OperatLogMapper operatLogMapper;
    @Autowired
    private UncompressUtil uncompressUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    /***
     * 分页查询操作日志
     * @param operatLog
     * @return
     */
    @Override
    public Object selectOperatLogAll(OperatLog operatLog) {
        Page<OperatLog> page = new Page<OperatLog>(operatLog.getCurrenPage(), operatLog.getPageSize());
        QueryWrapper<OperatLog> queryWrapper = new QueryWrapper<>();
        if (operatLog.getOperatLogModule() != null && !operatLog.getOperatLogModule().equals("")) {
            //操作模块模糊查询
            queryWrapper.like("OPERAT_LOG_MODULE", operatLog.getOperatLogModule());
        }
        if (operatLog.getOperatLogPeople() != null && !operatLog.getOperatLogPeople().equals("")) {
            //用户名称模糊查询
            queryWrapper.like("OPERAT_LOG_PEOPLE", operatLog.getOperatLogPeople());
        }
        if (operatLog.getOperatLogType() != null) {
            //操作类型模糊查询
            queryWrapper.like("OPERAT_LOG_TYPE", operatLog.getOperatLogType());
        }
        if (operatLog.getStartTime() != null || operatLog.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", operatLog.getStartTime(), operatLog.getEndTime());
        }
        //按照ID降序
        queryWrapper.orderByDesc("OPERAT_LOG_ID");
        IPage<OperatLog> operatLogIPage = operatLogMapper.selectPage(page, queryWrapper);
        for (OperatLog operatLog1 :
                operatLogIPage.getRecords()) {
            operatLog1.setOperatLogUrl(
                    uncompressUtil.uncompress(
                            redisTemplate.opsForValue().get("Clob:" +
                                    operatLog1.getOperatLogUrl()
                            ).toString()));
            operatLog1.setOperatLogMethod(
                    uncompressUtil.uncompress(
                            redisTemplate.opsForValue().get("Clob:" +
                                    operatLog1.getOperatLogMethod()
                            ).toString()));
            operatLog1.setOperatLogRequestParameter(
                    uncompressUtil.uncompress(
                            redisTemplate.opsForValue().get("Clob:" +
                                    operatLog1.getOperatLogRequestParameter()
                            ).toString()));
            operatLog1.setOperatLogReturnParameters(
                    uncompressUtil.uncompress(
                            redisTemplate.opsForValue().get("Clob:" +
                                    operatLog1.getOperatLogReturnParameters()
                            ).toString()));
            operatLog1.setOperatLogContent(
                    uncompressUtil.uncompress(
                            redisTemplate.opsForValue().get("Clob:" +
                                    operatLog1.getOperatLogContent()
                            ).toString()));
        }
        return operatLogIPage;
    }

    /***
     * 多选删除操作日志
     * @param list
     * @return
     */
    @Override
    public String checkDelete(ArrayList<Integer> list) {
        for (Integer integer :
                list) {
            OperatLog operatLog = new OperatLog();
            operatLog = operatLogMapper.selectById(integer);
            //请求地址
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog.getOperatLogUrl()));
            //请求参数
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog.getOperatLogRequestParameter()));
            //返回参数
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog.getOperatLogReturnParameters()));
            //请求方法
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog.getOperatLogMethod()));
            //请求内容
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog.getOperatLogContent()));
        }
        //通过ID删除表数据
        if (operatLogMapper.deleteBatchIds(list) <= 0) {
            return "删除失败";
        }
        return "成功";
    }

    /***
     * 时间段删除操作日志
     * @param operatLog
     * @return
     */
    @Override
    public String emptyList(OperatLog operatLog) {
        //创建条件构造器
        QueryWrapper<OperatLog> queryWrapper = new QueryWrapper<>();
        if (operatLog.getStartTime() != null || operatLog.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", operatLog.getStartTime(), operatLog.getEndTime());
        }
        List<OperatLog> operatLogs = operatLogMapper.selectList(queryWrapper);
        for (OperatLog operatLog1 :
                operatLogs) {
            //请求地址
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog1.getOperatLogUrl()));
            //请求参数
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog1.getOperatLogRequestParameter()));
            //返回参数
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog1.getOperatLogReturnParameters()));
            //请求方法
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog1.getOperatLogMethod()));
            //请求内容
            redisTemplate.delete("Clob:" + redisTemplate.keys(operatLog1.getOperatLogContent()));
        }
        //通过编号删除
        if (operatLogMapper.delete(queryWrapper) <= 0) {
            return "清除失败";
        }
        return "成功";
    }
}
