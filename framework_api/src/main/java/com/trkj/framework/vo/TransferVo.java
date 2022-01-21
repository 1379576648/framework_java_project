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
public class TransferVo {
    @ApiModelProperty(value = "调动记录编号")
    @TableId("TRANSFER_ID")
    private Long transferId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "异动类型")
    @TableField("TRANSFER_TYPE")
    private String transferType;

    @ApiModelProperty(value = "原部门名称")
    @TableField("CREATED_DEPT_NAME")
    private String createdDeptName;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRANSFER_STATE")
    private Long transferState;

    @ApiModelProperty(value = "变动后部门名称")
    @TableField("UPDATED_DEPT_NAME")
    private String updatedDeptName;

    @ApiModelProperty(value = "原部门职位名称")
    @TableField("TRANSFER_RAWPOST_NAME")
    private String transferRawpostName;

    @ApiModelProperty(value = "变动后部门职位名称")
    @TableField("TRANSFER_AFTERPOST_NAME")
    private String transferAfterpostName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "生效日期")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

    @ApiModelProperty(value = "备注")
    @TableField("TRANSFER_REMARK")
    private String transferRemark;

    @ApiModelProperty(value = "获奖人编号")
    @TableId("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "性别")
    @TableField("STAFF_SEX")
    private String staffSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("STAFF_PHONE")
    private Long staffPhone;

    @ApiModelProperty(value = "邮箱")
    @TableField("STAFF_EMAIL")
    private String staffEmail;

    @ApiModelProperty(value = "照片")
    @TableField("STAFF_PICTURE")
    private String staffPicture;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "出生日期")
    @TableField("STAFF_BIRTHDAY")
    private Date staffBirthday;

    @ApiModelProperty(value = "政治面貌")
    @TableField("STAFF_OUTLOOK")
    private String staffOutlook;

    @ApiModelProperty(value = "学历")
    @TableField("STAFF_EDUCATION")
    private String staffEducation;

    @ApiModelProperty(value = "部门职位编号外键")
    @TableField("DEPT_POST_ID")
    private Integer deptPostId;

    @ApiModelProperty(value = "密码")
    @TableField("STAFF_PASS")
    private String staffPass;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "入职日期")
    @TableField("STAFF_HIREDATE")
    private Date staffHiredate;

    @ApiModelProperty(value = "转正编号")
    @TableField("WORKER_ID")
    private Long workerId;

    @ApiModelProperty(value = "身份证")
    @TableField("STAFF_IDENTITY")
    private String staffIdentity;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Integer deptId;

    @ApiModelProperty(value = "专业")
    @TableField("STAFF_MAJOR")
    private String staffMajor;

    @ApiModelProperty(value = "紧急联系人")
    @TableField("STAFF_EMERGENCY")
    private Long staffEmergency;

    @ApiModelProperty(value = "微信")
    @TableField("STAFF_WECHAT")
    private String staffWechat;

    @TableField("STAFF_QQ")
    private String staffQq;

    @ApiModelProperty(value = "银行卡号")
    @TableField("STAFF_CREDIT")
    private String staffCredit;

    @ApiModelProperty(value = "血型")
    @TableField("STAFF_BLOOD")
    private String staffBlood;

    @ApiModelProperty(value = "星座")
    @TableField("STAFF_SIGN")
    private String staffSign;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("STAFF_MARITAL")
    private String staffMarital;

    @ApiModelProperty(value = "户口所在地")
    @TableField("STAFF_REGISTERED")
    private String staffRegistered;

    @ApiModelProperty(value = "毕业学校")
    @TableField("STAFF_SCHOOL")
    private String staffSchool;

    @ApiModelProperty(value = "现住地址")
    @TableField("STAFF_ADDRESS")
    private String staffAddress;

    @ApiModelProperty(value = "员工状态")
    @TableField("STAFF_STATE")
    private Long staffState;

    @ApiModelProperty(value = "员工工龄")
    @TableField("WORK_AGE")
    private String workAge;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;
}
