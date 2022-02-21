package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendandceVo {
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
    private String attendandceRemark;

    @ApiModelProperty(value = "适用对象")
    @TableId("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private int deptId;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;

    @ApiModelProperty(value = "部门负责人;提供ID到员工表锁定具体的人")
    @TableField("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;


    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;

}
