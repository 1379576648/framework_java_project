package com.trkj.framework.mybatisplus.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.mybatisplus.mapper.SalaryMapper;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.vo.WageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalaryServicelmpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 添加调薪
     * @param salary
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSalary(Salary salary) {
        return salaryMapper.insert(salary);
    }

    /**
     * 查询调薪
     * @param wageVo
     * @return
     */
    @Override
    public IPage<WageVo> selectSalary(WageVo wageVo) {
        Page<WageVo> page = new Page<>(wageVo.getCurrentPage(),wageVo.getPagesize());
        QueryWrapper<WageVo> queryWrapper = new QueryWrapper<>();
        //根据部门名称查询
        if(wageVo.getDeptName()!=null){
            queryWrapper.like("d.DEPT_NAME",wageVo.getDeptName());
        }
        return salaryMapper.selectSalary(page,queryWrapper);
    }
}
