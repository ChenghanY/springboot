package com.james.signature.service;

import com.james.signature.domain.WorkerSuperiorRelaEntity;
import com.james.signature.model.worker.WorkerNameAndId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuperiorService {
    boolean createSubordinate(WorkerSuperiorRelaEntity workerSuperiorRelaEntity);

    List<WorkerNameAndId> getSubordinateBySup(Integer supId);
}
