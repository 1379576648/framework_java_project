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
 * 参保方案表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_PAYMENT")
@ApiModel(value="InsuredPayment对象", description="参保方案表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "INSURED_PAYMENT_ID",clazz = Integer.class)
public class InsuredPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保缴纳编号")
    @TableId("INSURED_PAYMENT_ID")
    private Integer insuredPaymentId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "参保方案编号")
    @TableField("INSURED_SCHEME_ID")
    private Long insuredSchemeId;

    @ApiModelProperty(value = "参保明细编号")
    @TableField("INS_DETAIL_ID")
    private Long insDetailId;

    @ApiModelProperty(value = "社保缴纳基数")
    @TableField("INSURED_PAYMENT_SOCIAL_NUMBER")
    private Double insuredPaymentSocialNumber;

    @ApiModelProperty(value = "积金缴纳基数")
    @TableField("INSURED_PAYMENT_FUND_NUMBER")
    private Double insuredPaymentFundNumber;

    @ApiModelProperty(value = "参保月份 精确到年月")
    @TableField("INSURED_PAYMENT_INSURED_MONTH")
    private Date insuredPaymentInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @TableField("INSURED_PAYMENT_SALARY_MONTH")
    private Date insuredPaymentSalaryMonth;


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

    @ApiModelProperty(value = "社保基数")
    @TableField(exist = false)
    private Double socialNumber;

    @ApiModelProperty(value = "参保月份")
    @TableField(exist = false)
    private Date inMonth;

    @ApiModelProperty(value = "积金基数")
    @TableField(exist = false)
    private Double fundNumber;


    @ApiModelProperty(value = "计薪月份")
    @TableField(exist = false)
    private Date time;

}
