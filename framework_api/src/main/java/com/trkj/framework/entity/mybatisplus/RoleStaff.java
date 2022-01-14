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

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>
 * 角色员工表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@TableName(value = "ROLE_STAFF",autoResultMap = true)
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "ROLE_STAFF_ID",clazz = Integer.class)
@ApiModel(value="RoleStaff对象", description="角色员工表")
public class RoleStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色员工编号")
    @TableId("ROLE_STAFF_ID")
    private Integer roleStaffId;

    @ApiModelProperty(value = "角色编号")
    @TableField("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;


    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;


    @ApiModelProperty(value = "员工")
    @TableField(exist = false)
    private Staff staff;

    @ApiModelProperty(value = "员工姓名")
    @TableField(exist = false)
    private String staffName;

    @ApiModelProperty(value = "员工手机号码")
    @TableField(exist = false)
    private Integer staffPhone;

    @ApiModelProperty(value = "员工状态")
    @TableField(exist = false)
    private Integer staffState;

    @ApiModelProperty(value = "员工编号集合")
    @TableField(exist = false)
    private ArrayList<Integer> list;

}
