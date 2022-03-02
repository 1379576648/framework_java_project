package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 考勤归档表
 * </p>
 *
 * @author 里予
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ARCHIVE")
@KeySequence(value = "ARCHIVE_ID",clazz = Integer.class)
public class Archive implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "归档编号")
    @TableId("ARCHIVE_ID")
    private Integer archiveId;

    @ApiModelProperty(value = "归档名称")
    @TableField("ARCHIVE_NAME")
    private String archiveName;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "正常次数")
    @TableField("NORMAL_FREQUENCY")
    private Integer normalFrequency;

    @ApiModelProperty(value = "迟到次数")
    @TableField("LATE_FREQUENCY")
    private Integer lateFrequency;

    @ApiModelProperty(value = "旷工次数")
    @TableField("ABSENTEEISM_FREQUENCY")
    private Integer absenteeismFrequency;

    @ApiModelProperty(value = "早退次数")
    @TableField("LEAVE_EARLY_FREQUENCY")
    private Integer leaveEarlyFrequency;

    @ApiModelProperty(value = "是否全勤")
    @TableField("PRESENT")
    private String present;

    @ApiModelProperty(value = "应出勤天数")
    @TableField("ATTENDANCE_DAYS")
    private Integer attendanceDays;

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
    private Integer revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Integer isDeleted;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;
}
