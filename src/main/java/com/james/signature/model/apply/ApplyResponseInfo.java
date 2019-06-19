package com.james.signature.model.apply;

public class ApplyResponseInfo {
    private Integer isSuccess;
    private String reason;
    private Integer applyId;

    public ApplyResponseInfo(Integer isSuccess, String reason, Integer applyId) {
        this.isSuccess = isSuccess;
        this.reason = reason;
        this.applyId = applyId;
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

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }
}
