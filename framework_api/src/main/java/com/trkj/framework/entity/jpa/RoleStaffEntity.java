package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "ROLE_STAFF", schema = "POWER", catalog = "")
public class RoleStaffEntity {
    @Id
    @Column(name = "ROLE_STAFF_ID")
    private int roleStaffId;
    @Basic
    @Column(name = "ROLE_ID")
    private int roleId;
    @Basic
    @Column(name = "STAFF_ID")
    private int staffId;
    @Basic
    @Column(name = "CREATED_TIME")
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
    @Basic
    @Column(name = "REVISION")
    private int revision;
    @ManyToOne
    private RoleEntity role;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleStaffEntity that = (RoleStaffEntity) o;
        return roleStaffId == that.roleStaffId && roleId == that.roleId && staffId == that.staffId && revision == that.revision && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleStaffId, roleId, staffId, createdTime, updatedTime, revision);
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
