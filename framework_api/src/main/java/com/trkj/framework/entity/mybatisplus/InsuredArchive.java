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
import java.util.List;

/**
 * <p>
 * 参保归档表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_ARCHIVE")
@ApiModel(value="InsuredArchive对象", description="参保归档表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "INSURED_ARCHIVE_ID",clazz = Integer.class)
public class InsuredArchive implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;


    @ApiModelProperty(value = "起始时间")
    @TableField(exist = false)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(exist = false)
    private Date endTime;


    @ApiModelProperty(value = "归档数量")
    @TableField(exist = false)
    private Integer quantity;


    @ApiModelProperty(value = "列表部门")
    @TableField(exist = false)
    private List<String> listDept;
}
