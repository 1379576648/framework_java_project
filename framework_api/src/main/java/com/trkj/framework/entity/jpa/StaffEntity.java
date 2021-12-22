package com.trkj.framework.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "STAFF", schema = "POWER", catalog = "")
public class StaffEntity {
    private Integer staffId;
    private String staffName;
    private String staffSex;
    private Integer staffPhone;
    private String staffEmail;
    private String staffPicture;
    @Basic
    @Column(name = "STAFF_BIRTHDAY")
    private Date staffBirthday;
    @Basic
    @Column(name = "STAFF_OUTLOOK")
    private String staffOutlook;
    @Basic
    @Column(name = "STAFF_EDUCATION")
    private String staffEducation;
    @Basic
    @Column(name = "POST_ID")
    private Integer postId;
    @Basic
    @Column(name = "STAFF_PASS")
    private String staffPass;
    @Basic
    @Column(name = "STAFF_HIREDATE")
    private Date staffHiredate;
    @Basic
    @Column(name = "WORKER_ID")
    private Integer workerId;
    @Basic
    @Column(name = "STAFF_IDENTITY")
    private String staffIdentity;
    @Basic
    @Column(name = "DEPT_ID")
    private Integer deptId;
    @Basic
    @Column(name = "STAFF_MAJOR")
    private String staffMajor;
    @Basic
    @Column(name = "STAFF_EMERGENCY")
    private Integer staffEmergency;
    @Basic
    @Column(name = "STAFF_WECHAT")
    private String staffWechat;
    @Basic
    @Column(name = "STAFF_QQ")
    private String staffQq;
    @Basic
    @Column(name = "STAFF_CREDIT")
    private String staffCredit;
    @Basic
    @Column(name = "STAFF_BLOOD")
    private String staffBlood;
    @Basic
    @Column(name = "STAFF_SIGN")
    private String staffSign;
    @Basic
    @Column(name = "STAFF_MARITAL")
    private String staffMarital;
    @Basic
    @Column(name = "STAFF_REGISTERED")
    private String staffRegistered;
    @Basic
    @Column(name = "STAFF_SCHOOL")
    private String staffSchool;
    @Basic
    @Column(name = "STAFF_ADDRESS")
    private String staffAddress;
    @Basic
    @Column(name = "CREATED_TIME")
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
    @Basic
    @Column(name = "IS_DELETED")
    private Integer isDeleted;
    @Basic
    @Column(name = "REVISION")
    private Integer revision;


    @Id
    @Column(name = "STAFF_ID")
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    @Basic
    @Column(name = "STAFF_NAME")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    @Basic
    @Column(name = "STAFF_SEX")
    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }
    @Basic
    @Column(name = "STAFF_PHONE")
    public Integer getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(Integer staffPhone) {
        this.staffPhone = staffPhone;
    }
    @Basic
    @Column(name = "STAFF_EMAIL")
    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    @Basic
    @Column(name = "STAFF_PICTURE")
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getStaffMajor() {
        return staffMajor;
    }

    public void setStaffMajor(String staffMajor) {
        this.staffMajor = staffMajor;
    }

    public Integer getStaffEmergency() {
        return staffEmergency;
    }

    public void setStaffEmergency(Integer staffEmergency) {
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StaffEntity that = (StaffEntity) o;
        return staffId.equals(that.staffId) && staffPhone.equals(that.staffPhone) && postId == that.postId && deptId == that.deptId && isDeleted == that.isDeleted && revision.equals(that.revision) && Objects.equals(staffName, that.staffName) && Objects.equals(staffSex, that.staffSex) && Objects.equals(staffEmail, that.staffEmail) && Objects.equals(staffPicture, that.staffPicture) && Objects.equals(staffBirthday, that.staffBirthday) && Objects.equals(staffOutlook, that.staffOutlook) && Objects.equals(staffEducation, that.staffEducation) && Objects.equals(staffPass, that.staffPass) && Objects.equals(staffHiredate, that.staffHiredate) && Objects.equals(workerId, that.workerId) && Objects.equals(staffIdentity, that.staffIdentity) && Objects.equals(staffMajor, that.staffMajor) && Objects.equals(staffEmergency, that.staffEmergency) && Objects.equals(staffWechat, that.staffWechat) && Objects.equals(staffQq, that.staffQq) && Objects.equals(staffCredit, that.staffCredit) && Objects.equals(staffBlood, that.staffBlood) && Objects.equals(staffSign, that.staffSign) && Objects.equals(staffMarital, that.staffMarital) && Objects.equals(staffRegistered, that.staffRegistered) && Objects.equals(staffSchool, that.staffSchool) && Objects.equals(staffAddress, that.staffAddress) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffSex, staffPhone, staffEmail, staffPicture, staffBirthday, staffOutlook, staffEducation, postId, staffPass, staffHiredate, workerId, staffIdentity, deptId, staffMajor, staffEmergency, staffWechat, staffQq, staffCredit, staffBlood, staffSign, staffMarital, staffRegistered, staffSchool, staffAddress, createdTime, updatedTime, isDeleted, revision);
    }
}
