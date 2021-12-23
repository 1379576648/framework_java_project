package com.trkj.framework.entity.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class staff_workvo {

    private String staffName;

    private Long workExperienceId;

    private Date workStareTime;

    private Date workEndTime;

    private Long staffId;

    private String companyName;

    private String positionName;

    private String positionIndustry;


    private String positionDescribe;


    private Long positionSqmonthly;

    private Date createdTime;

    private Date updatedTime;

    private Long revision;

    private Long isDeleted;

}
