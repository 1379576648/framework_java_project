package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("REGISTER_LOG")
@ApiModel(value="RegisterLog对象", description="登录日志表")
public class RegisterLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录日志编号")
    @TableId(value = "REGISTER_LOG_ID")
    private Long registerLogId;

    @ApiModelProperty(value = "员工名称")
    @TableField(value = "REGISTER_LOG_PEOPLE")
    private String registerLogPeople;

    @ApiModelProperty(value = "手机号码")
    @TableField( value = "REGISTER_LOG_PHONE")
    private Long registerLogPhone;

    @ApiModelProperty(value = "IP地址")
    @TableField(value = "REGISTER_LOG_IP")
    private String registerLogIp;

    @ApiModelProperty(value = "设登录状态 0:成功 1:失败")
    @TableField(value = "REGISTER_LOG_TYPE")
    private String registerLogType;

    @TableField(value = "REGISTER_LOG_STATE")
    private Long registerLogState;

    @ApiModelProperty(value = "浏览器")
    @TableField(value = "REGISTER_LOG_BROWSER")
    private String registerLogBrowser;

    @ApiModelProperty(value = "登录类型 0:人脸 1:密码")
    @TableField(value = "REGISTER_LOG_GENRE")
    private Double registerLogGenre;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField(value = "REVISION")
    private Long revision;


    @ApiModelProperty(value = "IP所在地")
    @TableField(value = "REGISTER_LOG_IPNAME")
    private String registerLogIpname;

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
