package com.james.signature.model.task;

public class TaskScheduleInfo {
    // task
    private String taskName;
    private String taskBuildTime;
    private String expectedCompleteTime;
    // worker_task_rela
    private String conditionDescription;
    private Integer taskId;

    public TaskScheduleInfo() {
    }


    public TaskScheduleInfo(String taskName, String taskBuildTime, String expectedCompleteTime, String conditionDescription, Integer taskId) {
        this.taskName = taskName;
        this.taskBuildTime = taskBuildTime;
        this.expectedCompleteTime = expectedCompleteTime;
        this.conditionDescription = conditionDescription;
        this.taskId = taskId;
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

    public String getExpectedCompleteTime() {
        return expectedCompleteTime;
    }

    public void setExpectedCompleteTime(String expectedCompleteTime) {
        this.expectedCompleteTime = expectedCompleteTime;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
