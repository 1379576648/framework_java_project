package com.trkj.framework.jpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "STAFF", schema = "POWER", catalog = "")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "STAFF_ID")
    private Integer staffId;
    @Basic
    @Column(name = "STAFF_NAME")
    private String staffName;
    @Basic
    @Column(name = "STAFF_SEX")
    private String staffSex;
    @Basic
    @Column(name = "STAFF_PHONE")
    private Integer staffPhone;
    @Basic
    @Column(name = "STAFF_EMAIL")
    private String staffEmail;
    @Basic
    @Column(name = "STAFF_PICTURE")
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
    @Column(name = "POSITION_NAME")
    private String positionName;
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
    @Column(name = "WORK_EXPERIENCE_ID")
    private Integer workExperienceId;
    @Basic
    @Column(name = "EDUCATION_ID")
    private Integer educationId;
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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
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

    public Integer getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(Integer staffPhone) {
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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

    public Integer getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(Integer workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
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

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return staffId == that.staffId && staffPhone == that.staffPhone && deptId == that.deptId && isDeleted == that.isDeleted && revision == that.revision && Objects.equals(staffName, that.staffName) && Objects.equals(staffSex, that.staffSex) && Objects.equals(staffEmail, that.staffEmail) && Objects.equals(staffPicture, that.staffPicture) && Objects.equals(staffBirthday, that.staffBirthday) && Objects.equals(staffOutlook, that.staffOutlook) && Objects.equals(staffEducation, that.staffEducation) && Objects.equals(positionName, that.positionName) && Objects.equals(staffPass, that.staffPass) && Objects.equals(staffHiredate, that.staffHiredate) && Objects.equals(workerId, that.workerId) && Objects.equals(staffIdentity, that.staffIdentity) && Objects.equals(staffMajor, that.staffMajor) && Objects.equals(staffEmergency, that.staffEmergency) && Objects.equals(staffWechat, that.staffWechat) && Objects.equals(staffCredit, that.staffCredit) && Objects.equals(staffBlood, that.staffBlood) && Objects.equals(staffSign, that.staffSign) && Objects.equals(staffMarital, that.staffMarital) && Objects.equals(staffRegistered, that.staffRegistered) && Objects.equals(staffSchool, that.staffSchool) && Objects.equals(staffAddress, that.staffAddress) && Objects.equals(workExperienceId, that.workExperienceId) && Objects.equals(educationId, that.educationId) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffSex, staffPhone, staffEmail, staffPicture, staffBirthday, staffOutlook, staffEducation, positionName, staffPass, staffHiredate, workerId, staffIdentity, deptId, staffMajor, staffEmergency, staffWechat, staffCredit, staffBlood, staffSign, staffMarital, staffRegistered, staffSchool, staffAddress, workExperienceId, educationId, createdTime, updatedTime, isDeleted, revision);
    }
}
