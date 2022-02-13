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
 * 出差表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRAVEL")
@ApiModel(value="TRAVEL对象", description="出差")
@KeySequence(value = "TRAVEL_ID",clazz = Integer.class)
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "出差开始时间")
    @TableId("TRAVEL_S_DATE")
    private Date travelSDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "出差结束时间")
    @TableId("TRAVEL_E_DATE")
    private Date travelEDate;

    @ApiModelProperty(value = "出差总时长")
    @TableId("TRAVEL_TOTAL_DATE")
    private Integer travelTotalDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡出差时间")
    @TableId("TRAVEL_ACTUAL_TIME")
    private Date travelActualTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡结束出差时间")
    @TableId("TRAVEL_ACTUAL_OVERTIME")
    private Date travelActualOvertime;

    @ApiModelProperty(value = "实际出差时长")
    @TableId("TRAVEL_ACTUAL_TOKINAGA")
    private Integer travelActualTokinaga;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRAVEL_STATE")
    private Integer travelState;

    @ApiModelProperty(value = "出差状态 0：未开始 1：进行中 2：已完成")
    @TableField("TRAVEL_CONDITION")
    private Integer travelCondition;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

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
    private Long isDeleted;

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
