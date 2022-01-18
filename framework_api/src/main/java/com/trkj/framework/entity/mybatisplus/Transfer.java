package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 调动记录表
 * </p>
 *
 * @author suki
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRANSFER")
@ApiModel(value="Transfer对象", description="调动记录表")
@KeySequence(value = "TRANSFER_ID",clazz = Integer.class)
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调动记录编号")
    @TableId("TRANSFER_ID")
    private Integer transferId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "异动类型")
    @TableField("TRANSFER_TYPE")
    private String transferType;

    @ApiModelProperty(value = "原部门名称")
    @TableField("CREATED_DEPT_NAME")
    private String createdDeptName;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRANSFER_STATE")
    private Integer transferState;

    @ApiModelProperty(value = "变动后部门名称")
    @TableField("UPDATED_DEPT_NAME")
    private String updatedDeptName;

    @ApiModelProperty(value = "原部门职位名称")
    @TableField("TRANSFER_RAWPOST_NAME")
    private String transferRawpostName;

    @ApiModelProperty(value = "变动后部门职位名称")
    @TableField("TRANSFER_AFTERPOST_NAME")
    private String transferAfterpostName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "生效日期")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

    @ApiModelProperty(value = "备注")
    @TableField("TRANSFER_REMARK")
    private String transferRemark;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
