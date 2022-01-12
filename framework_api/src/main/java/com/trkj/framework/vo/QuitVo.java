package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 离职审批VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuitVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "标题")
    @TableId("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableId("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "申请状态")
    @TableId("AUDITFLOW_STATE")
    private Long auditflowState;

    @ApiModelProperty(value = "审批明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;

    @ApiModelProperty(value = "审核人1")
    @TableId("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核人2")
    @TableId("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "审核人3")
    @TableId("STAFF_NAME")
    private String staffName3;

    @ApiModelProperty(value = "审核备注")
    @TableId("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @ApiModelProperty(value = "审核日期")
    @TableId("AUDITFLOWDETAI_DATE")
    private String auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableId("AUDITFLOWDETAI_STATE")
    private Long auditflowdeatistate;

    @ApiModelProperty(value = "离职编号")
    @TableId("QUIT_ID")
    private Long quitId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "离职类型")
    @TableField("QUIT_TYPE")
    private String quitType;

    @ApiModelProperty(value = "离职说明")
    @TableField("QUIT_EXPLAIN")
    private String quitExplain;

    @ApiModelProperty(value = "申请离职日期")
    @TableField("APPLY_QUIT_DATE")
    private Date applyQuitDate;

    @ApiModelProperty(value = "正式离职日期")
    @TableField("FORMAL_QUIT_DATE")
    private Date formalQuitDate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;
}
