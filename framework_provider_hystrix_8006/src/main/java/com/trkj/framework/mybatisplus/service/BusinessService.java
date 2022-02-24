package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Business;
import com.trkj.framework.vo.BusinessVo;

import java.util.List;

public interface BusinessService {

    /**
     * 查询出差方案
     * @param businessVo
     * @return
     */
    IPage<BusinessVo> selectBusiness(BusinessVo businessVo);

    /**
     * 添加出差方案
     * @param business
     * @return
     */
    int insertBusiness(Business business);


    /**
     * 修改状态为禁用
     * @param business
     * @return
     */
    int updateBusinessState(Business business);

    /**
     * 修改状态为启用
     * @param business
     * @return
     */
    int updateBusinessStateTwo(Business business);

    /**
     * 删除出差方案
     * @param id
     * @return
     */
    String deleteBusiness(Integer id);

    /**
     * 根据id查询出差方案
     * @param business
     * @return
     */
    List<Business> selectBusinessAll(Business business);

    /**
     * 修改出差方案
     * @param business
     * @return
     */
    int updateBusiness(Business business);
}
