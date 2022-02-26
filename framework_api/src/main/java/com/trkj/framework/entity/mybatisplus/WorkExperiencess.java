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
 * 工作经历表
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WORK_EXPERIENCESS")
@ApiModel(value="WorkExperiencess对象", description="工作经历表")
@KeySequence(value = "WORK_EXPERIENCESS_ID",clazz = Integer.class)
public class WorkExperiencess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("WORK_EXPERIENCESS_ID")
    private Integer workExperiencessId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @ApiModelProperty(value = "简历编号外键")
    @TableField("RESUME_ID")
    private Long resumeId;

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
