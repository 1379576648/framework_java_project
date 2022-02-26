package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("STAFF")
@ApiModel(value="Staff对象", description="员工表")
@KeySequence(value = "STAFF_ID",clazz = Integer.class)
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "获奖人编号")
    @TableId("STAFF_ID")
    private Integer staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName1;

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
    private Integer workerId;

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


    @ApiModelProperty(value = "员工年龄")
    @TableField("STAFF_AGE")
    private String staffAge;

    @ApiModelProperty(value = "员工工龄")
    @TableField("WORK_AGE")
    private String workAge;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;

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
    private Integer pageSize;

    @ApiModelProperty(value = "角色编号")
    @TableField(exist = false)
    private Integer roleId;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tj;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjTwo;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjThree;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjFour;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjFive;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjSix;

    @ApiModelProperty(value = "统计")
    @TableField(exist = false)
    private Integer tjSeven;


    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;


    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    private Dept dept;


    @ApiModelProperty(value = "部门职位")
    @TableField(exist = false)
    private DeptPost deptPost;


    @ApiModelProperty(value = "转正")
    @TableField(exist = false)
    private Worker worker;

    @ApiModelProperty(value = "部门名称")
    @TableField(exist = false)
    private String deptName;

    @ApiModelProperty(value = "部门职位")
    @TableField(exist = false)
    private String postName;

    @ApiModelProperty(value = "基本工资")
    @TableField(exist = false)
    private double baseWage;

    @ApiModelProperty(value = "工作日加班工资")
    @TableField(exist = false)
    private double workMoney;

    @ApiModelProperty(value = "节假日加班工资")
    @TableField(exist = false)
    private double holidayMoney;

    @ApiModelProperty(value = "休息日加班工资")
    @TableField(exist = false)
    private double offMoney;

    @ApiModelProperty(value = "工资合计")
    @TableField(exist = false)
    private double totalWage;

    @ApiModelProperty(value = "早退")
    @TableField(exist = false)
    private double elaryMoney;

    @ApiModelProperty(value = "迟到")
    @TableField(exist = false)
    private double lateMoney;

    @ApiModelProperty(value = "旷工")
    @TableField(exist = false)
    private double leaveMoney;

    @ApiModelProperty(value = "早退次数")
    @TableField(exist = false)
    private Integer elaryMoneycs;

    @ApiModelProperty(value = "迟到次数")
    @TableField(exist = false)
    private Integer lateMoneycs;

    @ApiModelProperty(value = "旷工次数")
    @TableField(exist = false)
    private Integer leaveMoneycs;

    @ApiModelProperty(value = "参保方案")
    @TableField(exist = false)
    private List<InsuredScheme> insuredScheme;

    @ApiModelProperty(value = "打卡记录")
    @TableField(exist = false)
    private List<ClockRecord> list;

    @ApiModelProperty(value = "社保归档")
    @TableField(exist = false)
    private InsuredArchive insuredArchive;

    @ApiModelProperty(value = "实发工资")
    @TableField(exist = false)
    private double salarySum;

    @ApiModelProperty(value = "打卡记录创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(exist = false)
    private Date createdTime1;
}
