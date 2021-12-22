package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 加班表
 * </p>
 *
 * @author 里予
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OVERTIMEASK")
@ApiModel(value="Overtimeask对象", description="加班表")
public class Overtimeask implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加班表编号")
    @TableId("OVERTIMEASK_ID")
    private Long overtimeaskId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "发起人部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "加班类型")
    @TableField("OVERTIMEASK_TYPE")
    private String overtimeaskType;

    @ApiModelProperty(value = "加班事由")
    @TableField("OVERTIMEASK_MATTER")
    private String overtimeaskMatter;

    @ApiModelProperty(value = "备注")
    @TableField("OVERTIMEASK_REMARKS")
    private String overtimeaskRemarks;

    @ApiModelProperty(value = "加班开始时间")
    @TableField("OVERTIMEASK_S_DATE")
    private Date overtimeaskSDate;

    @ApiModelProperty(value = "加班结束时间")
    @TableField("OVERTIMEASK_E_DATE")
    private Date overtimeaskEDate;

    @ApiModelProperty(value = "加班总小时")
    @TableField("OVERTIMEASK_TOTAL_DATE")
    private Long overtimeaskTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("OVERTIMEASK_STATE")
    private Long overtimeaskState;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
