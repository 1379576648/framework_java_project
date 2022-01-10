package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "MENU_POWER", schema = "POWER", catalog = "")
public class MenuPowerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MENU_POWER_ID", nullable = false, precision = 0)
    private int menuPowerId;
    @Basic
    @Column(name = "MENU_POWER_PID", nullable = false, precision = 0)
    private int menuPowerPid;
    @Basic
    @Column(name = "MENU_POWER_ORDER", nullable = false, precision = 0)
    private int menuPowerOrder;
    @Basic
    @Column(name = "MENU_POWER_LEAF", nullable = false, precision = 0)
    private int menuPowerLeaf;
    @Basic
    @Column(name = "MENU_POWER_TYPE", nullable = false, precision = 0)
    private int menuPowerType;
    @Basic
    @Column(name = "MENU_POWER_STATE", nullable = false, precision = 0)
    private int menuPowerState;
    @Basic
    @Column(name = "MENU_POWER_NAME", nullable = false, length = 50)
    private String menuPowerName;
    @Basic
    @Column(name = "MENU_POWER_ROUTE", nullable = true, length = 100)
    private String menuPowerRoute;
    @Basic
    @Column(name = "PICTURE_ADDRESS", nullable = true, length = 100)
    private String pictureAddress;
    @Basic
    @Column(name = "MENU_POWER_MODULE", nullable = true, length = 100)
    private String menuPowerModule;
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

    @Transient
    private List<MenuPowerEntity> list;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuPowerEntity that = (MenuPowerEntity) o;
        return menuPowerId == that.menuPowerId && menuPowerPid == that.menuPowerPid && menuPowerOrder == that.menuPowerOrder && menuPowerLeaf == that.menuPowerLeaf && menuPowerType == that.menuPowerType && menuPowerState == that.menuPowerState && revision == that.revision && Objects.equals(menuPowerName, that.menuPowerName) && Objects.equals(menuPowerRoute, that.menuPowerRoute) && Objects.equals(pictureAddress, that.pictureAddress) && Objects.equals(menuPowerModule, that.menuPowerModule) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuPowerId, menuPowerPid, menuPowerOrder, menuPowerLeaf, menuPowerType, menuPowerState, menuPowerName, menuPowerRoute, pictureAddress, menuPowerModule, createdTime, updatedTime, revision, isDeleted);
    }
}
