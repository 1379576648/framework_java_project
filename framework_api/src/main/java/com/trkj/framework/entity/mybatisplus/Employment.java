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
 * @author TanWei
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EMPLOYMENT")
@ApiModel(value="Employment对象", description="录用表")
@KeySequence(value = "EMPLOYMENT_ID",clazz = Integer.class)
public class Employment implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "录用编号")
    @TableId("EMPLOYMENT_ID")
    private Long employmentId;

    @ApiModelProperty(value = "录用状态")
    @TableId("EMPLOYMENT_STATE")
    private Long employmentState;

    @ApiModelProperty(value = "简历编号")
    @TableId("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "备注")
    @TableField("REMARKS")
    private String remarks;

    @ApiModelProperty(value = "录用时间")
    //@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField("EMPLOYMENT_HIREDATE")
    private Date employmentHireDate;

    @ApiModelProperty(value = "简历编号")
    @TableId("EMPLOYMENT_SALARY")
    private Long employmentSalary;

    @ApiModelProperty(value = "放弃原因")
    @TableField("WAIVE_REASON")
    private String waiveReason;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME" ,fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;
}
