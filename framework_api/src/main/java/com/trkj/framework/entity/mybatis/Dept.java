package com.trkj.framework.entity.mybatis;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPT")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Dept对象", description="部门表")
public class Dept implements Serializable {
    @TableId("DEPT_ID")
    private Integer deptId;
    private Long deptState;
    private String deptName;
    private Long staffId;
    private Date createdTime;
    private Date updatedTime;
    private Long revision;
    private Long isDeleted;
}
