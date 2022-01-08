package com.trkj.framework.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ROLE_MENU_POWER", schema = "POWER", catalog = "")
public class RoleMenuPowerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROLE_MENU_POWER_ID", nullable = false, precision = 0)
    private int roleMenuPowerId;
    @Basic
    @Column(name = "ROLE_ID", nullable = false, precision = 0)
    private int roleId;
    @Basic
    @Column(name = "MENU_POWER_ID", nullable = false, precision = 0)
    private int menuPowerId;
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

    public int getRoleMenuPowerId() {
        return roleMenuPowerId;
    }

    public void setRoleMenuPowerId(int roleMenuPowerId) {
        this.roleMenuPowerId = roleMenuPowerId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMenuPowerId() {
        return menuPowerId;
    }

    public void setMenuPowerId(int menuPowerId) {
        this.menuPowerId = menuPowerId;
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
        RoleMenuPowerEntity that = (RoleMenuPowerEntity) o;
        return roleMenuPowerId == that.roleMenuPowerId && roleId == that.roleId && menuPowerId == that.menuPowerId && revision == that.revision && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleMenuPowerId, roleId, menuPowerId, createdTime, updatedTime, revision, isDeleted);
    }
}
