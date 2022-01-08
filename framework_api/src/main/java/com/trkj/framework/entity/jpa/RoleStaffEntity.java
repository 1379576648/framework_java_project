package com.trkj.framework.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ROLE_STAFF", schema = "POWER", catalog = "")
public class RoleStaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROLE_STAFF_ID", nullable = false, precision = 0)
    private int roleStaffId;
    @Basic
    @Column(name = "ROLE_ID", nullable = false, precision = 0)
    private int roleId;
    @Basic
    @Column(name = "STAFF_ID", nullable = false, precision = 0)
    private int staffId;
    @Basic
    @Column(name = "CREATED_TIME", nullable = false)
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME", nullable = false)
    private Date updatedTime;
    @Basic
    @Column(name = "REVISION", nullable = false, precision = 0)
    private int revision;
    @Basic
    @Column(name = "IS_DELETED", nullable = true, precision = 0)
    private Integer isDeleted;

    public int getRoleStaffId() {
        return roleStaffId;
    }

    public void setRoleStaffId(int roleStaffId) {
        this.roleStaffId = roleStaffId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleStaffEntity that = (RoleStaffEntity) o;
        return roleStaffId == that.roleStaffId && roleId == that.roleId && staffId == that.staffId && revision == that.revision && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleStaffId, roleId, staffId, createdTime, updatedTime, revision, isDeleted);
    }
}
