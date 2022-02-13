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
 * <p>
 * 参保日志表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_LOG")
@ApiModel(value="InsuredLog对象", description="参保日志表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "INSURED_LOG_ID",clazz = Integer.class)
public class InsuredLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保日志编号")
    @TableId("INS_LOG_ID")
    private Integer insLogId;

    @ApiModelProperty(value = "参保人")
    @TableField("INS_LOG_ID_THE_INSURED")
    private String insLogIdTheInsured;

    @ApiModelProperty(value = "修改对象")
    @TableField("INS_LOG_UPDATE_OBJECT")
    private String insLogUpdateObject;

    @ApiModelProperty(value = "日志说明")
    @TableField("INS_LOG_EXPLAIN")
    private String insLogExplain;

    @ApiModelProperty(value = "参保方案")
    @TableField("INS_LOG_INSURED_NAME")
    private String insLogInsuredName;

    @ApiModelProperty(value = "社保基数")
    @TableField("INS_LOG_SOCIAL_NUMBER")
    private Double insLogSocialNumber;

    @ApiModelProperty(value = "社保参保月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_LOG_SOCIAL_INSURED_MONTH")
    private Date insLogSocialInsuredMonth;

    @ApiModelProperty(value = "社保计薪月份  精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_LOG_SOCIAL_SALARY_MONTH")
    private Date insLogSocialSalaryMonth;

    @ApiModelProperty(value = "积金基数")
    @TableField("INS_LOG_FUND_NUMBER")
    private Double insLogFundNumber;

    @ApiModelProperty(value = "积金参保月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_LOG_FUND_INSURED_MONTH")
    private Date insLogFundInsuredMonth;

    @ApiModelProperty(value = "积金计薪月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_LOG_FUND_SALARY_MONTH")
    private Date insLogFundSalaryMonth;

    @ApiModelProperty(value = "颜色")
    @TableField("INS_LOG_COLOR")
    private String insLogColor;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;


}
