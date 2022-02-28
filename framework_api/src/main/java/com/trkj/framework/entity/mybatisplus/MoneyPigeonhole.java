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

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MONEYPIGEONHOLE")
@ApiModel(value="MoneyPigeonhole对象", description="工资归档表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "MONEYPIGEONHOLE_ID",clazz = Integer.class)
public class MoneyPigeonhole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工资归档编号")
    @TableId("MONEYPIGEONHOLE_ID")
    private Integer moneyPigeonholeId;

    @ApiModelProperty(value = "部门名称 ")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "计薪人数 ")
    @TableField("MONEYPIGEONHOLE_ASKPERSON")
    private Integer moneyPigeonholeAskPerson;

    @ApiModelProperty(value = "应发工资 ")
    @TableField("MONEYPIGEONHOLE_SALARY")
    private Double moneyPigeonholeSalary;

    @ApiModelProperty(value = "实发工资 ")
    @TableField("MONEYPIGEONHOLE_PAYROLLSALARY")
    private Double moneyPigeonholePayrollSalary;

    @ApiModelProperty(value = "公司缴纳 ")
    @TableField("MONEYPIGEONHOLE_FIRMPAYMENT")
    private Double moneyPigeonholeFirmPayment;

    @ApiModelProperty(value = "员工成本 ")
    @TableField("MONEYPIGEONHOLE_STAFFCOST")
    private Double moneyPigeonholeStaffCost;

    @ApiModelProperty(value = "状态 ")
    @TableField("MONEYPIGEONHOLE_STATE")
    private Integer moneyPigeonholeState;

    @ApiModelProperty(value = "员工姓名 ")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "职位 ")
    @TableField("MONEYPIGEONHOLE_POST")
    private String moneyPigeonholePost;

    @ApiModelProperty(value = "基本工资 ")
    @TableField("MONEYPIGEONHOLE_BASEPAY")
    private Double moneyPigeonholeBasePay;

    @ApiModelProperty(value = "工作日加班工资 ")
    @TableField("WORKDAYOVERTIMEPAY")
    private Double workdayOvertimePay;

    @ApiModelProperty(value = "休息日加班工资 ")
    @TableField("DAYOFFOVERTIMEPAY")
    private Double dayOffOvertimePay;

    @ApiModelProperty(value = "节假日加班工资 ")
    @TableField("HOLIDAYOVERTIMEPAY")
    private Double holidayOvertimePay;

    @ApiModelProperty(value = "工资合计 ")
    @TableField("TOTALWAGE")
    private Double totalWage;

    @ApiModelProperty(value = "出差工资 ")
    @TableField("TRAVELWAGE")
    private Double travelwage;

    @ApiModelProperty(value = "迟到 ")
    @TableField("MONEYPIGEONHOLE_LATE")
    private Double moneyPigeonholeLate;

    @ApiModelProperty(value = "早退 ")
    @TableField("MONEYPIGEONHOLE_LEAVEARLY")
    private Double moneyPigeonholeLeaveArly;

    @ApiModelProperty(value = "未签到 ")
    @TableField("MONEYPIGEONHOLE_NOTSIGNIN")
    private Double moneyPigeonholeNotSignIn;

    @ApiModelProperty(value = "未签退 ")
    @TableField("MONEYPIGEONHOLE_NOTSIGNBACK")
    private Double moneyPigeonholeNotSignBack;

    @ApiModelProperty(value = "旷工 ")
    @TableField("ABSENTEISM")
    private Double absenteism;

    @ApiModelProperty(value = "事假 ")
    @TableField("CUSUALLEAVE")
    private Double cusualLeave;

    @ApiModelProperty(value = "病假 ")
    @TableField("SICKLEAVE")
    private Double sickLeave;

    @ApiModelProperty(value = "个人缴纳公积金 ")
    @TableField("PERSONAGE_ACCUMULATION")
    private Double personageAccumulAtion;

    @ApiModelProperty(value = "个人缴纳社保 ")
    @TableField("PERSONAGE_SOCIAL")
    private Double personageSocial;

    @ApiModelProperty(value = "公司缴纳社保 ")
    @TableField("COMPANY_SOCIAL")
    private Double companySocial;

    @ApiModelProperty(value = "公司缴纳公积金 ")
    @TableField("COMPANY_ACCUMULATION")
    private Double companyAccumulAtion;

    @ApiModelProperty(value = "日期 ")
    @TableField("MONEYPIGEONHOLE_DATE")
    private Date moneyPigeonholeDate;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;

    @ApiModelProperty(value = "计薪人数")
    @TableField(exist = false)
    private Integer countPerson;

    @ApiModelProperty(value = "统计应发工资")
    @TableField(exist = false)
    private double countyMoney;

    @ApiModelProperty(value = "统计实发工资")
    @TableField(exist = false)
    private double countsMoney;

    @ApiModelProperty(value = "公司缴纳")
    @TableField(exist = false)
    private double countcPay;

    @ApiModelProperty(value = "员工成本")
    @TableField(exist = false)
    private double staffPay;

    @ApiModelProperty(value = "薪资月份")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField(exist = false)
    private Date payMonth;

    @ApiModelProperty(value = "开始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;





}
