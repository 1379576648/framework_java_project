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

/**
 * <p>
 * 角色菜单权限表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ROLE_MENU_POWER")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "ROLE_MENU_POWER_ID",clazz = Integer.class)
@ApiModel(value="RoleMenuPower对象", description="角色菜单权限表")
public class RoleMenuPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色菜单权限编号")
    @TableId("ROLE_MENU_POWER_ID")
    private Integer roleMenuPowerId;

    @ApiModelProperty(value = "角色编号")
    @TableField("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单权限编号")
    @TableField("MENU_POWER_ID")
    private Long menuPowerId;

    @ApiModelProperty(value = "是否半选择")
    @TableField("IS_CHOICE")
    private Long isChoice;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;



}
