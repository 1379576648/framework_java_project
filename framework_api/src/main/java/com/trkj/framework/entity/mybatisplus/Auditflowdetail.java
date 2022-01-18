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
 * 审批流明细表
 * </p>
 *
 * @author 里予
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AUDITFLOWDETAIL")
@ApiModel(value="Auditflowdetail对象", description="审批流明细表")
@KeySequence(value = "AUDITFLOWDETAIL_ID",clazz = Integer.class)
public class Auditflowdetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批流明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Integer auditflowdetailId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "审核备注")
    @TableField("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @ApiModelProperty(value = "审核时间")
    @TableField("AUDITFLOWDETAI_DATE")
    private Date auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Integer auditflowdetaiState;

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

    @ApiModelProperty(value = "审批流明细编号")
    @TableField(exist = false)
    private Long auditflowdetailId2;

    @ApiModelProperty(value = "审批流明细编号")
    @TableField(exist = false)
    private Long auditflowdetailId3;

    @ApiModelProperty(value = "审批类型")
    @TableField(exist = false)
    private String auditflowType;

    @ApiModelProperty(value = "申请人")
    @TableField(exist = false)
    private String staffName1;

}
