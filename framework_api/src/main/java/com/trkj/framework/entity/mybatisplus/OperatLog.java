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
 * 操作日志表
 * </p>
 *
 * @author 劉祁
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OPERAT_LOG")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "OPERAT_LOG_ID",clazz = Integer.class)
@ApiModel(value="OperatLog对象", description="操作日志表")
public class OperatLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "操作日志编号")
    @TableId("OPERAT_LOG_ID")
    private Integer operatLogId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "系统模块")
    @TableField("OPERAT_LOG_MODULE")
    private String operatLogModule;

    @ApiModelProperty(value = "操作类型")
    @TableField("OPERAT_LOG_TYPE")
    private String operatLogType;

    @ApiModelProperty(value = "员工名称")
    @TableField("OPERAT_LOG_PEOPLE")
    private String operatLogPeople;

    @ApiModelProperty(value = "员工职位")
    @TableField("OPERAT_LOG_POST")
    private String operatLogPost;

    @ApiModelProperty(value = "请求方式")
    @TableField("OPERAT_LOG_REQUEST")
    private String operatLogRequest;


    @ApiModelProperty(value = "请求地址")
    @TableField("OPERAT_LOG_URL")
    private String operatLogUrl;

    @ApiModelProperty(value = "请求方法")
    @TableField("OPERAT_LOG_METHOD")
    private String operatLogMethod;

    @ApiModelProperty(value = "请求参数")
    @TableField("OPERAT_LOG_REQUEST_PARAMETER")
    private String operatLogRequestParameter;

    @ApiModelProperty(value = "返回参数")
    @TableField("OPERAT_LOG_RETURN_PARAMETERS")
    private String  operatLogReturnParameters;

    @ApiModelProperty(value = "操作内容")
    @TableField("OPERAT_LOG_CONTENT")
    private String operatLogContent;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
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
