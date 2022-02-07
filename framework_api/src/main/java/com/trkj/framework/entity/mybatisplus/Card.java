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
@TableName("CARD")
@ApiModel(value="Card对象", description="补打卡")
@KeySequence(value = "CARD_ID",clazz = Integer.class)
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "补打卡编号")
    @TableId("CARD_ID")
    private Integer cardId;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "补打卡类型")
    @TableId("CARD_TYPE")
    private String cardType;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "补打卡时间")
    @TableId("CARD_DATE")
    private Date cardDate;

    @ApiModelProperty(value = "备注")
    @TableId("CARD_REMARKS")
    private String cardRemarks;

    @ApiModelProperty(value = "状态")
    @TableId("CARD_STATE")
    private String cardState;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
