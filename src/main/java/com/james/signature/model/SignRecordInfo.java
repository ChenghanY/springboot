package com.james.signature.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Objects;

public class SignRecordInfo extends BaseRowModel {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "签到开始时间", index = 1)
    private String signStartTime;

    @ExcelProperty(value = "签到结束时间", index = 2)
    private String signEndTime;

    @ExcelProperty(value = "是否准时", index = 3) // 这里后期要转义一下
    private Integer isOntime;

    @ExcelProperty(value = "原因", index = 4)
    private String reason;

    @ExcelProperty(value = "成员Id", index = 5)
    private Integer id;

    public SignRecordInfo() {
    }

    // 缺少Id的构造方法
    public SignRecordInfo(String name, String signStartTime, String signEndTime, Integer isOntime, String reason) {
        this.name = name;
        this.signStartTime = signStartTime;
        this.signEndTime = signEndTime;
        this.isOntime = isOntime;
        this.reason = reason;
    }

    public SignRecordInfo(String name, String signStartTime, String signEndTime, Integer isOntime, String reason, Integer id) {
        this.name = name;
        this.signStartTime = signStartTime;
        this.signEndTime = signEndTime;
        this.isOntime = isOntime;
        this.reason = reason;
        this.id = id;
    }

    //    public SignRecordInfo(WorkerInfo workerInfo, String signStartTime, String signEndTime, Integer isOntime, String reason) {
//        this.workerInfo = workerInfo;
//        this.signStartTime = signStartTime;
//        this.signEndTime = signEndTime;
//        this.isOntime = isOntime;
//        this.reason = reason;
//    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignStartTime() {
        return signStartTime;
    }

    public void setSignStartTime(String signStartTime) {
        this.signStartTime = signStartTime;
    }

    public String getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(String signEndTime) {
        this.signEndTime = signEndTime;
    }

    public Integer getIsOntime() {
        return isOntime;
    }

    public void setIsOntime(Integer isOntime) {
        this.isOntime = isOntime;
    }

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
        SignRecordInfo that = (SignRecordInfo) o;
        return Objects.equals(signStartTime, that.signStartTime) &&
                Objects.equals(signEndTime, that.signEndTime) &&
                Objects.equals(isOntime, that.isOntime) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signStartTime, signEndTime, isOntime, reason);
    }

    @Override
    public String toString() {
        return "SignRecordInfo{" +
                "name='" + name + '\'' +
                ", signStartTime='" + signStartTime + '\'' +
                ", signEndTime='" + signEndTime + '\'' +
                ", isOntime=" + isOntime +
                ", reason='" + reason + '\'' +
                '}';
    }
}

