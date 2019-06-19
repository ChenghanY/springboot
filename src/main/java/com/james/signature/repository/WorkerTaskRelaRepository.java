package com.james.signature.repository;

import com.james.signature.domain.WorkerTaskRelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerTaskRelaRepository extends JpaRepository<WorkerTaskRelaEntity, Integer> {

    List<WorkerTaskRelaEntity> findAllByWorkerId(Integer workerId);

    List<WorkerTaskRelaEntity> findAllByWorkerIdIn(List<Integer> workerIdList);

    @Query(value = "UPDATE sign.worker_task_rela SET is_complete = ?3, condition_description = ?4 " +
            " WHERE task_id = ?1 AND worker_id = ?2", nativeQuery = true)
    @Modifying
    void updateWorkerTaskRela(Integer taskId, Integer workerId, Integer isComplete, String conditionDescription);


}
