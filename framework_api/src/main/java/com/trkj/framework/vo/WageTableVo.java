package com.trkj.framework.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WageTableVo {

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

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "固定工资编号")
    @TableId("FIXEDWAGE_ID")
    private Integer fixedwageId;

    @ApiModelProperty(value = "试用期基本工资")
    @TableId("FIXEDWAGE_PERIODMONEY")
    private Integer fixedwagePeriodmoney;

    @ApiModelProperty(value = "员工编号")
    @TableId("STAFF_ID")
    private Integer staffid;

    @ApiModelProperty(value = "正式期基本工资")
    @TableId("FIXEDWAGE_OFFICIALMONEY")
    private Integer fixedwageOfficialmoney;

    @ApiModelProperty(value = "试用期岗位工资")
    @TableId("FIXEDWAGE_PERIODPOSTMONEY")
    private Integer fixedwagePeriodpostmoney;

    @ApiModelProperty(value = "正式期岗位工资")
    @TableId("FIXEDWAGE_OFFLCIALPOSTMONEY")
    private Integer fixedwageOfflcialpostmoney;

    @ApiModelProperty(value = "备注")
    @TableId("FIXEDWAGE_REMARK")
    private String fixedwageRemark;

    @ApiModelProperty(value = "加班方案编号")
    @TableId("WORKSCHEME_ID")
    private Integer workSchemeId;

    @ApiModelProperty(value = "加班方案名称")
    @TableId("WORKSCHEME_NAME")
    private String workschemeName;

    @ApiModelProperty(value = "节假日加班比例")
    @TableId("WORKSCHEME_HOLIDAYRATIO")
    private Integer workschemeHolidayratio;

    @ApiModelProperty(value = "休息日加班比例")
    @TableId("WORKSCHEME_DAYOFFRATIO")
    private Integer workschemeDayoffratio;

    @ApiModelProperty(value = "工作日加班比例")
    @TableId("WORKSCHEME_WORKRATIO")
    private Integer workschemeWorkratio;

    @ApiModelProperty(value = "状态")
    @TableId("WORKSCHEME_STATE")
    private Integer workschemeState;

    @ApiModelProperty(value = "备注")
    @TableId("WORKSCHEME_REMARK")
    private String workschemeRemark;

    @ApiModelProperty(value = "考勤扣款方案编号")
    @TableId("ATTENDANDCE_ID")
    private Integer attendandceId;

    @ApiModelProperty(value = "考勤扣款方案名称")
    @TableId("ATTENDANDCE_NAME")
    private String attendandceName;

    @ApiModelProperty(value = "迟到一次金额")
    @TableId("ATTENDANDCE_LITEMONEY")
    private Integer attendandceLitemoney;

    @ApiModelProperty(value = "早退一次金额")
    @TableId("ATTENDANDCE_LEAVEMONEY")
    private Integer attendandceLeavemoney;

    @ApiModelProperty(value = "未签到一次金额")
    @TableId("ATTENDANDCE_DIDNOTMONEY")
    private Integer attendandceDidnotmoney;

    @ApiModelProperty(value = "未签退一次金额")
    @TableId("ATTENDANDCE_DIDBACKMONEY")
    private Integer attendandceDidbackmoney;

    @ApiModelProperty(value = "旷工一次金额")
    @TableId("ATTENDANDCE_ABSCNTMONEY")
    private Integer attendandceAbscntmoney;

    @ApiModelProperty(value = "状态")
    @TableId("ATTENDANDCE_STATE")
    private Integer attendandceState;

    @ApiModelProperty(value = "备注")
    @TableId("ATTENDANDCE_REMARK")
    private String attendandceRemark;

    @ApiModelProperty(value = "出差方案编号")
    @TableId("BUSINESS_ID")
    private Integer businessId;

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Integer travelId;

    @ApiModelProperty(value = "出差方案名称")
    @TableId("BUSINESS_NAME")
    private String businessName;

    @ApiModelProperty(value = "出差一天金额")
    @TableId("BUSINESS_ONEMONEY")
    private Integer businessOnemoney;

    @ApiModelProperty(value = "状态")
    @TableId("BUSINESS_STATE")
    private Integer businessState;

    @ApiModelProperty(value = "备注")
    @TableId("BUSINESS_REMARK")
    private String businessRemark;

    @ApiModelProperty(value = "加班表编号")
    @TableId("OVERTIMEASK_ID")
    private Integer overtimeaskId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;


    @ApiModelProperty(value = "加班类型")
    @TableField("OVERTIMEASK_TYPE")
    private String overtimeaskType;

    @ApiModelProperty(value = "加班事由")
    @TableField("OVERTIMEASK_MATTER")
    private String overtimeaskMatter;

    @ApiModelProperty(value = "备注")
    @TableField("OVERTIMEASK_REMARKS")
    private String overtimeaskRemarks;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划加班开始时间")
    @TableField("OVERTIMEASK_S_DATE")
    private Date overtimeaskSDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划加班结束时间")
    @TableField("OVERTIMEASK_E_DATE")
    private Date overtimeaskEDate;

    @ApiModelProperty(value = "计划加班总小时")
    @TableField("OVERTIMEASK_TOTAL_DATE")
    private Long overtimeaskTotalDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际加班开始时间")
    @TableField("OVERTIMASK_ACTUAL_TIME")
    private Date overtimeaskActualTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际加班结束时间")
    @TableField("OVERTIMASK_ACTUAL_OVERTIME")
    private Date overtimeaskActualOvertime;

    @ApiModelProperty(value = "实际加班总小时")
    @TableField("OVERTIMASK_ACTUAL_TOKINAGA")
    private Integer overtimeaskActualTokinaga;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("OVERTIMEASK_STATE")
    private Long overtimeaskState;

    @ApiModelProperty(value = "加班状态 0：未开始 1：已完成 ")
    @TableField("OVERTIMEASK_CONDITION")
    private Long overtimeaskCondition;

    @ApiModelProperty(value = "归档编号")
    @TableId("ARCHIVE_ID")
    private Integer archiveId;

    @ApiModelProperty(value = "归档名称")
    @TableField("ARCHIVE_NAME")
    private String archiveName;

    @ApiModelProperty(value = "正常次数")
    @TableField("NORMAL_FREQUENCY")
    private Integer normalFrequency;

    @ApiModelProperty(value = "迟到次数")
    @TableField("LATE_FREQUENCY")
    private Integer lateFrequency;

    @ApiModelProperty(value = "旷工次数")
    @TableField("ABSENTEEISM_FREQUENCY")
    private Integer absenteeismFrequency;

    @ApiModelProperty(value = "早退次数")
    @TableField("LEAVE_EARLY_FREQUENCY")
    private Integer leaveEarlyFrequency;

    @ApiModelProperty(value = "是否全勤")
    @TableField("PRESENT")
    private String present;


    @ApiModelProperty(value = "出差地点")
    @TableId("TRAVEL_PLACE")
    private String travelPlace;

    @ApiModelProperty(value = "出差事由")
    @TableId("TRAVEL_MATTER")
    private String travelMatter;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "出差开始时间")
    @TableId("TRAVEL_S_DATE")
    private Date travelSDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "出差结束时间")
    @TableId("TRAVEL_E_DATE")
    private Date travelEDate;

    @ApiModelProperty(value = "出差总时长")
    @TableId("TRAVEL_TOTAL_DATE")
    private Integer travelTotalDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡出差时间")
    @TableId("TRAVEL_ACTUAL_TIME")
    private Date travelActualTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际打卡结束出差时间")
    @TableId("TRAVEL_ACTUAL_OVERTIME")
    private Date travelActualOvertime;

    @ApiModelProperty(value = "实际出差时长")
    @TableId("TRAVEL_ACTUAL_TOKINAGA")
    private Integer travelActualTokinaga;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRAVEL_STATE")
    private Integer travelState;

    @ApiModelProperty(value = "出差状态 0：未开始 1：进行中 2：已完成")
    @TableField("TRAVEL_CONDITION")
    private Integer travelCondition;

    @ApiModelProperty(value = "参保归档编号")
    @TableId("INS_ARCHIVE_ID")
    private Integer insArchiveId;

    @ApiModelProperty(value = "社保基数 ")
    @TableField("INS_ARCHIVE_SOCIAL_NUMBER")
    private Double insArchiveSocialNumber;

    @ApiModelProperty(value = "积金基数 ")
    @TableField("INS_ARCHIVE_FUND_NUMBER")
    private Double insArchiveFundNumber;


    @ApiModelProperty(value = " 社保基数下限 ")
    @TableField("INS_ARCHIVE_SOCIAL_MIN")
    private Double insArchiveSocialMin;

    @ApiModelProperty(value = " 社保基数上限 ")
    @TableField("INS_ARCHIVE_SOCIAL_MAX")
    private Double insArchiveSocialMax;


    @ApiModelProperty(value = " 积金基数下限 ")
    @TableField("INS_ARCHIVE_FUND_MIN")
    private Double insArchiveFundMin;


    @ApiModelProperty(value = " 积金基数下限 ")
    @TableField("INS_ARCHIVE_FUND_MAX")
    private Double insArchiveFundMax;

    @ApiModelProperty(value = " 养老保险基数 ")
    @TableField("INS_ARCHIVE_PR_NUMBER")
    private Double insArchivePrNumber;

    @ApiModelProperty(value = "养老保险上限")
    @TableField("INS_ARCHIVE_PR_UPPER")
    private Double insArchivePrUpper;

    @ApiModelProperty(value = "养老保险下限")
    @TableField("INS_ARCHIVE_PR_FLOOR")
    private Double insArchivePrFloor;


    @ApiModelProperty(value = "养老保险个人缴纳比例")
    @TableField("INS_ARCHIVE_PR_PERSON_PROP")
    private Double insArchivePrPersonProp;

    @ApiModelProperty(value = "养老保险个人固定缴纳")
    @TableField("INS_ARCHIVE_PR_PERSON_SUM")
    private Double insArchivePrPersonSum;

    @ApiModelProperty(value = "养老保险企业缴纳比例")
    @TableField("INS_ARCHIVE_PR_FIRM_PROP")
    private Double insArchivePrFirmProp;

    @ApiModelProperty(value = "养老保险企业固定缴纳")
    @TableField("INS_ARCHIVE_PR_FIRM_SUM")
    private Double insArchivePrFirmSum;

    @ApiModelProperty(value = "医疗保险基数 ")
    @TableField("INS_ARCHIVE_MD_NUMBER")
    private Double insArchiveMdNumber;

    @ApiModelProperty(value = "医疗保险上限")
    @TableField("INS_ARCHIVE_MD_UPPER")
    private Double insArchiveMdUpper;

    @ApiModelProperty(value = "医疗保险下限")
    @TableField("INS_ARCHIVE_MD_FLOOR")
    private Double insArchiveMdFloor;

    @ApiModelProperty(value = "医疗保险个人缴纳比例")
    @TableField("INS_ARCHIVE_MD_PERSON_PROP")
    private Double insArchiveMdPersonProp;

    @ApiModelProperty(value = "医疗保险个人固定缴纳")
    @TableField("INS_ARCHIVE_MD_PERSON_SUM")
    private Double insArchiveMdPersonSum;

    @ApiModelProperty(value = " 医疗保险企业缴纳比例")
    @TableField("INS_ARCHIVE_MD_FIRM_PROP")
    private Double insArchiveMdFirmProp;

    @ApiModelProperty(value = "医疗保险企业固定缴纳")
    @TableField("INS_ARCHIVE_MD_FIRM_SUM")
    private Double insArchiveMdFirmSum;

    @ApiModelProperty(value = "失业保险基数 ")
    @TableField("INS_ARCHIVE_UN_NUMBER")
    private Double insArchiveUnNumber;


    @ApiModelProperty(value = "失业保险上限")
    @TableField("INS_ARCHIVE_UN_UPPER")
    private Double insArchiveUnUpper;

    @ApiModelProperty(value = "失业保险下限")
    @TableField("INS_ARCHIVE_UN_FLOOR")
    private Double insArchiveUnFloor;

    @ApiModelProperty(value = "失业保险个人缴纳比例")
    @TableField("INS_ARCHIVE_UN_PERSON_PROP")
    private Double insArchiveUnPersonProp;

    @ApiModelProperty(value = "失业保险个人固定缴纳")
    @TableField("INS_ARCHIVE_UN_PERSON_SUM")
    private Double insArchiveUnPersonSum;

    @ApiModelProperty(value = "失业保险企业缴纳比例")
    @TableField("INS_ARCHIVE_UN_FIRM_PROP")
    private Double insArchiveUnFirmProp;

    @ApiModelProperty(value = "失业保险企业固定缴纳")
    @TableField("INS_ARCHIVE_UN_FIRM_SUM")
    private Double insArchiveUnFirmSum;

    @ApiModelProperty(value = "工伤保险基数 ")
    @TableField("INS_ARCHIVE_OC_NUMBER")
    private Double insArchiveOcNumber;


    @ApiModelProperty(value = "工伤保险上限")
    @TableField("INS_ARCHIVE_OC_UPPER")
    private Double insArchiveOcUpper;

    @ApiModelProperty(value = "工伤保险下限")
    @TableField("INS_ARCHIVE_OC_FLOOR")
    private Double insArchiveOcFloor;

    @ApiModelProperty(value = "工伤保险个人缴纳比例")
    @TableField("INS_ARCHIVE_OC_PERSON_PROP")
    private Double insArchiveOcPersonProp;

    @ApiModelProperty(value = "工伤保险个人固定缴纳")
    @TableField("INS_ARCHIVE_OC_PERSON_SUM")
    private Double insArchiveOcPersonSum;

    @ApiModelProperty(value = "工伤保险企业缴纳比例")
    @TableField("INS_ARCHIVE_OC_FIRM_PROP")
    private Double insArchiveOcFirmProp;

    @ApiModelProperty(value = "工伤保险企业固定缴纳")
    @TableField("INS_ARCHIVE_OC_FIRM_SUM")
    private Double insArchiveOcFirmSum;

    @ApiModelProperty(value = "生育保险基数 ")
    @TableField("INS_ARCHIVE_GI_NUMBER")
    private Double insArchiveGiNumber;


    @ApiModelProperty(value = "生育保险上限")
    @TableField("INS_ARCHIVE_GI_UPPER")
    private Double insArchiveGiUpper;

    @ApiModelProperty(value = "生育保险下限")
    @TableField("INS_ARCHIVE_GI_FLOOR")
    private Double insArchiveGiFloor;


    @ApiModelProperty(value = " 生育保险个人缴纳比例")
    @TableField("INS_ARCHIVE_GI_PERSON_PROP")
    private Double insArchiveGiPersonProp;

    @ApiModelProperty(value = "生育保险个人固定缴纳")
    @TableField("INS_ARCHIVE_GI_PERSON_SUM")
    private Double insArchiveGiPersonSum;

    @ApiModelProperty(value = " 生育保险企业缴纳比例")
    @TableField("INS_ARCHIVE_GI_FIRM_PROP")
    private Double insArchiveGiFirmProp;

    @ApiModelProperty(value = "生育保险企业固定缴纳")
    @TableField("INS_ARCHIVE_GI_FIRM_SUM")
    private Double insArchiveGiFirmSum;

    @ApiModelProperty(value = "积金基数 ")
    @TableField("INS_ARCHIVE_FU_NUMBER")
    private Double insArchiveFuNumber;

    @ApiModelProperty(value = "积金上限")
    @TableField("INS_ARCHIVE_FU_UPPER")
    private Double insArchiveFuUpper;

    @ApiModelProperty(value = "积金下限")
    @TableField("INS_ARCHIVE_FU_FLOOR")
    private Double insArchiveFuFloor;

    @ApiModelProperty(value = "积金个人缴纳比例")
    @TableField("INS_ARCHIVE_FU_PERSON_PROP")
    private Double insArchiveFuPersonProp;

    @ApiModelProperty(value = "积金个人固定缴纳")
    @TableField("INS_ARCHIVE_FU_PERSON_SUM")
    private Double insArchiveFuPersonSum;

    @ApiModelProperty(value = "积金企业缴纳比例")
    @TableField("INS_ARCHIVE_FU_FIRM_PROP")
    private Double insArchiveFuFirmProp;

    @ApiModelProperty(value = "积金企业固定缴纳")
    @TableField("INS_ARCHIVE_FU_FIRM_SUM")
    private Double insArchiveFuFirmSum;

    @ApiModelProperty(value = "归档名称")
    @TableField("INS_ARCHIVE_NAME")
    private String insArchiveName;

    @ApiModelProperty(value = "员工名称")
    @TableField("INS_ARCHIVE_STAFF_NAME")
    private String insArchiveStaffName;

    @ApiModelProperty(value = "部门名称")
    @TableField("INS_ARCHIVE_DEPT_NAME")
    private String insArchiveDeptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("INS_ARCHIVE_POST_NAME")
    private String insArchivePostName;

    @ApiModelProperty(value = "参保方案名称")
    @TableField("INS_ARCHIVE_INSURED_NAME")
    private String insArchiveInsuredName;

    @ApiModelProperty(value = "参保月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_ARCHIVE_INSURED_MONTH")
    private Date insArchiveInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_ARCHIVE_SALARY_MONTH")
    private Date insArchiveSalaryMonth;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_ARCHIVE_SOCIAL_PERSON_PAY")
    private Double insArchiveSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_ARCHIVE_SOCIAL_FIRM_PAY")
    private Double insArchiveSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_ARCHIVE_FUND_PERSON_PAY")
    private Double insArchiveFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_ARCHIVE_FUND_FIRM_PAY")
    private Double insArchiveFundFirmPay;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pagesize;

}
