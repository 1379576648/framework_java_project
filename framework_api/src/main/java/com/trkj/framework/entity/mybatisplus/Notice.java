package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE")
@ApiModel(value="Notice对象", description="公告表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "NOTICE_ID",clazz = Integer.class)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告编号")
    @TableId("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "公告类型 0:要事性 1:政策性 2:任免性")
    @TableField("NOTICE_TYPE")
    private Long noticeType;

    @ApiModelProperty(value = "公告标题")
    @TableField("NOTICE_TITLE")
    private String noticeTitle;

    @ApiModelProperty(value = "公告状态 0:启用 1:禁用")
    @TableField("NOTICE_STATE")
    private Long noticeState;

    @ApiModelProperty(value = "发布人")
    @TableField("NOTICE_PEOPLE")
    private String noticePeople;

    @ApiModelProperty(value = "职位")
    @TableField("NOTICE_POST")
    private String noticePost;

    @ApiModelProperty(value = "发布内容")
    @TableField("NOTICE_MATTER")
    private String noticeMatter;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME" ,fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;


    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;


}
