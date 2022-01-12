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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "面试状态")
    @TableId("INTERVIEW_STATE")
    private Long interviewState;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

    @ApiModelProperty(value = "面试官")
    @TableField("INTERVIEW_NAME")
    private String interviewName;

    @ApiModelProperty(value = "手机号码")
    @TableField("RESUME_PHONE")
    private Long resumePhone;

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
