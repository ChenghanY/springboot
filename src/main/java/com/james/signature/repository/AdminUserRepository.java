package com.james.signature.repository;

import com.james.signature.domain.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUserEntity, Integer> {
    AdminUserEntity findByUserName(String userName);
}
