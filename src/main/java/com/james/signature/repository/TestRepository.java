package com.james.signature.repository;

import com.james.signature.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
