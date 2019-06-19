package com.james.signature.model.worker;

import com.james.signature.domain.SuperiorEntity;
import com.james.signature.domain.UserEntity;
import com.james.signature.domain.WorkerEntity;
import com.james.signature.domain.WorkerSuperiorRelaEntity;

public class InitWorkerInfo {

    private Integer isSuperior;
    private WorkerEntity workerEntity;
    private UserEntity userEntity;
    // 是否拥有下级，
    private SuperiorEntity superiorEntity;
    private WorkerSuperiorRelaEntity workerSuperiorRelaEntity;

    public InitWorkerInfo() {
    }

    // 包含上级信息
    public InitWorkerInfo(Integer isSuperior, WorkerEntity workerEntity, UserEntity userEntity, SuperiorEntity superiorEntity, WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        this.isSuperior = isSuperior;
        this.workerEntity = workerEntity;
        this.userEntity = userEntity;
        this.superiorEntity = superiorEntity;
        this.workerSuperiorRelaEntity = workerSuperiorRelaEntity;
    }

    // 不包含上级信息
    public InitWorkerInfo(Integer isSuperior, WorkerEntity workerEntity, UserEntity userEntity, WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        this.isSuperior = isSuperior;
        this.workerEntity = workerEntity;
        this.userEntity = userEntity;
        this.workerSuperiorRelaEntity = workerSuperiorRelaEntity;
    }

    public Integer getIsSuperior() {
        return isSuperior;
    }

    public void setIsSuperior(Integer isSuperior) {
        this.isSuperior = isSuperior;
    }

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SuperiorEntity getSuperiorEntity() {
        return superiorEntity;
    }

    public void setSuperiorEntity(SuperiorEntity superiorEntity) {
        this.superiorEntity = superiorEntity;
    }

    public WorkerSuperiorRelaEntity getWorkerSuperiorRelaEntity() {
        return workerSuperiorRelaEntity;
    }

    public void setWorkerSuperiorRelaEntity(WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        this.workerSuperiorRelaEntity = workerSuperiorRelaEntity;
    }
}
