package com.james.signature.repository;

import com.james.signature.domain.SignRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;

public interface SignRecordRepository extends JpaRepository<SignRecordEntity, Integer> {

    List<SignRecordEntity> findAllByWorkerId(Integer id);

    List<SignRecordEntity> findAllByRecordCreateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    // 插入操作
    @Query(value = "INSERT INTO sign.sign_record (id, sign_start_time, is_ontime, reason, worker_id, record_create_time) VALUES" + " (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    @Modifying
    Integer insertSignMorningRecord(Integer id, String signStartTime, Integer isOntime, String reason, Integer workerId, LocalDateTime LocalDateTime);

    @Query(value = "INSERT INTO sign.sign_record (id, sign_end_time, is_ontime, reason, worker_id, record_create_time) VALUES" + " (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    @Modifying
    Integer insertSignAfternoonRecord(Integer id, String signEndTime, Integer isOntime, String reason, Integer workerId, LocalDateTime LocalDateTime);

    // 更新操作
    @Query(value = "UPDATE sign.sign_record SET sign_start_time = ?2, is_ontime = ?3, reason = ?4 WHERE id = ?1 ", nativeQuery = true)
    @Modifying
    Integer updateSignMorningRecord(Integer id, String signStartTime, Integer isOntime, String reason);

    @Query(value = "UPDATE sign.sign_record SET sign_end_time = ?2, is_ontime = ?3, reason = ?4 WHERE id = ?1", nativeQuery = true)
    @Modifying
    Integer updateSignAfernoonRecord(Integer id, String signEndTime, Integer isOntime, String reason);

}
