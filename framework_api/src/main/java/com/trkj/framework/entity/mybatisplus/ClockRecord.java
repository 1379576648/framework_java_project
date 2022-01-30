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
 * 打卡记录表
 * @author 112729
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLOCK_RECORD")
@ApiModel(value="ClockRecord对象", description="打卡记录")
@KeySequence(value = "CLOCK_RECORD_ID",clazz = Integer.class)
public class ClockRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "打卡记录编号")
    @TableId("CLOCK_RECORD_ID")
    private Integer clockRecordId;

    @ApiModelProperty(value = "员工名称")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门名称")
    @TableId("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "早上打卡时间")
    @TableId("MORN_CLOCK")
    private Date mornClock;

    @ApiModelProperty(value = "下午打卡时间")
    @TableId("AFTERNOON_CLOCK")
    private Date afternoonClock;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableId("IS_DELETED")
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
