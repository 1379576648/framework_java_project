package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 13795
 * @author 13795
 * @author 劉祁
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ROLE")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "ROLE_ID",clazz = Integer.class)
@ApiModel(value = "Role对象", description = "角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色编号")
    @TableId("ROLE_ID")
    private Integer roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField("ROLE_NAME")
    private String roleName;

    @ApiModelProperty(value = "角色状态 0:启用 1:禁用")
    @TableField("ROLE_STATE")
    private Integer roleState;

    @ApiModelProperty(value = "角色描述")
    @TableField("ROLE_DESCRIBE")
    private String roleDescribe;

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

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;


    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;

    @ApiModelProperty(value = "菜单列表")
    @TableField(exist = false)
    private ArrayList<Integer> menuList;
}
