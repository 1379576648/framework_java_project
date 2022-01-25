package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.DefScheme;
import com.trkj.framework.entity.mybatisplus.Staff;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-19
 */
public interface DefInsuredService  {

    /***
     * 通过状态查询社保方案
     * @param defInsured
     * @return
     */
    Object selectDefInsured(DefInsured defInsured);


    /***
     * 删除社保方案
     * @param integer
     * @return
     */
    String deleteDefInsured(Integer integer);

    /***
     * 修改社保方案状态
     * @param integer
     * @return
     */
    String updateDefInsuredState(Integer integer);

    /***
     * 通过编号查询社保方案数据
     * @param integer
     * @return
     */
    DefInsured selectDefInsuredId(Integer integer);


    /***
     * 通过外键查询方案数据
     * @param integer
     * @return
     */
    Object listSelectDefScheme(Integer integer);


    /***
     * 添加社保方案
     * @param objectMap
     * @return
     */
    String addDefInsured(Map<String,Object> objectMap);

    /***
     * 修改社保方案
     * @param objectMap
     * @return
     */
    String updateDefInsured(Map<String,Object> objectMap);

    /***
     * 查询方案名称
     * @param name
     * @return
     */
    Object selectDefInsuredName(String name);

    /***
     * 查询所有的社保方案
     * @return
     */
    Object selectDefInsuredListName();

    /***
     * 查询所有的员工
     * @param staff
     * @return
     */
    Object pageStaff(Staff staff);

    /***
     * 查询所有的部门列表
     * @return
     */
    Object deptList();

    /***
     * 参保提交
     * @param map
     * @return
     */
    String insuredSubmit(@RequestBody Map<String,Object> map);
}
