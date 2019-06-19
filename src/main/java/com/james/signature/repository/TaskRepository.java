package com.james.signature.repository;

import com.james.signature.domain.TaskEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    @Query(value = "INSERT INTO sign.task (task_name, task_build_time, task_description, expected_complete_time)" +
            " VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    @Modifying
    void createTask(String taskName, String TaskBuildTime, String TaskDescription, String expectedCompleteTime);
}
