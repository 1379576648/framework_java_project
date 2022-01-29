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
 * 默认参保方案表
 * </p>
 *
 * @author 13795
 * @author 劉祁
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEF_INSURED")
@ApiModel(value="DefInsured对象", description="默认参保方案表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "DEF_INSURED_ID",clazz = Integer.class)
public class DefInsured implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "默认参保方案编号")
    @TableId("DEF_INSURED_ID")
    private Integer defInsuredId;

    @ApiModelProperty(value = "默认参保方案名称")
    @TableField("DEF_INSURED_NAME")
    private String defInsuredName;

    @ApiModelProperty(value = "默认参保方案状态 0:启用 1:禁用")
    @TableField("DEF_INSURED_STATE")
    private Long defInsuredState;

    @ApiModelProperty(value = "默认参保方案数量")
    @TableField("DEF_INSURED_NUMBER")
    private Long defInsuredNumber;

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

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;
}
