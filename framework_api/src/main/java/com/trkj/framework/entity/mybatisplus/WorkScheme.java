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
@TableName("WORKSCHEME")
@ApiModel(value = "workscheme对象", description = "加班方案")
@KeySequence(value = "WORKSCHEME_ID", clazz = Integer.class)
public class WorkScheme implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加班方案编号")
    @TableId("WORKSCHEME_ID")
    private Integer workSchemeId;

    @ApiModelProperty(value = "加班方案名称")
    @TableId("WORKSCHEME_NAME")
    private String workschemeName;

    @ApiModelProperty(value = "节假日加班比例")
    @TableId("WORKSCHEME_HOLIDAYRATIO")
    private Integer workschemeHolidayratio;

    @ApiModelProperty(value = "休息日加班比例")
    @TableId("WORKSCHEME_DAYOFFRATIO")
    private Integer workschemeDayoffratio;

    @ApiModelProperty(value = "工作日加班比例")
    @TableId("WORKSCHEME_WORKRATIO")
    private Integer workschemeWorkratio;

    @ApiModelProperty(value = "状态")
    @TableId("WORKSCHEME_STATE")
    private Integer workschemeState;

    @ApiModelProperty(value = "备注")
    @TableId("WORKSCHEME_REMARK")
    private String workschemeRemark;

    @ApiModelProperty(value = "适用对象")
    @TableId("DEPT_NAME")
    private String deptName;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;

}
