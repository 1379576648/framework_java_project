package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullVo {
    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "身份证")
    @TableField("STAFF_IDENTITY")
    private String staffIdentity;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "入职日期")
    @TableField("STAFF_HIREDATE")
    private Date staffHiredate;

    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;
}
