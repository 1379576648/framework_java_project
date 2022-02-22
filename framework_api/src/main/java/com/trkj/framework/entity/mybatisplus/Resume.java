package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简历表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("RESUME")
@ApiModel(value="Resume对象", description="简历表")
@KeySequence(value = "RESUME_ID",clazz = Long.class)
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "年龄")
    @TableField("RESUME_AGE")
    private String resumeAge;

    @ApiModelProperty(value = "手机号码")
    @TableField("RESUME_PHONE")
    private Long resumePhone;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "介绍")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;

    @ApiModelProperty(value = "出生日期")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;

    @ApiModelProperty(value = "招聘计划")
    @TableField("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

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
