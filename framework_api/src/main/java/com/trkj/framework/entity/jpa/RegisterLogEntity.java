package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "REGISTER_LOG", schema = "POWER", catalog = "")
public class RegisterLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "REGISTER_LOG_ID", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "REGISTER_LOG_ID", nullable = false, precision = 0)
    private int registerLogId;
    @Basic
    @Column(name = "REGISTER_LOG_PEOPLE", nullable = true, length = 20)
    private String registerLogPeople;
    @Basic
    @Column(name = "REGISTER_LOG_PHONE", nullable = true, precision = 0)
    private Long registerLogPhone;
    @Basic
    @Column(name = "REGISTER_LOG_IP", nullable = false, length = 100)
    private String registerLogIp;
    @Basic
    @Column(name = "REGISTER_LOG_IPNAME", nullable = false, length = 100)
    private String registerLogIpName;
    @Basic
    @Column(name = "REGISTER_LOG_TYPE", nullable = false, length = 100)
    private String registerLogType;
    @Basic
    @Column(name = "REGISTER_LOG_STATE", nullable = true, precision = 0)
    private Integer registerLogState;
    @Basic
    @Column(name = "REGISTER_LOG_BROWSER", nullable = false, length = 100)
    private String registerLogBrowser;
    @Basic
    @Column(name = "REGISTER_LOG_GENRE", nullable = true, precision = 0)
    private Integer registerLogGenre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterLogEntity that = (RegisterLogEntity) o;
        return registerLogId == that.registerLogId && revision == that.revision && Objects.equals(registerLogPeople, that.registerLogPeople) && Objects.equals(registerLogPhone, that.registerLogPhone) && Objects.equals(registerLogIp, that.registerLogIp)&& Objects.equals(registerLogIpName, that.registerLogIpName) && Objects.equals(registerLogType, that.registerLogType) && Objects.equals(registerLogState, that.registerLogState) && Objects.equals(registerLogBrowser, that.registerLogBrowser) && Objects.equals(registerLogGenre, that.registerLogGenre) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerLogId, registerLogPeople, registerLogPhone, registerLogIp,registerLogIpName, registerLogType, registerLogState, registerLogBrowser, registerLogGenre, createdTime, updatedTime, revision, isDeleted);
    }
}
