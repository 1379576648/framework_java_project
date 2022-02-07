package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HireVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("EMPLOYMENT_ID")
    private Integer employmentId;

    @ApiModelProperty(value = "状态 0:待入职 1:已入职 2：淘汰")
    @TableField("EMPLOYMENT_STATE")
    private Long employmentState;

    @ApiModelProperty(value = "编号")
    @TableField("RESUME_ID")
    private Integer resumeId;

    @ApiModelProperty(value = "备注")
    @TableField("REMARKS")
    private String remarks;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("HIREDATE")
    private Date hiredate;

    @TableField("WAIVE_REASON")
    private String waiveReason;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("RESUME_PHONE")
    private Long resumePhone;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "照片")
    @TableField("RESUME_PHOTO")
    private String resumePhoto;

    @ApiModelProperty(value = "介绍")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "出生日期")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;

    @TableField("RECRUITMENT_PLAN_ID")
    private Integer recruitmentPlanId;

    @TableField("RESUME_POLITICAL_OUTLOOK")
    private String resumePoliticalOutlook;

    @ApiModelProperty(value = "0:待阅 1:以阅 3、候选人 4：淘汰")
    @TableField("RESUME_ZT")
    private String resumeZt;

    @TableField("INVITE_STATE")
    private String inviteState;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "投简时间")
    @TableField("TOUJ_TIME")
    private Date toujTime;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Integer deptId;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Integer deptState;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门负责人;提供ID到员工表锁定具体的人")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "部门职位编号")
    @TableId("DEPT_POST_ID")
    private Integer deptPostId;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

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
    private Long recruitmentPlanSalaryId;

    @ApiModelProperty(value = "招聘计划状态: 0 招聘中，1 已结束")
    @TableField("RECRUITMENT_ZT")
    private Long recruitmentZt;

    @ApiModelProperty(value = "编号")
    @TableId("WORK_EXPERIENCESS_ID")
    private Long workExperiencessId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "所属行业")
    @TableField("POSITION_INDUSTRY")
    private String positionIndustry;

    @ApiModelProperty(value = "工作描述")
    @TableField("POSITION_DESCRIBE")
    private String positionDescribe;

    @ApiModelProperty(value = "税前月薪")
    @TableField("POSITION_SQMONTHLY")
    private Long positionSqmonthly;

    @ApiModelProperty(value = "编号")
    @TableId("EDUCATIONSS_ID")
    private Integer educationssId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime;


    @ApiModelProperty(value = "学校名称")
    @TableField("EDUCATION_STUDENTNAME")
    private String educationStudentname;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "是否全日制")
    @TableField("EDUCATION_FULL_TIME")
    private Long educationFullTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}