package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "sign", catalog = "")
public class TaskEntity {
    private int id;
    private String taskName;
    private String taskBuildTime;
    private String taskDescription;
    private String expectedCompleteTime;

    public TaskEntity() {
    }

    public TaskEntity(int id, String taskName, String taskBuildTime, String taskDescription, String expectedCompleteTime) {
        this.id = id;
        this.taskName = taskName;
        this.taskBuildTime = taskBuildTime;
        this.taskDescription = taskDescription;
        this.expectedCompleteTime = expectedCompleteTime;
    }

    public TaskEntity(String taskName, String taskBuildTime, String taskDescription, String expectedCompleteTime) {
        this.taskName = taskName;
        this.taskBuildTime = taskBuildTime;
        this.taskDescription = taskDescription;
        this.expectedCompleteTime = expectedCompleteTime;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_name")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "task_build_time")
    public String getTaskBuildTime() {
        return taskBuildTime;
    }

    public void setTaskBuildTime(String taskBuildTime) {
        this.taskBuildTime = taskBuildTime;
    }

    @Basic
    @Column(name = "task_description")
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Basic
    @Column(name = "expected_complete_time")
    public String getExpectedCompleteTime() {
        return expectedCompleteTime;
    }

    public void setExpectedCompleteTime(String expectedCompleteTime) {
        this.expectedCompleteTime = expectedCompleteTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return id == that.id &&
                Objects.equals(taskName, that.taskName) &&
                Objects.equals(taskBuildTime, that.taskBuildTime) &&
                Objects.equals(taskDescription, that.taskDescription) &&
                Objects.equals(expectedCompleteTime, that.expectedCompleteTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskBuildTime, taskDescription, expectedCompleteTime);
    }
}
