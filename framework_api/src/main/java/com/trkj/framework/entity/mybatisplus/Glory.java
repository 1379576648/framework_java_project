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
 * 荣誉/奖励表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("GLORY")
@ApiModel(value="Glory对象", description="荣誉/奖励表")
public class Glory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "荣誉/奖励编号")
    @TableId("GLORY_ID")
    private Long gloryId;

    @ApiModelProperty(value = "荣誉/奖励名称")
    @TableField("GLORY_NAME")
    private String gloryName;

    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "颁发单位名称")
    @TableField("GLORY_UNITNAME")
    private String gloryUnitname;

    @ApiModelProperty(value = "备注")
    @TableField("GLORY_REMARK")
    private String gloryRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
