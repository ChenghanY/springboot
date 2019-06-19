package com.james.signature.service;

import com.james.signature.domain.LeaveApplyEntity;
import com.james.signature.model.apply.ApplyCheckRequestInfo;
import com.james.signature.model.apply.ApplyInfo;
import com.james.signature.model.apply.ApplyResponseInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaveApplyService {
    ApplyResponseInfo ApplyByWorker(ApplyInfo ApplyInfo);

    ApplyResponseInfo SupCheckApply(ApplyCheckRequestInfo applyCheckRequestInfo);

    ApplyResponseInfo HRCheckApply(ApplyCheckRequestInfo applyCheckRequestInfo);

    List<LeaveApplyEntity> getApplyRecordByWorker(Integer workerId);

    List<LeaveApplyEntity> getApplyRecordByApplyStatus(Integer supId, String applyStatus);

    List<LeaveApplyEntity> getApplyRecordByApplyStatus(String applyStatus);

}
