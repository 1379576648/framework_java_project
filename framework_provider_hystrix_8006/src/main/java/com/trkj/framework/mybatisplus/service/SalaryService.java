
package com.trkj.framework.mybatisplus.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.vo.WageVo;

public interface SalaryService {

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    int insertSalary(Salary salary);

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    IPage<WageVo> selectSalary(WageVo wageVo);

}
