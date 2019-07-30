package com.james.signature.controller;

import com.james.signature.util.StatusJsonForAndroid;
import com.james.signature.model.worker.InitWorkerInfo;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.model.worker.WorkerInfo;
import com.james.signature.service.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("员工信息服务")
public class WorkerController {

    @Autowired
    WorkerService workerService;


    @GetMapping(value = "/worker")
    @ApiImplicitParam(name = "id", value = "员工Id")
    @ApiOperation(value = "根据员工Id获取员工信息")
    private WorkerInfo[] getById(@RequestParam Integer id) {
        List<WorkerInfo> workerInfoList = workerService.getWorkerInfo(id);
        return workerInfoList.toArray(new WorkerInfo[workerInfoList.size()]);
    }

    @PostMapping(value = "/worker/create")
    @ApiOperation(value = "新增企业工作人员")
    private InitWorkerInfo createByInfo(@RequestBody InitWorkerInfo initWorkerInfo){
        InitWorkerInfo result = workerService.createWorker(initWorkerInfo);
        return result;
    }

    @DeleteMapping(value = "worker/delete")
    @ApiOperation(value = "删除企业工作人员")
    private StatusJsonForAndroid deleteByWorkerId(@RequestBody WorkerId workerId) {
        String result = workerService.deleteWorker(workerId.getWorkerId());
        return new StatusJsonForAndroid(result);
    }

}
