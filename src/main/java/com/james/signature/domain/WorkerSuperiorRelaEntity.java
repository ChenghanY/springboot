package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_superior_rela", schema = "sign", catalog = "")
public class WorkerSuperiorRelaEntity {
    private int id;
    private String description;
    private String relaBuildTime;
    private Integer relaLevel;
    private Integer superiorId;
    private Integer workerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rela_build_time")
    public String getRelaBuildTime() {
        return relaBuildTime;
    }

    public void setRelaBuildTime(String relaBuildTime) {
        this.relaBuildTime = relaBuildTime;
    }

    @Basic
    @Column(name = "rela_level")
    public Integer getRelaLevel() {
        return relaLevel;
    }

    public void setRelaLevel(Integer relaLevel) {
        this.relaLevel = relaLevel;
    }

    @Basic
    @Column(name = "superior_id")
    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    @Basic
    @Column(name = "worker_id")
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerSuperiorRelaEntity that = (WorkerSuperiorRelaEntity) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(relaBuildTime, that.relaBuildTime) &&
                Objects.equals(relaLevel, that.relaLevel) &&
                Objects.equals(superiorId, that.superiorId) &&
                Objects.equals(workerId, that.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, relaBuildTime, relaLevel, superiorId, workerId);
    }
}
