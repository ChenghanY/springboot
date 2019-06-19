package com.james.signature.model.apply;

public class ApplyInfo {
    private String applyTime;
    private String applyType;
    private String leaveStartTime;
    private String applyDescription;
    private Integer workerId;
    private String leaveDayCount;

    public ApplyInfo() {
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(String leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getLeaveDayCount() {
        return leaveDayCount;
    }

    public void setLeaveDayCount(String leaveDayCount) {
        this.leaveDayCount = leaveDayCount;
    }
}
