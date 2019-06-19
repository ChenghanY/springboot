package com.james.signature.repository;

import com.james.signature.domain.LeaveApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveApplyRepository extends JpaRepository<LeaveApplyEntity, Integer> {

    List<LeaveApplyEntity> findAllByWorkerId(Integer workerId);

    List<LeaveApplyEntity> findAllByApplyStatusAndWorkerIdIn(String applyStatus, List<Integer> workerIds);

    List<LeaveApplyEntity> findAllByApplyStatus(String applyStatus);

    /**
     * 更新请假申请
     * @param applyId
     * @param applyStatus
     * @param isAgree
     * @param applyDescription
     */
    @Query(value = "UPDATE sign.leave_apply SET apply_status = ?2, is_agree = ?3, apply_description = ?4 " +
            " WHERE id = ?1",
    nativeQuery = true)
    @Modifying
    void updateApplyRecord(Integer applyId, String applyStatus, Integer isAgree, String applyDescription);

}
