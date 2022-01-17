package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 出差表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRAVEL")
@ApiModel(value="TRAVEL对象", description="出差")
@KeySequence(value = "WORKER_ID",clazz = Integer.class)
public class Travel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Integer travelId;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "发起人部门名称")
    @TableId("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "出差地点")
    @TableId("TRAVEL_PLACE")
    private String travelPlace;

    @ApiModelProperty(value = "出差事由")
    @TableId("TRAVEL_MATTER")
    private String travelMatter;

    @ApiModelProperty(value = "出差开始时间")
    @TableId("TRAVEL_S_DATE")
    private Date travelSDate;

    @ApiModelProperty(value = "出差结束时间")
    @TableId("TRAVEL_E_DATE")
    private Date travelEDate;

    @ApiModelProperty(value = "出差总时长")
    @TableId("TRAVEL_TOTAL_DATE")
    private Date travelTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("WORKER_STATE")
    private Long workerState;

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
