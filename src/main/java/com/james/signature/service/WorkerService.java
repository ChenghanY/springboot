package com.james.signature.service;

import com.james.signature.model.worker.InitWorkerInfo;
import com.james.signature.model.worker.WorkerInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkerService {
    List<WorkerInfo> getWorkerInfo(Integer id);

    InitWorkerInfo createWorker(InitWorkerInfo initWorkerInfo);

    String deleteWorker(Integer workerId);
}
