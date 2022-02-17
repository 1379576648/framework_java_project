package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "ROLE", schema = "POWER", catalog = "")
public class RoleEntity {
    @Id
    @Column(name = "ROLE_ID")
    private int roleId;
    @Basic
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Basic
    @Column(name = "ROLE_STATE")
    private byte roleState;
    @Basic
    @Column(name = "ROLE_DESCRIBE")
    private String roleDescribe;
    @Basic
    @Column(name = "CREATED_TIME")
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
    @Basic
    @Column(name = "REVISION")
    private int revision;
    @Basic
    @Column(name = "IS_DELETED")
    private Integer isDeleted;
    @OneToMany(mappedBy = "role")
    private List<RoleStaffEntity> roleStaff;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public byte getRoleState() {
        return roleState;
    }

    public void setRoleState(byte roleState) {
        this.roleState = roleState;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
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
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId && roleState == that.roleState && revision == that.revision && Objects.equals(roleName, that.roleName) && Objects.equals(roleDescribe, that.roleDescribe) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleState, roleDescribe, createdTime, updatedTime, revision, isDeleted);
    }

    public List<RoleStaffEntity> getRoleStaff() {
        return roleStaff;
    }

    public void setRoleStaff(List<RoleStaffEntity> roleStaff) {
        this.roleStaff = roleStaff;
    }
}
