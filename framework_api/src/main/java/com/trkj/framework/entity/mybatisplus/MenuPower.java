package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * @author 13795
 * @author 劉祁
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MENU_POWER")
@ApiModel(value = "MenuPower对象", description = "")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "MENU_POWER_ID",clazz = Integer.class)
public class MenuPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("MENU_POWER_ID")
    private Integer menuPowerId;


    @ApiModelProperty(value = "父编号")
    @TableField("MENU_POWER_PID")
    private Long menuPowerPid;


    @ApiModelProperty(value = "菜单顺序")
    @TableField("MENU_POWER_ORDER")
    private Long menuPowerOrder;


    @ApiModelProperty(value = "是否有叶子")
    @TableField("MENU_POWER_LEAF")
    private Long menuPowerLeaf;


    @ApiModelProperty(value = "菜单类型")
    @TableField("MENU_POWER_TYPE")
    private Long menuPowerType;


    @ApiModelProperty(value = "菜单状态")
    @TableField("MENU_POWER_STATE")
    private Long menuPowerState;


    @ApiModelProperty(value = "菜单名称")
    @TableField("MENU_POWER_NAME")
    private String menuPowerName;

    @ApiModelProperty(value = "路由地址")
    @TableField("MENU_POWER_ROUTE")
    private String menuPowerRoute;

    @ApiModelProperty(value = "图片路径")
    @TableField("PICTURE_ADDRESS")
    private String pictureAddress;

    @ApiModelProperty(value = "组件地址")
    @TableField("MENU_POWER_MODULE")
    private String menuPowerModule;


    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;


    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<MenuPower> children;


    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;
}
