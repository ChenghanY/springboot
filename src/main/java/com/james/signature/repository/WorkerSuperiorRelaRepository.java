package com.james.signature.repository;

import com.james.signature.domain.WorkerSuperiorRelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerSuperiorRelaRepository extends JpaRepository<WorkerSuperiorRelaEntity, Integer> {

    @Modifying
    void deleteByWorkerId(Integer workerId);

    List<WorkerSuperiorRelaEntity> findAllByWorkerId(Integer workerId);

    /**
     * 查找企业成员所有下属的记录
     * @param supId 被删除的上级Id
     * @return
     */
    List<WorkerSuperiorRelaEntity> findAllBySuperiorId(Integer supId);

    /**
     * 更新被删除的企业成员的下属的上下级关系
     * @param relaIdList    直接下级的关系ID
     * @param superiorId    需要更新的上级ID
     */
    @Query(value = "UPDATE sign.worker_superior_rela SET superior_Id = ?2 WHERE id IN ?1", nativeQuery = true)
    @Modifying
    void updateRelaBySuperiorId(List<Integer> relaIdList, Integer superiorId);


}