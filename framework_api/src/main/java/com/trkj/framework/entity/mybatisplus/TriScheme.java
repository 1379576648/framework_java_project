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
 * 默认方案表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRI_SCHEME")
@ApiModel(value="TriScheme对象", description="默认方案表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "TRI_SCHEME_ID",clazz = Integer.class)
public class TriScheme implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "默认方案表编号")
    @TableId("TRI_SCHEME_ID")
    private Integer triSchemeId;

    @ApiModelProperty(value = "默认参保方案编号")
    @TableField("TRI_INSURED_ID")
    private Long triInsuredId;

    @ApiModelProperty(value = "最少基数")
    @TableField("TRI_SCHEME_MIN")
    private Double triSchemeMin;

    @ApiModelProperty(value = "最多基数")
    @TableField("TRI_SCHEME_MAX")
    private Double triSchemeMax;

    @ApiModelProperty(value = "基数上限")
    @TableField("TRI_SCHEME_UPPER")
    private Double triSchemeUpper;

    @ApiModelProperty(value = "基数下限")
    @TableField("TRI_SCHEME_FLOOR")
    private Double triSchemeFloor;

    @ApiModelProperty(value = "个人缴纳比例")
    @TableField("TRI_SCHEME_PERSON_PROP")
    private Double triSchemePersonProp;

    @ApiModelProperty(value = "个人固定缴纳")
    @TableField("TRI_SCHEME_PERSON_SUM")
    private Double triSchemePersonSum;

    @ApiModelProperty(value = "企业缴纳比例")
    @TableField("TRI_SCHEME_FIRM_PROP")
    private Double triSchemeFirmProp;

    @ApiModelProperty(value = "企业缴纳比例")
    @TableField("TRI_SCHEME_FIRM_SUM")
    private Double triSchemeFirmSum;

    @ApiModelProperty(value = "参保类型")
    @TableField("TRI_SCHEME_TYPE")
    private String triSchemeType;

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
