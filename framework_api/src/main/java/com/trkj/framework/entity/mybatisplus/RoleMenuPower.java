package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value="RoleMenuPower对象", description="角色菜单权限表")
public class RoleMenuPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色菜单权限编号")
    @TableId("ROLE_MENU_POWER_ID")
    private Long roleMenuPowerId;

    @ApiModelProperty(value = "角色编号")
    @TableField("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单权限编号")
    @TableField("MENU_POWER_ID")
    private Long menuPowerId;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
