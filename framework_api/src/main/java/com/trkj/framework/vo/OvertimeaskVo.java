package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 加班审批VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeaskVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

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
    private Long auditflowState;

    @ApiModelProperty(value = "审批明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;

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
    private String auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableId("AUDITFLOWDETAI_STATE")
    private Long auditflowdeatiState;

    @ApiModelProperty(value = "加班表编号")
    @TableId("OVERTIMEASK_ID")
    private Long overtimeaskId;

    @ApiModelProperty(value = "发起人部门")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "加班类型")
    @TableField("OVERTIMEASK_TYPE")
    private String overtimeaskType;

    @ApiModelProperty(value = "加班事由")
    @TableField("OVERTIMEASK_MATTER")
    private String overtimeaskMatter;

    @ApiModelProperty(value = "备注")
    @TableField("OVERTIMEASK_REMARKS")
    private String overtimeaskRemarks;

    @ApiModelProperty(value = "加班开始时间")
    @TableField("OVERTIMEASK_S_DATE")
    private Date overtimeaskSDate;

    @ApiModelProperty(value = "加班结束时间")
    @TableField("OVERTIMEASK_E_DATE")
    private Date overtimeaskEDate;

    @ApiModelProperty(value = "加班总小时")
    @TableField("OVERTIMEASK_TOTAL_DATE")
    private Long overtimeaskTotalDate;


}
