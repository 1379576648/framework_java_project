package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 招聘计划表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("RECRUITMENT_PLAN")
@ApiModel(value="RecruitmentPlan对象", description="招聘计划表")
@KeySequence(value = "RECRUITMENT_PLAN_ID",clazz = Long.class)
public class RecruitmentPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "招聘计划名称")
    @TableField("RECRUITMENT_PLAN_NAME")
    private String recruitmentPlanName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Integer deptId;

    @ApiModelProperty(value = "部门职位编号")
    @TableField("DEPT_POST_ID")
    private Integer deptPostId;

    @ApiModelProperty(value = "学历名称")
    @TableField("EDUCATION_NAME")
    private String educationName;

    @ApiModelProperty(value = "需招聘人数")
    @TableField("RECRUITMENT_PLAN_NUMBER")
    private Long recruitmentPlanNumber;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    @TableField("RECRUITMENT_PLAN_START_TIME")
    private Date recruitmentPlanStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    @TableField("RECRUITMENT_PLAN_END_TIME")
    private Date recruitmentPlanEndTime;

    @ApiModelProperty(value = "月薪范围")
    @TableField("RECRUITMENT_PLAN_SALARY_ID")
    private Integer recruitmentPlanSalaryId;

    @ApiModelProperty(value = "招聘计划状态: 0 招聘中，1 已结束")
    @TableField("RECRUITMENT_ZT")
    private Long recruitmentZt;

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




}
