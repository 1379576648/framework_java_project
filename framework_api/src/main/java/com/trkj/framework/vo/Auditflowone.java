package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 审批vo
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditflowone implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "审批类型")
    @TableField("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

    @ApiModelProperty(value = "申请状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditflowstate;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "审批人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
