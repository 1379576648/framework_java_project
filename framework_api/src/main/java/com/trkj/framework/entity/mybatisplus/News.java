package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 消息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("News")
@ApiModel(value="News对象", description="消息表")
@KeySequence(value = "NEWS_ID",clazz = Integer.class)
public class News {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告部门编号")
    @TableId("NEW_ID")
    private Integer newId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "消息内容")
    @TableField("NEWS_MATTER")
    private String newsMatter;

    @ApiModelProperty(value = "消息标题")
    @TableField("NEWS_TITLE")
    private String newsTitle;

    @ApiModelProperty(value = "消息状态")
    @TableField("NEWS_STATE")
    private Integer newsState;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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




}
