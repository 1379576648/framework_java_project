package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.InsuredArchive;
import com.trkj.framework.entity.mybatisplus.InsuredDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * <p>
 * 参保明细表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
public interface InsuredDetailService {
    /***
     * 分页查询参保明细
     * @param insuredDetail
     * @return
     */
    Object selectPageIsuredDetail(InsuredDetail insuredDetail);
    /***
     * 查询所有的部门列表
     * @return
     */
    Object deptList();

    /***
     * 多选删除参保记录
     * @param insuredDetail
     * @return
     */
    String deleteInsuredDetail(InsuredDetail insuredDetail);

    /****
     * 归档
     * @return
     */
    String pigeonhole();


    /****
     * 归档数据查询
     * @param insuredArchive
     * @return
     */
    Object archived(InsuredArchive insuredArchive);


    /***
     * 查询某一个月份的归档明细
     * @param name
     * @return
     */
    Object archivedInMonth(String name);


    /***
     * 删除某一个月的归档数据
     * @param map
     * @return
     */
    String deleteArchivedInName(Map<String,Object> map);

    /***
     * 通过员工名称获取职位名称
     * @param name
     * @return
     */
    String selectPostName(String name);


    /***
     * 通过明细编号查询
     * @param id
     * @return
     */
    Object selectListScheme(Integer id);


    /***
     * 查询某一个员工某一个月的参保日志
     * @param name
     * @param month
     * @return
     */
    Object selectInsuredLog(String name,String month);


}
