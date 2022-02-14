package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.mapper.RegisterLogMapper;
import com.trkj.framework.mybatisplus.service.RegisterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Service
public class RegisterLogServiceImpl implements RegisterLogService {
    @Autowired
    private RegisterLogMapper registerLogMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    @Override
    public Object selectRegisterLogAll(RegisterLog registerLog) {
        Object o = redisTemplate.opsForValue().get("RegisterLogPage:" + registerLog.toString());
        if (o == null || !o.equals("")) {
            Page<RegisterLog> page = new Page<RegisterLog>(registerLog.getCurrenPage(), registerLog.getPageSize());
            QueryWrapper<RegisterLog> queryWrapper = new QueryWrapper<>();
            if (registerLog.getRegisterLogIpname() != null && !registerLog.getRegisterLogIpname().equals("")) {
                //登录所在地模糊查询
                queryWrapper.like("REGISTER_LOG_IPNAME", registerLog.getRegisterLogIpname());
            }
            if (registerLog.getRegisterLogPeople() != null && !registerLog.getRegisterLogPeople().equals("")) {
                //用户名称模糊查询
                queryWrapper.like("REGISTER_LOG_PEOPLE", registerLog.getRegisterLogPeople());
            }
            if (registerLog.getRegisterLogState() != null) {
                //状态模糊查询
                queryWrapper.like("REGISTER_LOG_STATE", registerLog.getRegisterLogState());
            }
            if (registerLog.getStartTime() != null || registerLog.getEndTime() != null) {
                //登录时间范围查询
                queryWrapper.between("CREATED_TIME", registerLog.getStartTime(), registerLog.getEndTime());
            }
            //按照ID降序
            queryWrapper.orderByDesc("REGISTER_LOG_ID");
            IPage<RegisterLog> registerLogIPage = registerLogMapper.selectPage(page, queryWrapper);
            redisTemplate.opsForValue().set("RegisterLogPage:" + registerLog.toString(), registerLogIPage);
            return registerLogIPage;
        }
        return o;
    }

    /***
     * 删除登录日志
     * @param list
     * @return
     */
    @Override
    @Transactional
    public String checkDelete(ArrayList<Integer> list) {
        if (registerLogMapper.deleteBatchIds(list) <= 0) {
            return "删除失败";
        }
        redisTemplate.delete(redisTemplate.keys("RegisterLogPage:*"));
        return "成功";
    }

    /***
     * 清出登录日志
     * @param registerLog
     * @return
     */
    @Override
    @Transactional
    public String emptyList(@RequestBody RegisterLog registerLog) {
        //创建条件构造器
        QueryWrapper<RegisterLog> queryWrapper = new QueryWrapper<>();
        if (registerLog.getStartTime() != null || registerLog.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", registerLog.getStartTime(), registerLog.getEndTime());
        }
        List<RegisterLog> registerLogs = registerLogMapper.selectList(queryWrapper);
        for (RegisterLog registerLog1 :
                registerLogs) {
            //删除
            redisTemplate.delete(redisTemplate.keys("RegisterLog:*registerLogId=" + registerLog1.getRegisterLogId() + "*"));
        }
        if (registerLogMapper.delete(queryWrapper) <= 0) {
            return "清除失败";
        }
        redisTemplate.delete(redisTemplate.keys("RegisterLogPage:*"));
        return "成功";
    }
}
