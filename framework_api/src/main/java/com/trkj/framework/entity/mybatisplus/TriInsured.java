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
 * @author 13795
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRI_INSURED")
@ApiModel(value="TriInsured对象", description="默认方案表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "TRI_INSURED_ID",clazz = Integer.class)
public class TriInsured implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微调参保方案编号")
    @TableId("TRI_INSURED_ID")
    private Integer triInsuredId;

    @ApiModelProperty(value = "微调参保方案名称")
    @TableField("TRI_INSURED_NAME")
    private String triInsuredName;

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
