package com.james.signature.model.task;

import com.james.signature.model.worker.Subordinate;

import java.util.List;

public class TaskCreateInfo {
    // task
    private String taskName;
    private String taskBuildTime;
    private String taskDescription;
    private String expectedCompleteTime;
    // worker_task_rela
    private List<Subordinate> subordinateList;

    public TaskCreateInfo() {
    }

    public List<Subordinate> getSubordinateList() {
        return subordinateList;
    }

    public void setSubordinateList(List<Subordinate> subordinateList) {
        this.subordinateList = subordinateList;
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

    public String getExpectedCompleteTime() {
        return expectedCompleteTime;
    }

    public void setExpectedCompleteTime(String expectedCompleteTime) {
        this.expectedCompleteTime = expectedCompleteTime;
    }
}
