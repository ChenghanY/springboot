package com.james.signature.model.task;

public class TaskCheckInfo {
    private Integer taskId;
    private Integer workerId;
    private Integer isComplete;
    private String conditionDescription;

    public TaskCheckInfo() {
    }

    public TaskCheckInfo(Integer taskId, Integer workerId, Integer isComplete, String conditionDescription) {
        this.taskId = taskId;
        this.workerId = workerId;
        this.isComplete = isComplete;
        this.conditionDescription = conditionDescription;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }
}
