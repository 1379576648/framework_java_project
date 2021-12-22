package com.trkj.framework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class StaffEntity {
    private Long staffId;
    /** 员工编号 */
    private String staffName;
    /** 员工姓名 */
    private String staffSex;
    /** 员工性别 */
    private Long staffPhone;
    /** 员工手机号码 */
    private String staffEmail;
    /** 员工邮箱 */
    private String staffPicture;
    /** 员工照片 */
    private Date staffBirthday;
    /** 员工生日 */
    private String staffOutlook;
    /** 政治面貌 */
    private String staffEducation;
    /** 学历 */
    private String positionName;
    /** 职位 */
    private String staffPass;
    /** 密码 */
    private Date staffHIREDATE;
    /** 入职日期 */
    private long workerId;
    /** 转正编号 */
    private String staffIdentity;
    /** 员工身份证 */
    private long deptId;
    /** 部门编号 */
    private String deptName;
    /** 部门名称 */
    private String staffMajor;
    /** 员工专业 */
    private long staffEmergency;
    /** 紧急联系人 */
    private String staffWechat;
    /** 微信 */
    private String staffCredit;
    /** 银行卡号 */
    private String staff_blood;
    /** 血型 */
    private String staffSign;
    /** 星座 */
    private String staffMarital;
    /** 婚姻状态 */
    private String staffRegistered;
    /** 户口所在地 */
    private String staffSchool;
    /** 毕业学校 */
    private String staffAddress;
    /** 现住地址 */
    private Long WORKEXPERIENCEID;
    /** 工作经历编号 */
    private Long EDUCATIONID;
    /** 教育经历编号 */
    private Long GLORYID;
    /** 获奖编号 */
    private String GLORYNAME;
    /** 获奖名称 */
    private Date CREATEDTIME1;
    /** 获奖时间 */
    private Long PUNISHID;
    /** 惩罚编号 */
    private String PUNISHCAUSE;
    /** 惩罚原因 */
    private Date CREATEDTIME2;
    /** 惩罚时间 */
    private Date CREATEDTIME;
    /** 创建时间 */
    private Date UPDATEDTIME;
    /** 修改时间 */
    private Long ISDELETED;
    /** 逻辑删除 */

    public StaffEntity(Long staffPhone, String staffEmail, Date staffBirthday, String staffOutlook, String staffEducation, String positionName, String staffPass, Date staffHIREDATE, String staffIdentity, String staffMajor, long staffEmergency, String staffWechat, String staffCredit, String staff_blood, String staffSign, String staffMarital, String staffRegistered, String staffSchool, String staffAddress) {
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffBirthday = staffBirthday;
        this.staffOutlook = staffOutlook;
        this.staffEducation = staffEducation;
        this.positionName = positionName;
        this.staffPass = staffPass;
        this.staffHIREDATE = staffHIREDATE;
        this.staffIdentity = staffIdentity;
        this.staffMajor = staffMajor;
        this.staffEmergency = staffEmergency;
        this.staffWechat = staffWechat;
        this.staffCredit = staffCredit;
        this.staff_blood = staff_blood;
        this.staffSign = staffSign;
        this.staffMarital = staffMarital;
        this.staffRegistered = staffRegistered;
        this.staffSchool = staffSchool;
        this.staffAddress = staffAddress;
    }
}
