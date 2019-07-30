package com.james.signature.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sign_record", schema = "sign")
public class SignRecordEntity {
    private int id;
    private String signStartTime;
    private String signEndTime;
    private Integer isOntime;
    private String reason;
    private int workerId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordCreateTime;


    public SignRecordEntity() {
    }

    public SignRecordEntity(int id, Integer isOntime, int workerId, LocalDateTime recordCreateTime) {
        this.id = id;
        this.isOntime = isOntime;
        this.workerId = workerId;
        this.recordCreateTime = recordCreateTime;
    }


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "record_create_time")
    public LocalDateTime getRecordCreateTime() {
        return recordCreateTime;
    }

    public void setRecordCreateTime(LocalDateTime recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    @Basic
    @Column(name = "worker_id")
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Basic
    @Column(name = "sign_start_time")
    public String getSignStartTime() {
        return signStartTime;
    }

    public void setSignStartTime(String signStartTime) {
        this.signStartTime = signStartTime;
    }

    @Basic
    @Column(name = "sign_end_time")
    public String getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(String signEndTime) {
        this.signEndTime = signEndTime;
    }

    @Basic
    @Column(name = "is_ontime")
    public Integer getIsOntime() {
        return isOntime;
    }

    public void setIsOntime(Integer isOntime) {
        this.isOntime = isOntime;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignRecordEntity that = (SignRecordEntity) o;
        return id == that.id &&
                workerId == that.workerId &&
                Objects.equals(signStartTime, that.signStartTime) &&
                Objects.equals(signEndTime, that.signEndTime) &&
                Objects.equals(isOntime, that.isOntime) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, signStartTime, signEndTime, isOntime, reason, workerId);
    }
}
