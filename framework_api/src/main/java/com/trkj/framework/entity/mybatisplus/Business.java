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
@TableName("BUSINESS")
@ApiModel(value = "business对象", description = "出差方案")
@KeySequence(value = "BUSINESS_ID", clazz = Integer.class)
public class Business implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差方案编号")
    @TableId("BUSINESS_ID")
    private Integer businessId;

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Integer travelId;

    @ApiModelProperty(value = "出差方案名称")
    @TableId("BUSINESS_NAME")
    private String businessName;

    @ApiModelProperty(value = "出差一天金额")
    @TableId("BUSINESS_ONEMONEY")
    private Integer businessOnemoney;

    @ApiModelProperty(value = "状态")
    @TableId("BUSINESS_STATE")
    private Integer businessState;

    @ApiModelProperty(value = "备注")
    @TableId("BUSINESS_REMARK")
    private String businessRemark;

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
