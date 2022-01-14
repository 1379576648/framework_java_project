package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 公告部门表
 * </p>
 *
 * @author 13795
 * @author 13795
 * @author 劉祁
 * @since 2021-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE_DEPT")
@ApiModel(value="NoticeDept对象", description="公告部门表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "NOTICE_DEPT_ID",clazz = Integer.class)
public class NoticeDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告部门编号")
    @TableId("NOTICE_DEPT_ID")
    private Integer noticeDeptId;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Integer deptId;

    @ApiModelProperty(value = "公告编号")
    @TableField("NOTICE_ID")
    private Integer noticeId;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    @TableField("REVISION")
    private Long revision;




}
