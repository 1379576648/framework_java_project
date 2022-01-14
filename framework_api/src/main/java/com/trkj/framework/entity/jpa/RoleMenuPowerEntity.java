package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenuPowerEntity that = (RoleMenuPowerEntity) o;
        return roleMenuPowerId == that.roleMenuPowerId && roleId == that.roleId && menuPowerId == that.menuPowerId && revision == that.revision && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleMenuPowerId, roleId, menuPowerId, createdTime, updatedTime, revision);
    }
}
