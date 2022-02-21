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
@TableName("ATTENDANDCE")
@ApiModel(value = "attendandce对象", description = "考勤扣款方案")
@KeySequence(value = "ATTENDANDCE_ID", clazz = Integer.class)
public class Attendandce implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤扣款方案编号")
    @TableId("ATTENDANDCE_ID")
    private Integer attendandceId;

    @ApiModelProperty(value = "考勤扣款方案名称")
    @TableId("ATTENDANDCE_NAME")
    private String attendandceName;

    @ApiModelProperty(value = "迟到一次金额")
    @TableId("ATTENDANDCE_LITEMONEY")
    private Integer attendandceLitemoney;

    @ApiModelProperty(value = "早退一次金额")
    @TableId("ATTENDANDCE_LEAVEMONEY")
    private Integer attendandceLeavemoney;

    @ApiModelProperty(value = "未签到一次金额")
    @TableId("ATTENDANDCE_DIDNOTMONEY")
    private Integer attendandceDidnotmoney;

    @ApiModelProperty(value = "未签退一次金额")
    @TableId("ATTENDANDCE_DIDBACKMONEY")
    private Integer attendandceDidbackmoney;

    @ApiModelProperty(value = "旷工一次金额")
    @TableId("ATTENDANDCE_ABSCNTMONEY")
    private Integer attendandceAbscntmoney;

    @ApiModelProperty(value = "状态")
    @TableId("ATTENDANDCE_STATE")
    private Integer attendandceState;

    @ApiModelProperty(value = "备注")
    @TableId("ATTENDANDCE_REMARK")
    private Integer attendandceRemark;

    @ApiModelProperty(value = "适用对象")
    @TableId("DEPT_NAME")
    private Integer deptName;

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
