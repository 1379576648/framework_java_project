package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.MoneyPigeonhole;

import java.util.List;

public interface MoneyPigeonholeService {

    /**
     * 查询工资未归档
     * @param moneyPigeonhole
     * @return
     */
    IPage<MoneyPigeonhole> selectMoney(MoneyPigeonhole moneyPigeonhole);

    /**
     * 统计未归档工资
     * @param moneyPigeonhole
     * @return
     */
    Object countMoney(MoneyPigeonhole moneyPigeonhole);

    /**
     * 查询已归档工资表
     * @param moneyPigeonhole
     * @return
     */
    IPage<MoneyPigeonhole> selectMoneys(MoneyPigeonhole moneyPigeonhole);

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
    List<MoneyPigeonhole> selectstatc(MoneyPigeonhole moneyPigeonhole);

    /**
     * 统计已归档工资
     * @param moneyPigeonhole
     * @return
     */
    Object countMoneys(MoneyPigeonhole moneyPigeonhole);

    /**
     * 修改状态为已归档
     * @param moneyPigeonhole
     * @return
     */
    int updateMoney(MoneyPigeonhole moneyPigeonhole);

    /**
     * 薪酬统计
     * @param moneyPigeonhole
     * @return
     */
    Object selectstatcis(MoneyPigeonhole moneyPigeonhole);


}
