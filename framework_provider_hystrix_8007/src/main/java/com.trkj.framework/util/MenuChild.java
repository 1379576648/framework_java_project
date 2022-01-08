package com.trkj.framework.util;

import com.trkj.framework.entity.mybatisplus.MenuPower;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13795
 */
@Component
public class MenuChild {
    /**
     * 获取子节点
     *
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<MenuPower> getChild(int id, List<MenuPower> allMenu) {
        //子菜单
        List<MenuPower> childList = new ArrayList<MenuPower>();
        for (MenuPower nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (nav.getMenuPowerPid() == id) {
                childList.add(nav);
            }
        }
        //递归
        for (MenuPower nav : childList) {
            nav.setList(getChild(nav.getMenuPowerId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<MenuPower>();
        }
        return childList;
    }
}
