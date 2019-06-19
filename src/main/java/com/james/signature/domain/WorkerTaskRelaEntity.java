package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_task_rela", schema = "sign", catalog = "")
public class WorkerTaskRelaEntity {
    private int id;
    private Integer isComplete;
    private String conditionDescription;
    private Integer workerId;
    private Integer taskId;

    public WorkerTaskRelaEntity() {
    }

    // 下发任务时用


    public WorkerTaskRelaEntity(Integer isComplete, String conditionDescription, Integer workerId, Integer taskId) {
        this.isComplete = isComplete;
        this.conditionDescription = conditionDescription;
        this.workerId = workerId;
        this.taskId = taskId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_id")
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "is_complete")
    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    @Basic
    @Column(name = "condition_description")
    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    @Basic
    @Column(name = "worker_id")
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerTaskRelaEntity that = (WorkerTaskRelaEntity) o;
        return id == that.id &&
                Objects.equals(isComplete, that.isComplete) &&
                Objects.equals(conditionDescription, that.conditionDescription) &&
                Objects.equals(workerId, that.workerId) &&
                Objects.equals(taskId, that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isComplete, conditionDescription, workerId, taskId);
    }
}
