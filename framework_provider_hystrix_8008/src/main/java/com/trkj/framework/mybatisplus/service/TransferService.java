package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Transfer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.vo.TransferTwoVo;
import com.trkj.framework.vo.TransferVo;

import java.util.List;

/**
 * <p>
 * 调动记录表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-10
 */
public interface TransferService {

    /**
     * 查询调动管理
     * @param transferVo
     * @return
     */
    IPage<TransferVo> selectTransfer(TransferVo transferVo);

    /**
     * 查询所有员工姓名
     * @param
     * @return
     */
    List<Staff> selectStaffName();

    /**
     * 查询所有的部门名称
     * @return
     */
    List<Dept> selectSect();

    /**
     * 根据名字查询部门名称和职位名称
     * @return
     */
    List<TransferTwoVo> selectTransferByName(TransferTwoVo transferTwoVo);

    /**
     * 根据员工姓名查询调动记录
     * @param transfer
     * @return
     */
    List<Transfer> selectTransferAlls(Transfer transfer);

    /**
     * 添加调动记录
     * @param transfer
     * @return
     */
    int insertTransfer(Transfer transfer);

    /**
     * 根据部门查询部门职位
     * @param transferTwoVo
     * @return
     */
    List<TransferTwoVo> selectPostName(TransferTwoVo transferTwoVo);



}
