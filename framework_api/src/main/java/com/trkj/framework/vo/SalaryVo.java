package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 调薪审批VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryVo {

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

    @ApiModelProperty(value = "审核备注")
    @TableId("AUDITFLOWDETAI_DATE")
    private String auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableId("AUDITFLOWDETAI_STATE")
    private Long auditflowdeatistate;

    @ApiModelProperty(value = "调薪编号")
    @TableId("SALARY_ID")
    private Integer salaryid;

    @ApiModelProperty(value = "部门名称")
    @TableId("DEPT_NAME")
    private String deptname;

    @ApiModelProperty(value = "调薪前基本工资")
    @TableId("FRONT_SALARY")
    private Integer frontsalary;

    @ApiModelProperty(value = "调薪后基本工资")
    @TableId("AFTER_SALARY")
    private Integer aftersalary;

    @ApiModelProperty(value = "备注")
    @TableId("SALARY_REMARKS")
    private String salaryremarks;

    @ApiModelProperty(value = "生效日期")
    @TableId("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableId("IS_DELETED")
    private Long isdeleted;
}
