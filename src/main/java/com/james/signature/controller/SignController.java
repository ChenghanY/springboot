package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.domain.SignRecordEntity;
import com.james.signature.model.SignRecordInfo;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户签到服务")
@RequestMapping(value = Constants.URI_SIGN)
public class SignController {

    @Autowired
    SignService signService;

    @GetMapping(value = "/record/list")
    @ApiOperation(value = "获取所有员工签到记录")
    private SignRecordInfo[] getAllRecordByWorkerId() {

        List<SignRecordInfo> signRecordInfoList = signService.getAllSignInfo();
        WorkerController workerController = new WorkerController();
        return signRecordInfoList.toArray(new SignRecordInfo[signRecordInfoList.size()]);
    }

    @PostMapping(value = "/record")
    @ApiOperation(value = "根据员工Id获取考勤记录")
    private SignRecordInfo[] getByWorkerId(@RequestBody WorkerId workerIdObject){
        List<SignRecordInfo> signRecordInfoList = signService.getAllByWorkerId(workerIdObject.getWorkerId());
        return signRecordInfoList.toArray(new SignRecordInfo[signRecordInfoList.size()]);
    }

    @GetMapping(value = "/record")
    @ApiOperation(value = "根据员工Id获取考勤记录")
    private SignRecordInfo[] getByWorkerId(@PathVariable int workerId){
        List<SignRecordInfo> signRecordInfoList = signService.getAllByWorkerId(workerId);
        return signRecordInfoList.toArray(new SignRecordInfo[signRecordInfoList.size()]);
    }


    @PostMapping(value = "/in/morning", consumes = "application/json")
    @ApiOperation(value = "用户早上完成签到")
    private StatusJson userSignInMorning(@RequestBody @ApiParam(name = "签到记录", value = "传入Json格式") SignRecordEntity signRecordEntity) {
        signService.signInMorning(signRecordEntity);
        return new StatusJson(signRecordEntity);
    }

    @PostMapping(value = "/in/afternoon", consumes = "application/json")
    @ApiOperation(value = "用户下午完成签到")
    private StatusJson userSignInAfternoon(@RequestBody @ApiParam(name = "签到记录", value = "传入Json格式") SignRecordEntity signRecordEntity) {
        signService.signInAfternoon(signRecordEntity);
        return new StatusJson(signRecordEntity);
    }

}

