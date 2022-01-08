package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

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

}
