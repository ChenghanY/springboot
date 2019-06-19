package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.domain.WorkerSuperiorRelaEntity;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.model.worker.WorkerNameAndId;
import com.james.signature.service.SuperiorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "直接上级信息服务")
@RequestMapping(value = Constants.URI_SUP)
public class SuperiorController {

    @Autowired
    SuperiorService superiorService;

    @PutMapping(value = "/subordinate")
    @ApiOperation(value = "创建下级")
    private StatusJson createSubordinate(@RequestBody WorkerSuperiorRelaEntity workerSuperiorRelaEntity) {
        Boolean b = superiorService.createSubordinate(workerSuperiorRelaEntity);
        return new StatusJson("创建下级成功");
    }

    @PostMapping(value = "/subordinate")
    @ApiOperation(value = "根据Id获取下属员工信息")
    private WorkerNameAndId[] getSubordinateByWorkerId(@RequestBody WorkerId supId) {
        List<WorkerNameAndId> w = superiorService.getSubordinateBySup(supId.getWorkerId());
        return w.toArray(new WorkerNameAndId[w.size()]);
    }

}
