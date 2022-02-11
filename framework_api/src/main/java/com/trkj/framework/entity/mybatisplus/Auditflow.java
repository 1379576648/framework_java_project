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
 * <p>
 * 审批主表
 * </p>
 *
 * @author 里予
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AUDITFLOW")
@KeySequence(value = "AUDITFLOW_ID",clazz = Integer.class)
public class Auditflow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Integer auditFlowId;

    @ApiModelProperty(value = "标题")
    @TableField("AUDITFLOW_TITLE")
    private String auditFlowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableField("AUDITFLOW_TYPE")
    private String auditFlowType;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "申请状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditFlowState;

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

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
