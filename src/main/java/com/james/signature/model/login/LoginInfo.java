package com.james.signature.model.login;

public class LoginInfo {
    private Integer isSuccess;
    private String reason;
    private Integer workerIds;

    public LoginInfo() {
    }

    public LoginInfo(Integer isSuccess, String reason, Integer workerId) {
        this.isSuccess = isSuccess;
        this.reason = reason;
        this.workerIds = workerId;
    }

    public LoginInfo(Integer isSuccess, String reason) {
        this.isSuccess = isSuccess;
        this.reason = reason;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getWorkerId() {
        return workerIds;
    }

    public void setWorkerId(Integer workerId) {
        this.workerIds = workerId;
    }
}
