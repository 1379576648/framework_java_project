package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TanWei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;


    @ApiModelProperty(value = "招聘计划名称")
    @TableField("RECRUITMENT_PLAN_NAME")
    private String recruitmentPlanName;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门职位编号")
    @TableId("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "部门职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "需求人数")
    @TableId("RECRUITMENT_PLAN_NUMBER")
    private Long recruitmentPlanNumber;

    @ApiModelProperty(value = "招聘计划开始时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField("RECRUITMENT_PLAN_START_TIME")
    private Date recruitmentPlanStartTime;

    @ApiModelProperty(value = "招聘状态")
    @TableId("RECRUITMENT_ZT")
    private Long recruitmentZt;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
