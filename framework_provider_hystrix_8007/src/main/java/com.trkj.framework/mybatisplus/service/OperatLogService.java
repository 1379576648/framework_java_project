package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

/**
 * @author 13795
 */
public interface OperatLogService {
    /***
     * 操作日志分页查询
     * @param operatLog
     * @return
     */
   Object selectOperatLogAll(OperatLog operatLog);

    /***
     * 多选删除
     * @param list
     * @return
     */
    String checkDelete(ArrayList<Integer> list);

    /***
     *  清出数据
     * @param operatLog
     * @return
     */
    String emptyList(@RequestBody OperatLog operatLog);
}
