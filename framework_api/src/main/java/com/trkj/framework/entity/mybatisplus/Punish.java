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
 * 惩罚表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PUNISH")
@ApiModel(value="Punish对象", description="惩罚表")
public class Punish implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "惩罚编号")
    @TableId("PUNISH_ID")
    private Long punishId;

    @ApiModelProperty(value = "惩罚类型")
    @TableField("PUNISH_TYPE")
    private String punishType;

    @ApiModelProperty(value = "被惩罚人编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "惩罚原因")
    @TableField("PUNISH_CAUSE")
    private String punishCause;

    @ApiModelProperty(value = "惩罚单位")
    @TableField("PUNISH_UNIT")
    private String punishUnit;

    @ApiModelProperty(value = "是否撤销")
    @TableField("IS_REVOCATION")
    private Long isRevocation;

    @ApiModelProperty(value = "备注")
    @TableField("PUNISH_REMARK")
    private String punishRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;


}
