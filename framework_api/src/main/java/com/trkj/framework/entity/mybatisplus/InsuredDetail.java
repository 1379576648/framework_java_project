package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 参保明细表
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_DETAIL")
@ApiModel(value="InsuredDetail对象", description="参保明细表")
/***
 * value=自增序列名 clazz=实体类的数据类型
 */
@KeySequence(value = "INS_DETAIL_ID",clazz = Integer.class)
public class InsuredDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保明细编号")
    @TableId("INS_DETAIL_ID")
    private Integer insDetailId;

    @ApiModelProperty(value = "员工名称")
    @TableField("INS_DETAIL_STAFF_NAME")
    private String insDetailStaffName;

    @ApiModelProperty(value = "参保方案名称")
    @TableField("INS_DETAIL_INSURED_NAME")
    private String insDetailInsuredName;


    @ApiModelProperty(value = "参保月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_DETAIL_INSURED_MONTH")
    private Date insDetailInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @TableField("INS_DETAIL_SALARY_MONTH")
    private Date insDetailSalaryMonth;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_DETAIL_SOCIAL_PERSON_PAY")
    private Double insDetailSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_DETAIL_SOCIAL_FIRM_PAY")
    private Double insDetailSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_DETAIL_FUND_PERSON_PAY")
    private Double insDetailFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_DETAIL_FUND_FIRM_PAY")
    private Double insDetailFundFirmPay;

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


    @ApiModelProperty(value = "员工")
    @TableField(exist = false)
    private Staff staff;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    private Dept dept;

    @ApiModelProperty(value = "部门编号列表")
    @TableField(exist = false)
    private List<Integer> deptIdList;

    @ApiModelProperty(value = "员工状态")
    @TableField(exist = false)
    private Integer staffState;

    @ApiModelProperty(value = "员工名称")
    @TableField(exist = false)
    private String  staffName;

    @ApiModelProperty(value = "员工编号列表")
    @TableField(exist = false)
    private ArrayList<Integer> staffIdList;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currenPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;


}
