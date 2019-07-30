package com.james.signature.repository;

import com.james.signature.domain.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer> {
}
