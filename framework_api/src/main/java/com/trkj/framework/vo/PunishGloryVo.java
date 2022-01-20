package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PunishGloryVo {
    @ApiModelProperty(value = "惩罚编号")
    @TableId("PUNISH_ID")
    private Integer punishId;

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

    @ApiModelProperty(value = "荣誉/奖励编号")
    @TableId("GLORY_ID")
    private Integer gloryId;

    @ApiModelProperty(value = "荣誉/奖励名称")
    @TableField("GLORY_NAME")
    private String gloryName;

    @ApiModelProperty(value = "颁发单位名称")
    @TableField("GLORY_UNITNAME")
    private String gloryUnitname;

    @ApiModelProperty(value = "备注")
    @TableField("GLORY_REMARK")
    private String gloryRemark;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
