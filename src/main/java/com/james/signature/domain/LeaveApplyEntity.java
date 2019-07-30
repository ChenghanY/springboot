package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leave_apply", schema = "sign", catalog = "")
public class LeaveApplyEntity {
    private int id;
    private String applyTime;
    private String applyType;
    private String applyStatus;
    private String leaveStartTime;
    private String leaveEndTime;
    private String leaveDayCount;
    private Integer isAgree;
    private String applyDescription;

    @Id
    @Column(name = "id")
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
    @Column(name = "leave_end_time")
    public String getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(String leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    @Basic
    @Column(name = "leave_day_count")
    public String getLeaveDayCount() {
        return leaveDayCount;
    }

    public void setLeaveDayCount(String leaveDayCount) {
        this.leaveDayCount = leaveDayCount;
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
                Objects.equals(leaveEndTime, that.leaveEndTime) &&
                Objects.equals(leaveDayCount, that.leaveDayCount) &&
                Objects.equals(isAgree, that.isAgree) &&
                Objects.equals(applyDescription, that.applyDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applyTime, applyType, applyStatus, leaveStartTime, leaveEndTime, leaveDayCount, isAgree, applyDescription);
    }
}
