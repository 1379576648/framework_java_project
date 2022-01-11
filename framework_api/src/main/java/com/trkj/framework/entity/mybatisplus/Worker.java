package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 转正
 * </p>
 *
 * @author suki
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WORKER")
@ApiModel(value="Worker对象", description="转正")
@KeySequence(value = "WORKER_ID",clazz = Integer.class)
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "转正编号")
    @TableId("WORKER_ID")
    private Integer workerId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "转正类型")
    @TableField("WORKER_TYPE")
    private String workerType;

    @ApiModelProperty(value = "备注")
    @TableField("WORKER_REMARKS")
    private String workerRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("WORKER_STATE")
    private Long workerState;

    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

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
