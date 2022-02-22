package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.framework.entity.mybatisplus.Resume;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "简历编号")
    @TableId("RESUME_ID")
    private Long resumeId;


    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

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

    @ApiModelProperty(value = "年龄")
    @TableField("RESUME_AGE")
    private String resumeAge;

    @ApiModelProperty(value = "介绍")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;


    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;


    @ApiModelProperty(value = "政治面貌")
    @TableField("RESUME_POLITICAL_OUTLOOK")
    private String resumePoliticalOutlook;

    @ApiModelProperty(value = "0:待阅 1:以阅 3、候选人 4：淘汰")
    @TableField("RESUME_ZT")
    private String resumeZt;

    @TableField("INVITE_STATE")
    private String inviteState;

    @ApiModelProperty(value = "投简时间")
    @TableField("TOUJ_TIME")
    private Date toujTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "学校名称")
    @TableField("EDUCATION_STUDENTNAME")
    private String educationStudentname;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "开始日期")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime1;

    @ApiModelProperty(value = "结束日期")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime1;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "开始日期")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime2;

    @ApiModelProperty(value = "结束日期")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime2;

    @ApiModelProperty(value = "所属行业")
    @TableField("POSITION_INDUSTRY")
    private String positionIndustry;

    @ApiModelProperty(value = "工作描述")
    @TableField("POSITION_DESCRIBE")
    private String positionDescribe;

    @ApiModelProperty(value = "税前月薪")
    @TableField("POSITION_SQMONTHLY")
    private Double positionSqmonthly;
}
