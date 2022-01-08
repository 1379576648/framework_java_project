package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MENU_POWER")
@ApiModel(value="MenuPower对象", description="")
public class MenuPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("MENU_POWER_ID")
    private Integer menuPowerId;

    @TableField("MENU_POWER_PID")
    private Long menuPowerPid;

    @TableField("MENU_POWER_ORDER")
    private Long menuPowerOrder;

    @TableField("MENU_POWER_LEAF")
    private Long menuPowerLeaf;

    @TableField("MENU_POWER_TYPE")
    private Long menuPowerType;

    @TableField("MENU_POWER_STATE")
    private Long menuPowerState;

    @TableField("MENU_POWER_NAME")
    private String menuPowerName;

    @TableField("MENU_POWER_ROUTE")
    private String menuPowerRoute;

    @TableField("PICTURE_ADDRESS")
    private String pictureAddress;

    @TableField("MENU_POWER_MODULE")
    private String menuPowerModule;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @TableField("REVISION")
    private Long revision;

    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField(exist = false)
   private List<MenuPower> list;

}
