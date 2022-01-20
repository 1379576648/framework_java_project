package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.mapper.WorkerMapper;
import com.trkj.framework.mybatisplus.service.WorkerService;
import com.trkj.framework.vo.FullVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    @Override
    @Transactional
    public String insertWorker(FullVo fullVo) {
        String s = "成功";
        //转正
        Worker worker = new Worker();

        //如果数据不为空
        if(fullVo!=null){
            //员工名称
            worker.setStaffName(fullVo.getStaffName());
            //部门名称
            worker.setDeptname(fullVo.getDeptname());
            //转正类型
            worker.setWorkerType(fullVo.getWorkerType());
            //转正日期
            worker.setWorkerDate(fullVo.getWorkerDate());
            //备注
            worker.setWorkerRemarks(fullVo.getWorkerRemarks());

            //添加到转正表
            int row = workerMapper.insert(worker);

            //如果添加成功
            if(row>=1){
                s="成功";
            }else {
                return "添加失败";
            }
        }
        return s;
    }
}
