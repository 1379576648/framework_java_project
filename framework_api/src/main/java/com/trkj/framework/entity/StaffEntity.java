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

    private String DEPTPOSTID;
    /** 职位编号 */

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

    private String staffBlood;
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

    private Date WORKSTARETIME;
    /** 工作开始时间 */

    private Date WORKENDTIME;
    /** 工作结束时间 */

    private String COMPANYNAME;
    /** 公司名称 */

    private String POSITIONNAME;
    /** 职位名称 */

    private Long EDUCATIONID;
    /** 教育经历编号 */

    private Date EDUCATIONSTARTTIME;
    /** 教育开始时间 */

    private Date EDUCATIONENDTIME;
    /** 教育结束时间 */

    private String EDUCATIONSTUDENTNAME;
    /** 学校名称 */

    private Long GLORYID;
    /** 获奖编号 */

    private String GLORYNAME;
    /** 获奖名称 */

    private String GLORYUNITNAME;
    /** 颁发单位名称 */

    private String GLORYREMARK;
    /** 备注 */

    private Long PUNISHID;
    /** 惩罚编号 */

    private String PUNISHCAUSE;
    /** 惩罚原因 */

    private String PUNISHTYPE;
    /** 惩罚类型 */

    private String PUNISHUNIT;
    /** 惩罚单位 */

    private Long ISREVOCATION;
    /** 是否撤销 */

    private Date CREATEDTIME;
    /** 创建时间 */

    private Date UPDATEDTIME;
    /** 修改时间 */

    private Long ISDELETED;
    /** 逻辑删除 */

    public StaffEntity(Long staffPhone, String staffEmail, Date staffBirthday, String staffOutlook, String staffEducation, String DEPTPOSTID, String staffPass, Date staffHIREDATE, String staffIdentity, String staffMajor, long staffEmergency, String staffWechat, String staffCredit, String staffBlood, String staffSign, String staffMarital, String staffRegistered, String staffSchool, String staffAddress) {
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffBirthday = staffBirthday;
        this.staffOutlook = staffOutlook;
        this.staffEducation = staffEducation;
        this.DEPTPOSTID = DEPTPOSTID;
        this.staffPass = staffPass;
        this.staffHIREDATE = staffHIREDATE;
        this.staffIdentity = staffIdentity;
        this.staffMajor = staffMajor;
        this.staffEmergency = staffEmergency;
        this.staffWechat = staffWechat;
        this.staffCredit = staffCredit;
        this.staffBlood = staffBlood;
        this.staffSign = staffSign;
        this.staffMarital = staffMarital;
        this.staffRegistered = staffRegistered;
        this.staffSchool = staffSchool;
        this.staffAddress = staffAddress;
    }
}
