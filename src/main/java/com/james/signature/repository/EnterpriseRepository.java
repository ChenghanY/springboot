package com.james.signature.repository;

import com.james.signature.domain.EnterpriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Integer> {

    @Query(value = "UPDATE sign.enterprise SET lng_lat = ?1 WHERE id = 2019", nativeQuery = true)
    @Modifying
    void updateLngLat(String lngLat);

    @Query(value = "UPDATE sign.enterprise SET work_start_time = ?1 WHERE id = 2019", nativeQuery = true)
    @Modifying
    void updateStartTime(String starTime);

    @Query(value = "UPDATE sign.enterprise SET work_end_time = ?1 WHERE id = 2019", nativeQuery = true)
    @Modifying
    void updateEndTime(String endTime);

    @Query(value = "UPDATE sign.enterprise SET scope = ?1 WHERE id = 2019", nativeQuery = true)
    @Modifying
    void updateScope(String scope);
}
