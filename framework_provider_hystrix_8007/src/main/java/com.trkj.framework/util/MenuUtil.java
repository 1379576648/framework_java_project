package com.trkj.framework.util;

import com.trkj.framework.entity.mybatisplus.MenuPower;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13795
 */
@Component
public class MenuUtil {

    /**
     * 获取子节点
     *
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<MenuPower> getChild(List<MenuPower> allMenu) {
        //子菜单
        List<MenuPower> childList = new ArrayList<MenuPower>();
        for (MenuPower menuPower: allMenu) {
            if (menuPower.getChildren().size()<=0){
                System.out.println("1111111");
                childList.add(menuPower);
            }else{
                getChild(menuPower.getChildren());
            }
        }
        return childList;
    }
}
