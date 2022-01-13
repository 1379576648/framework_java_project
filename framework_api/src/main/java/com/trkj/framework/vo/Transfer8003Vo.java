package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 调动审批VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer8003Vo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "标题")
    @TableId("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableId("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "申请状态")
    @TableId("AUDITFLOW_STATE")
    private Integer auditflowState;

    @ApiModelProperty(value = "审批明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Integer auditflowdetailId;

    @ApiModelProperty(value = "审核人1")
    @TableId("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核人2")
    @TableId("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "审核人3")
    @TableId("STAFF_NAME")
    private String staffName3;

    @ApiModelProperty(value = "审核备注")
    @TableId("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @ApiModelProperty(value = "审核日期")
    @TableId("AUDITFLOWDETAI_DATE")
    private Date auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableId("AUDITFLOWDETAI_STATE")
    private Integer auditflowdeatistate;

    @ApiModelProperty(value = "异动类型")
    @TableId("TRANSFER_TYPE")
    private String transfertype;

    @ApiModelProperty(value = "原部门名称")
    @TableId("CREATED_DEPT_NAME")
    private String createddeptname;

    @ApiModelProperty(value = "变动后部门名称")
    @TableId("UPDATED_DEPT_NAME")
    private String updatedeptname;

    @ApiModelProperty(value = "生效日期")
    @TableId("TAKE_EFFECT_DATE")
    private Date takeeffectdate;

    @ApiModelProperty(value = "备注")
    @TableId("TRANSFER_REMARK")
    private String transferremark;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableId("IS_DELETED")
    private Long isdeleted;

}
