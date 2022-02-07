package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("LEAVE")
@ApiModel(value="Leave对象", description="请假")
@KeySequence(value = "LEAVE_ID",clazz = Integer.class)
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假编号")
    @TableId("LEAVE_ID")
    private Integer leaveId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划请假开始时间")
    @TableField("LEAVE_S_DATE")
    private Date leaveSDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划请假结束时间")
    @TableField("LEAVE_E_DATE")
    private Date leaveEDate;

    @ApiModelProperty(value = "计划请假总小时")
    @TableField("LEAVE_TOTAL_DATE")
    private Integer leaveTotalDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡请假时间")
    @TableField("LEAVE_ACTUAL_TIME")
    private Date leaveActualTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡结束请假时间")
    @TableField("LEAVE_ACTUAL_OVERTIME")
    private Date leaveActualOvertime;

    @ApiModelProperty(value = "实际请假时长")
    @TableField("LEAVE_ACTUAL_TOKINAGA")
    private Integer leaveActualToKinAga;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("LEAVE_STATE")
    private Integer leaveState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
