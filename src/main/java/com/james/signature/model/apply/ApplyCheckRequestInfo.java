package com.james.signature.model.apply;

public class ApplyCheckRequestInfo {
    private int applyId;
    private String applyStatus;
    private String applyDescription;
    private Integer isAgree;

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }


    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription;
    }
}
