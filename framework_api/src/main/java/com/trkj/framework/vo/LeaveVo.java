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
 * 请假审批VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveVo implements Serializable {
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
    private Long auditflowdeatistate;

    @ApiModelProperty(value = "请假编号")
    @TableId("LEAVE_ID")
    private Integer leaveId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptname;

    @ApiModelProperty(value = "请假类型")
    @TableField("LEAVE_TYPE")
    private String leaveType;

    @ApiModelProperty(value = "请假事由")
    @TableField("LEAVE_MATTER")
    private String leaveMatter;

    @ApiModelProperty(value = "备注")
    @TableField("LEAVE_REMARKS")
    private String leaveRemarks;

    @ApiModelProperty(value = "请假开始时间")
    @TableField("LEAVE_S_DATE")
    private Date leaveSDate;

    @ApiModelProperty(value = "请假结束时间")
    @TableField("LEAVE_E_DATE")
    private Date leaveEDate;

    @ApiModelProperty(value = "请假总小时")
    @TableField("LEAVE_TOTAL_DATE")
    private Integer leaveTotalDate;

}
