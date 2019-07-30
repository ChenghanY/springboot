package com.james.signature.model.task;

import java.util.Objects;

public class TaskInfo {

    private Integer workerId;
    private String taskName;
    private String taskBuildTime;
    private String taskDescription;
    private Integer isComplete;
    private String expectedCompleteTime;

    public TaskInfo() {
    }

    public TaskInfo(Integer workerId, String taskName, String taskBuildTime, String taskDescription, Integer isComplete, String expectedCompleteTime) {
        this.workerId = workerId;
        this.taskName = taskName;
        this.taskBuildTime = taskBuildTime;
        this.taskDescription = taskDescription;
        this.isComplete = isComplete;
        this.expectedCompleteTime = expectedCompleteTime;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getExpectedCompleteTime() {
        return expectedCompleteTime;
    }

    public void setExpectedCompleteTime(String expectedCompleteTime) {
        this.expectedCompleteTime = expectedCompleteTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskBuildTime() {
        return taskBuildTime;
    }

    public void setTaskBuildTime(String taskBuildTime) {
        this.taskBuildTime = taskBuildTime;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskInfo taskInfo = (TaskInfo) o;
        return Objects.equals(workerId, taskInfo.workerId) &&
                Objects.equals(taskName, taskInfo.taskName) &&
                Objects.equals(taskBuildTime, taskInfo.taskBuildTime) &&
                Objects.equals(taskDescription, taskInfo.taskDescription) &&
                Objects.equals(isComplete, taskInfo.isComplete) &&
                Objects.equals(expectedCompleteTime, taskInfo.expectedCompleteTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, taskName, taskBuildTime, taskDescription, isComplete, expectedCompleteTime);
    }
}
