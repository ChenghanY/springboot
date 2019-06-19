package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.domain.LeaveApplyEntity;
import com.james.signature.model.apply.ApplyCheckRequestInfo;
import com.james.signature.model.apply.ApplyInfo;
import com.james.signature.model.apply.ApplyResponseInfo;
import com.james.signature.service.LeaveApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(tags = "请假申请服务")
@RequestMapping(Constants.URI_APPLY)
public class LeaveApplyController {

    @Autowired
    LeaveApplyService leaveApplyService;


    @PostMapping
    @ApiOperation(value = "用户提交请假申请", response = StatusJson.class)
    private StatusJson ApplyByEntity(@RequestBody ApplyInfo applyInfo){
        ApplyResponseInfo applyResponseInfo = leaveApplyService.ApplyByWorker(applyInfo);
        return new StatusJson(applyResponseInfo);
    }

    @GetMapping(value = "/{workerId}")
    @ApiOperation(value = "员工查询请假申请")
    private LeaveApplyEntity[] getApplyRecordByWorker(@PathVariable Integer workerId) {
        List<LeaveApplyEntity> leaveApplyEntityList = leaveApplyService.getApplyRecordByWorker(workerId);
        return leaveApplyEntityList.toArray(new LeaveApplyEntity[leaveApplyEntityList.size()]);
    }

    @GetMapping(value = "/sup/{supId}")
    @ApiOperation(value = "上级获取待审批请假申请")
    private LeaveApplyEntity[] getApplyRecordBySup(@PathVariable Integer supId) {
        List<LeaveApplyEntity> leaveApplyEntityList = leaveApplyService.getApplyRecordByApplyStatus(supId,"2");
        return leaveApplyEntityList.toArray(new LeaveApplyEntity[leaveApplyEntityList.size()]);
    }

    @ApiIgnore
    @GetMapping(value = "/hr")
    @ApiOperation(value = "人资行政获取待审批请假申请")
    private LeaveApplyEntity[] getApplyRecordByHR() {
        List<LeaveApplyEntity> leaveApplyEntityList = leaveApplyService.getApplyRecordByApplyStatus("5");
        return leaveApplyEntityList.toArray(new LeaveApplyEntity[leaveApplyEntityList.size()]);
    }

    @PutMapping(value = "/check/sup")
    @ApiOperation(value = "直接上级审批请假申请")
    private StatusJson SupCheckApply(@RequestBody ApplyCheckRequestInfo applyCheckRequestInfo) {
        ApplyResponseInfo applyResponseInfo = leaveApplyService.SupCheckApply(applyCheckRequestInfo);
        return new StatusJson(applyResponseInfo);
    }

    @ApiIgnore
    @PutMapping(value = "/check/hr")
    @ApiOperation(value = "人资行政审批请假申请")
    private StatusJson HRCheckApply(@RequestBody ApplyCheckRequestInfo applyCheckRequestInfo) {
        ApplyResponseInfo applyResponseInfo = leaveApplyService.HRCheckApply(applyCheckRequestInfo);
        return new StatusJson(applyResponseInfo);
    }


}
