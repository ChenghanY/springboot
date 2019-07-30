package com.james.signature.service.impl;

import com.james.signature.domain.LeaveApplyEntity;
import com.james.signature.model.apply.ApplyCheckRequestInfo;
import com.james.signature.model.apply.ApplyInfo;
import com.james.signature.model.apply.ApplyResponseInfo;
import com.james.signature.repository.LeaveApplyRepository;
import com.james.signature.repository.WorkerSuperiorRelaRepository;
import com.james.signature.service.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Autowired
    LeaveApplyRepository leaveApplyRepository;

    @Autowired
    WorkerSuperiorRelaRepository workerSuperiorRelaRepository;

    /**
     * 员工提出请假申请
     * @param ApplyInfo
     * @return
     */
    @Override
    public ApplyResponseInfo ApplyByWorker(ApplyInfo ApplyInfo) {
        LeaveApplyEntity temp = leaveApplyRepository.saveAndFlush(new LeaveApplyEntity(ApplyInfo));
        temp.setApplyStatus("2");
        Integer applyId = temp.getId();
        return new ApplyResponseInfo(1, "请假申请已提交", applyId);
    }

    /**
     * 直接上级审批请假申请
     * @param a
     * @return
     */
    @Override
    public ApplyResponseInfo SupCheckApply(ApplyCheckRequestInfo a) {
        String description = "直接上级已审批";
        if(a.getApplyStatus().equals("-1")) description = a.getApplyDescription();
            leaveApplyRepository.updateApplyRecord(a.getApplyId(), "5", a.getIsAgree(), description);
        return new ApplyResponseInfo(1,description,a.getApplyId());
    }

    /**
     * 人资行政审批请假申请
     * @param a
     * @return
     */
    @Override
    public ApplyResponseInfo HRCheckApply(ApplyCheckRequestInfo a) {
        String description = "人资行政已审批";
        if(a.getApplyStatus().equals("-1")) description = a.getApplyDescription();
        leaveApplyRepository.updateApplyRecord(a.getApplyId(), "10", a.getIsAgree(), description);
        return new ApplyResponseInfo(1,description,a.getApplyId());
    }

    /**
     * 员工查看审批进度
     * @param workerId
     * @return
     */
    @Override
    public List<LeaveApplyEntity> getApplyRecordByWorker(Integer workerId) {
        return leaveApplyRepository.findAllByWorkerId(workerId);
    }

    /**
     * 直接上级获取待审批请假申请
     * @param applyStatus
     * @return
     */
    @Override
    public List<LeaveApplyEntity> getApplyRecordByApplyStatus(Integer supId, String applyStatus) {
        List<Integer> workerIds = workerSuperiorRelaRepository.findAllBySuperiorId(supId).
                stream().map(p -> p.getWorkerId()).collect(Collectors.toList());
        return leaveApplyRepository.findAllByApplyStatusAndWorkerIdIn(applyStatus, workerIds);
    }

    /**
     * 人资部门获取待审批请假申请
     * @param applyStatus
     * @return
     */
    @Override
    public List<LeaveApplyEntity> getApplyRecordByApplyStatus(String applyStatus) {
        return leaveApplyRepository.findAllByApplyStatus(applyStatus);
    }


}
