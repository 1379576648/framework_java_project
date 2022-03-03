package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author TanWei
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Interview")
@ApiModel(value="Interview对象", description="面试表")
@KeySequence(value = "INTERVIEW_ID",clazz = Integer.class)
public class Interview {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "面试编号")
    @TableId("INTERVIEW_ID")
    private Integer interviewId;

    @ApiModelProperty(value = "简历编号")
    @TableId("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "被面试人")
    @TableField("INTERVIEW_BNAME")
    private String interviewBname;

    @ApiModelProperty(value = "面试日期")
    @TableField("INTERVIEW_TIME")
    private Date interviewTime;

    @ApiModelProperty(value = "状态")
    @TableField("INTERVIEW_STATE")
    private Integer interviewState;

    @ApiModelProperty(value = "面试评价")
    @TableField("INTERVIEW_EVALUATE")
    private String interviewEvaluate;

    @ApiModelProperty(value = "面试官姓名")
    @TableField("INTERVIEW_Name")
    private String interviewName;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "录用编号")
    @TableField(exist = false)
    @TableId("EMPLOYMENT_ID")
    private Integer employmentId;

}
