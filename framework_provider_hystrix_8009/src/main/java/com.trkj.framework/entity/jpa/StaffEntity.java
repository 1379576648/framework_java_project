package com.trkj.framework.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "STAFF", schema = "POWER", catalog = "")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "STAFF_ID", nullable = false, precision = 0)
    private int staffId;
    @Basic
    @Column(name = "STAFF_NAME", nullable = false, length = 20)
    private String staffName;
    @Basic
    @Column(name = "STAFF_SEX", nullable = false, length = 2)
    private String staffSex;
    @Basic
    @Column(name = "STAFF_PHONE", nullable = false, precision = 0)
    private long staffPhone;
    @Basic
    @Column(name = "STAFF_EMAIL", nullable = true, length = 50)
    private String staffEmail;
    @Basic
    @Column(name = "STAFF_PICTURE", nullable = false, length = 200)
    private String staffPicture;
    @Basic
    @Column(name = "STAFF_BIRTHDAY", nullable = false)
    private Date staffBirthday;
    @Basic
    @Column(name = "STAFF_OUTLOOK", nullable = false, length = 10)
    private String staffOutlook;
    @Basic
    @Column(name = "STAFF_EDUCATION", nullable = false, length = 10)
    private String staffEducation;
    @Basic
    @Column(name = "DEPT_POST_ID", nullable = false, precision = 0)
    private int deptPostId;
    @Basic
    @Column(name = "STAFF_PASS", nullable = false, length = 100)
    private String staffPass;
    @Basic
    @Column(name = "STAFF_HIREDATE", nullable = false)
    private Date staffHiredate;
    @Basic
    @Column(name = "WORKER_ID", nullable = true, precision = 0)
    private Integer workerId;
    @Basic
    @Column(name = "STAFF_IDENTITY", nullable = true, length = 28)
    private String staffIdentity;
    @Basic
    @Column(name = "DEPT_ID", nullable = false, precision = 0)
    private int deptId;
    @Basic
    @Column(name = "STAFF_MAJOR", nullable = true, length = 1000)
    private String staffMajor;
    @Basic
    @Column(name = "STAFF_EMERGENCY", nullable = true, precision = 0)
    private Long staffEmergency;
    @Basic
    @Column(name = "STAFF_WECHAT", nullable = true, length = 100)
    private String staffWechat;
    @Basic
    @Column(name = "STAFF_QQ", nullable = true, length = 100)
    private String staffQq;
    @Basic
    @Column(name = "STAFF_CREDIT", nullable = true, length = 50)
    private String staffCredit;
    @Basic
    @Column(name = "STAFF_BLOOD", nullable = true, length = 10)
    private String staffBlood;
    @Basic
    @Column(name = "STAFF_SIGN", nullable = true, length = 10)
    private String staffSign;
    @Basic
    @Column(name = "STAFF_MARITAL", nullable = true, length = 10)
    private String staffMarital;
    @Basic
    @Column(name = "STAFF_REGISTERED", nullable = true, length = 100)
    private String staffRegistered;
    @Basic
    @Column(name = "STAFF_SCHOOL", nullable = true, length = 100)
    private String staffSchool;
    @Basic
    @Column(name = "STAFF_ADDRESS", nullable = true, length = 100)
    private String staffAddress;
    @Basic
    @Column(name = "CREATED_TIME", nullable = false)
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME", nullable = false)
    private Date updatedTime;
    @Basic
    @Column(name = "IS_DELETED", nullable = false, precision = 0)
    private int isDeleted;
    @Basic
    @Column(name = "REVISION", nullable = false, precision = 0)
    private int revision;
    @Basic
    @Column(name = "POST_ID", nullable = true, precision = 0)
    private Integer postId;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public long getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(long staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPicture() {
        return staffPicture;
    }

    public void setStaffPicture(String staffPicture) {
        this.staffPicture = staffPicture;
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffOutlook() {
        return staffOutlook;
    }

    public void setStaffOutlook(String staffOutlook) {
        this.staffOutlook = staffOutlook;
    }

    public String getStaffEducation() {
        return staffEducation;
    }

    public void setStaffEducation(String staffEducation) {
        this.staffEducation = staffEducation;
    }

    public int getDeptPostId() {
        return deptPostId;
    }

    public void setDeptPostId(int deptPostId) {
        this.deptPostId = deptPostId;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    public Date getStaffHiredate() {
        return staffHiredate;
    }

    public void setStaffHiredate(Date staffHiredate) {
        this.staffHiredate = staffHiredate;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getStaffIdentity() {
        return staffIdentity;
    }

    public void setStaffIdentity(String staffIdentity) {
        this.staffIdentity = staffIdentity;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStaffMajor() {
        return staffMajor;
    }

    public void setStaffMajor(String staffMajor) {
        this.staffMajor = staffMajor;
    }

    public Long getStaffEmergency() {
        return staffEmergency;
    }

    public void setStaffEmergency(Long staffEmergency) {
        this.staffEmergency = staffEmergency;
    }

    public String getStaffWechat() {
        return staffWechat;
    }

    public void setStaffWechat(String staffWechat) {
        this.staffWechat = staffWechat;
    }

    public String getStaffQq() {
        return staffQq;
    }

    public void setStaffQq(String staffQq) {
        this.staffQq = staffQq;
    }

    public String getStaffCredit() {
        return staffCredit;
    }

    public void setStaffCredit(String staffCredit) {
        this.staffCredit = staffCredit;
    }

    public String getStaffBlood() {
        return staffBlood;
    }

    public void setStaffBlood(String staffBlood) {
        this.staffBlood = staffBlood;
    }

    public String getStaffSign() {
        return staffSign;
    }

    public void setStaffSign(String staffSign) {
        this.staffSign = staffSign;
    }

    public String getStaffMarital() {
        return staffMarital;
    }

    public void setStaffMarital(String staffMarital) {
        this.staffMarital = staffMarital;
    }

    public String getStaffRegistered() {
        return staffRegistered;
    }

    public void setStaffRegistered(String staffRegistered) {
        this.staffRegistered = staffRegistered;
    }

    public String getStaffSchool() {
        return staffSchool;
    }

    public void setStaffSchool(String staffSchool) {
        this.staffSchool = staffSchool;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return staffId == that.staffId && staffPhone == that.staffPhone && deptPostId == that.deptPostId && deptId == that.deptId && isDeleted == that.isDeleted && revision == that.revision && Objects.equals(staffName, that.staffName) && Objects.equals(staffSex, that.staffSex) && Objects.equals(staffEmail, that.staffEmail) && Objects.equals(staffPicture, that.staffPicture) && Objects.equals(staffBirthday, that.staffBirthday) && Objects.equals(staffOutlook, that.staffOutlook) && Objects.equals(staffEducation, that.staffEducation) && Objects.equals(staffPass, that.staffPass) && Objects.equals(staffHiredate, that.staffHiredate) && Objects.equals(workerId, that.workerId) && Objects.equals(staffIdentity, that.staffIdentity) && Objects.equals(staffMajor, that.staffMajor) && Objects.equals(staffEmergency, that.staffEmergency) && Objects.equals(staffWechat, that.staffWechat) && Objects.equals(staffQq, that.staffQq) && Objects.equals(staffCredit, that.staffCredit) && Objects.equals(staffBlood, that.staffBlood) && Objects.equals(staffSign, that.staffSign) && Objects.equals(staffMarital, that.staffMarital) && Objects.equals(staffRegistered, that.staffRegistered) && Objects.equals(staffSchool, that.staffSchool) && Objects.equals(staffAddress, that.staffAddress) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffSex, staffPhone, staffEmail, staffPicture, staffBirthday, staffOutlook, staffEducation, deptPostId, staffPass, staffHiredate, workerId, staffIdentity, deptId, staffMajor, staffEmergency, staffWechat, staffQq, staffCredit, staffBlood, staffSign, staffMarital, staffRegistered, staffSchool, staffAddress, createdTime, updatedTime, isDeleted, revision, postId);
    }
}
