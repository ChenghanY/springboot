package com.james.signature.model.worker;

public class Subordinate {
    private Integer workerId;
    private String  workerShouldDo;

    public Subordinate() {
    }

    public Subordinate(Integer workerId, String workerShouldDo) {
        this.workerId = workerId;
        this.workerShouldDo = workerShouldDo;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerShouldDo() {
        return workerShouldDo;
    }

    public void setWorkerShouldDo(String workerShouldDo) {
        this.workerShouldDo = workerShouldDo;
    }
}
