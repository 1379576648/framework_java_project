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

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLASSES")
@ApiModel(value="Classes对象", description="班次方案")
@KeySequence(value = "CLASSES_ID",clazz = Integer.class)
public class Classes implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班次编号")
    @TableId("CLASSES_ID")
    private Integer classesId;

    @ApiModelProperty(value = "班次名称")
    @TableId("CLASSES_NAME")
    private String classesName;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "上班时间")
    @TableId("CLASSES_BEGIN_DATE")
    private Date classesBeginDate;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "下班时间")
    @TableId("CLASSES_END_DATE")
    private Date classesEndDate;

    @ApiModelProperty(value = "状态")
    @TableId("CLASSES_STATE")
    private Integer classesState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;

    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
