package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.domain.WorkerEntity;
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
@Api(tags = "员工信息服务")
@RequestMapping(value = Constants.URI_WORKER)
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping
    @ApiImplicitParam(name = "id", value = "员工Id")
    @ApiOperation(value = "根据员工Id获取员工信息")
    public WorkerInfo[] getById(@RequestParam Integer id) {
        List<WorkerInfo> workerInfoList = workerService.getWorkerInfo(id);
        return workerInfoList.toArray(new WorkerInfo[workerInfoList.size()]);
    }

    @PostMapping()
    @ApiOperation(value = "新增企业工作人员")
    public InitWorkerInfo createByInfo(@RequestBody InitWorkerInfo initWorkerInfo){
        InitWorkerInfo result = workerService.createWorker(initWorkerInfo);
        return result;
    }

    @DeleteMapping()
    @ApiOperation(value = "删除企业工作人员")
    public StatusJson deleteByWorkerId(@RequestBody WorkerId workerId) {
        String result = workerService.deleteWorker(workerId.getWorkerId());
        return new StatusJson(result);
    }

    @PutMapping()
    @ApiOperation(value = "更新成员信息")
    public StatusJson updateByWorkerId(@RequestBody WorkerEntity workerEntity) {
        String result = workerService.updateWorker(workerEntity);
        return new StatusJson(result);
    }
}
