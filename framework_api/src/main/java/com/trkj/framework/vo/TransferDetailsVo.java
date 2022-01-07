package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 审批调动明细详情
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetailsVo  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "审批标题")
    @TableField("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "当前审批状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditflowstate;

    @ApiModelProperty(value = "审批人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "审核备注")
    @TableField("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "审核时间")
    @TableField("AUDITFLOWDETAI_DATE")
    private Date auditflowdetaiDate;

    @ApiModelProperty(value = "异动类型")
    @TableField("TRANSFER_TYPE")
    private String transfertype;

    @ApiModelProperty(value = "原部门名称")
    @TableField("CREATED_DEPT_NAME")
    private String createddeptname;

    @ApiModelProperty(value = "变动后部门名称")
    @TableField("UPDATED_DEPT_NAME")
    private String updateddeptname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "生效日期")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeeffectdate;
}

