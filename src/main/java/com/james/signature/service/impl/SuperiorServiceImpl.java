package com.james.signature.service.impl;

import com.james.signature.domain.WorkerEntity;
import com.james.signature.domain.WorkerSuperiorRelaEntity;
import com.james.signature.model.worker.WorkerNameAndId;
import com.james.signature.repository.WorkerRepository;
import com.james.signature.repository.WorkerSuperiorRelaRepository;
import com.james.signature.service.SuperiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SuperiorServiceImpl implements SuperiorService {

    @Autowired
    WorkerSuperiorRelaRepository workerSuperiorRelaRepository;

    @Autowired
    WorkerRepository workerRepository;

    // 创建下级
    @Override
    public boolean createSubordinate(WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        workerSuperiorRelaRepository.saveAndFlush(workerSuperiorRelaEntity);
        return true;
    }

    @Override
    public List<WorkerNameAndId> getSubordinateBySup(Integer supId) {
        List<WorkerNameAndId> workerNameAndIdList = workerSuperiorRelaRepository.findAllBySuperiorId(supId).stream().map(p-> {
            WorkerEntity entity = workerRepository.findById(p.getWorkerId()).get();
            return new WorkerNameAndId(entity.getId(), entity.getName());
        }).collect(Collectors.toList());
        return workerNameAndIdList;
    }
}
