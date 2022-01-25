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
 * 部门职位Vo
 * @Data
 * @NoArgsConstructor
 * @AllArgsConstructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptPostVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门职位编号")
    @TableId("DEPT_POST_ID")
    private int deptPostId;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value ="员工名称")
    @TableId("STAFF_NAME")
    private String staffname;

    @ApiModelProperty(value = "员工编号")
    @TableId("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;
}
