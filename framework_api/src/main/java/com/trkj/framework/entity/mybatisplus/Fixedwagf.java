package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FIXEDWAGE")
@ApiModel(value = "fixedwagf对象", description = "固定工资")
@KeySequence(value = "FIXEDWAGE_ID", clazz = Integer.class)
public class Fixedwagf {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "固定工资编号")
    @TableId("FIXEDWAGE_ID")
    private Integer fixedwageId;

    @ApiModelProperty(value = "试用期基本工资")
    @TableId("FIXEDWAGE_PERIODMONEY")
    private Double fixedwagePeriodmoney;

    @ApiModelProperty(value = "员工编号")
    @TableId("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "正式期基本工资")
    @TableId("FIXEDWAGE_OFFICIALMONEY")
    private Double fixedwageOfficialmoney;

    @ApiModelProperty(value = "试用期岗位工资")
    @TableId("FIXEDWAGE_PERIODPOSTMONEY")
    private Double fixedwagePeriodpostmoney;

    @ApiModelProperty(value = "正式期岗位工资")
    @TableId("FIXEDWAGE_OFFLCIALPOSTMONEY")
    private Double fixedwageOfflcialpostmoney;

    @ApiModelProperty(value = "备注")
    @TableId("FIXEDWAGE_REMARK")
    private String fixedwageRemark;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableId("IS_DELETED")
    private Integer isDeleted;
}
