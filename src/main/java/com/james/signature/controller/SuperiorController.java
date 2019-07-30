package com.james.signature.controller;

import com.james.signature.util.StatusJsonForAndroid;
import com.james.signature.domain.WorkerSuperiorRelaEntity;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.model.worker.WorkerNameAndId;
import com.james.signature.service.SuperiorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperiorController {

    @Autowired
    SuperiorService superiorService;

    @PostMapping(value = "/sup/create/subordinate")
    @ApiOperation(value = "创建下级")
    private StatusJsonForAndroid createSubordinate(@RequestBody WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        Boolean b = superiorService.createSubordinate(workerSuperiorRelaEntity);
        return new StatusJsonForAndroid("创建下级成功");
    }

    @PostMapping(value = "/sup/get/subordinate")
    @ApiOperation(value = "根据Id获取下属员工信息")
    private WorkerNameAndId[] getSubordinateByWorkerId(@RequestBody WorkerId supId) {
        List<WorkerNameAndId> w = superiorService.getSubordinateBySup(supId.getWorkerId());
        return w.toArray(new WorkerNameAndId[w.size()]);
    }

}
