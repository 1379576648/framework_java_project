package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Transfer;
import com.trkj.framework.mybatisplus.mapper.TransferMapper;
import com.trkj.framework.mybatisplus.service.TransferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.vo.TransferTwoVo;
import com.trkj.framework.vo.TransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 * 调动记录表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2022-01-10
 */
@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferMapper transferMapper;
    /**
     * 查询调动管理
     * @param transferVo
     * @return
     */
    @Override
    public IPage<TransferVo> selectTransfer(TransferVo transferVo) {
        Page<TransferVo> page = new Page<>(transferVo.getCurrentPage(),transferVo.getPagesize());
        QueryWrapper<TransferVo> queryWrapper = new QueryWrapper<>();
        //根据名称查询
        if(transferVo.getStaffName()!=null){
            queryWrapper.like("s.STAFF_NAME",transferVo.getStaffName());
        }
        return transferMapper.selectTransfer(page,queryWrapper);
    }

    /**
     * 查询所有员工姓名
     * @param
     * @return
     */
    @Override
    public List<Staff> selectStaffName() {
        return transferMapper.selectStaffName();
    }

    /**
     * 查询所有的部门名称
     * @return
     */
    @Override
    public List<Dept> selectSect() {
        return transferMapper.selectSect();
    }

    /**
     * 查询所有的职位名称
     * @return
     */
    @Override
    public List<DeptPost> selectJob() {
        return transferMapper.selectJob();
    }

    /**
     * 根据名称查询部门名称和职位名称
     * @param transferTwoVo
     * @return
     */
    @Override
    public List<TransferTwoVo> selectTransferByName(TransferTwoVo transferTwoVo) {
        QueryWrapper<TransferTwoVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s.STAFF_NAME",transferTwoVo.getStaffName());
        return transferMapper.selectTransferByName(queryWrapper);
    }

    /**
     * 根据员工姓名查询调动记录
     * @param transfer
     * @return
     */
    @Override
    public List<Transfer> selectTransferAlls(Transfer transfer) {
        QueryWrapper<Transfer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME",transfer.getStaffName());
        return transferMapper.selectTransferAlls(queryWrapper);
    }

}
