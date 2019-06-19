package com.james.signature.domain;

import com.james.signature.model.apply.ApplyInfo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leave_apply", schema = "sign")
public class LeaveApplyEntity {
    private int id;
    private String applyTime;
    private String applyType;
    private String applyStatus;
    private String leaveStartTime;
    private Integer isAgree;
    private String applyDescription;
    private Integer workerId;
    private String leaveDayCount;

    public LeaveApplyEntity() {
    }

    public LeaveApplyEntity(ApplyInfo applyInfo) {
        this.applyTime = applyInfo.getApplyTime();
        this.applyType = applyInfo.getApplyType();
        this.leaveStartTime = applyInfo.getLeaveStartTime();
        this.applyDescription = applyInfo.getApplyDescription();
        this.leaveDayCount = applyInfo.getLeaveDayCount();
        this.workerId = applyInfo.getWorkerId();
    }

    public LeaveApplyEntity(String applyTime, String applyType, String applyStatus, String leaveStartTime, Integer isAgree, String applyDescription, Integer workerId, String leaveDayCount) {
        this.applyTime = applyTime;
        this.applyType = applyType;
        this.applyStatus = applyStatus;
        this.leaveStartTime = leaveStartTime;
        this.isAgree = isAgree;
        this.applyDescription = applyDescription;
        this.workerId = workerId;
        this.leaveDayCount = leaveDayCount;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "apply_time")
    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "apply_type")
    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    @Basic
    @Column(name = "apply_status")
    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Basic
    @Column(name = "leave_start_time")
    public String getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(String leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    @Basic
    @Column(name = "is_agree")
    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    @Basic
    @Column(name = "apply_description")
    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription;
    }

    @Basic
    @Column(name = "worker_id")
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Basic
    @Column(name = "leave_day_count")
    public String getLeaveDayCount() {
        return leaveDayCount;
    }

    public void setLeaveDayCount(String leaveDayCount) {
        this.leaveDayCount = leaveDayCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveApplyEntity that = (LeaveApplyEntity) o;
        return id == that.id &&
                Objects.equals(applyTime, that.applyTime) &&
                Objects.equals(applyType, that.applyType) &&
                Objects.equals(applyStatus, that.applyStatus) &&
                Objects.equals(leaveStartTime, that.leaveStartTime) &&
                Objects.equals(isAgree, that.isAgree) &&
                Objects.equals(applyDescription, that.applyDescription) &&
                Objects.equals(workerId, that.workerId) &&
                Objects.equals(leaveDayCount, that.leaveDayCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applyTime, applyType, applyStatus, leaveStartTime, isAgree, applyDescription, workerId, leaveDayCount);
    }
}
