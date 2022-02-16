package com.trkj.framework.entity.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "DEPT_POST", schema = "POWER", catalog = "")
public class DeptPostEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DEPT_POST_ID", nullable = false, precision = 0)
    private Integer deptPostId;
    @Basic
    @Column(name = "DEPT_ID", nullable = false, precision = 0)
    private int deptId;
    @Basic
    @Column(name = "POST_NAME", nullable = false, length = 20)
    private String postName;
    @Basic
    @Column(name = "REVISION", nullable = false, precision = 0)
    private int revision;
    @Basic
    @Column(name = "CREATED_TIME", nullable = false)
    private Date createdTime;
    @Basic
    @Column(name = "UPDATED_TIME", nullable = false)
    private Date updatedTime;
    @Basic
    @Column(name = "IS_DELETED", nullable = false, precision = 0)
    private int isDeleted;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptPostEntity that = (DeptPostEntity) o;
        return deptPostId == that.deptPostId && deptId == that.deptId && revision == that.revision && isDeleted == that.isDeleted && Objects.equals(postName, that.postName) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptPostId, deptId, postName, revision, createdTime, updatedTime, isDeleted);
    }
}
