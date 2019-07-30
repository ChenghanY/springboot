package com.james.signature.repository;

import com.james.signature.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);

    List<UserEntity> findAllByWorkerId(Integer Id);

    void deleteByWorkerId(Integer workerId);
}
