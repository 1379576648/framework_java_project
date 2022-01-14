package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SALARY")
@ApiModel(value = "Salaryr对象", description = "调薪")
@KeySequence(value = "SALARY_ID", clazz = Integer.class)
public class Salary {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调薪编号")
    @TableId("SALARY_ID")
    private Integer salaryId;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableId("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门名称")
    @TableId("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "调薪前基本工资")
    @TableId("FRONT_SALARY")
    private Integer frontSalary;

    @ApiModelProperty(value = "调薪后基本工资")
    @TableId("AFTER_SALARY")
    private Integer afterSalary;

    @ApiModelProperty(value = "操作人")
    @TableId("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "备注")
    @TableId("SALARY_REMARKS")
    private String salaryRemarks;

    @ApiModelProperty(value = "状态")
    @TableId("SALARY_STATE")
    private Integer salaryState;

    @ApiModelProperty(value = "生效日期")
    @TableId("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableId("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableId("IS_DELETED")
    private Long isDeleted;
}
