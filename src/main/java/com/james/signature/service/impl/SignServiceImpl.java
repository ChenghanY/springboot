package com.james.signature.service.impl;

import com.james.signature.domain.SignRecordEntity;
import com.james.signature.domain.WorkerEntity;
import com.james.signature.model.SignRecordInfo;
import com.james.signature.repository.SignRecordRepository;
import com.james.signature.repository.WorkerRepository;
import com.james.signature.service.SignService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 签到服务
 */
@Service
@Transactional
public class SignServiceImpl implements SignService {

    @Autowired
    SignRecordRepository signRecordRepository;

    @Autowired
    WorkerRepository workerRepository;

    /**
     * 将数据库的签到记录处理为前端展示的签到记录
     * @param signRecordEntities
     * @return
     */
    public List<SignRecordInfo> dueSignRecordList(List<SignRecordEntity> signRecordEntities) {
        List<SignRecordInfo> signRecordInfos = new ArrayList<>();
        for (SignRecordEntity s : signRecordEntities) {
            Optional<WorkerEntity> worker = workerRepository.findById(s.getWorkerId());
            if (worker.isPresent()) {
                //String workerName = worker.get().getName();
                SignRecordInfo signRecordInfo = new
                        SignRecordInfo(worker.get().getName(), s.getSignStartTime(), s.getSignEndTime(), s.getIsOntime(), s.getReason(),s.getId());
                signRecordInfos.add(signRecordInfo);
            }
        }
        return signRecordInfos;
    }


    @Override
    public List<SignRecordInfo> getAllSignInfo() {

        //List<Integer> _workerId = signRecordEntities.stream().map(p -> p.getWorkerId()).collect(Collectors.toList());
        // List<String> workerName = workerRepository.findAllById(workerId).stream().map(p -> p.getName()).collect(Collectors.toList());
        List<SignRecordEntity> signRecordEntities = signRecordRepository.findAll();
        return dueSignRecordList(signRecordEntities);
    }

    @Override
    public List<SignRecordInfo> getAllByWorkerId(Integer workerId) {
        if(workerId == null) {
            // 传空值的话就获取所有的
            return getAllSignInfo();
        } else {
            List<SignRecordEntity> signRecordEntities = signRecordRepository.findAllByWorkerId(workerId);
            return dueSignRecordList(signRecordEntities);
        }
    }

    // 总的来说就是 App端确定是否迟到或者早退。是否旷工,后端处理，

    /**
     * 上午签到
     * @param signRecordEntity
     * @return
     */
    @Override
    public Integer signInMorning(SignRecordEntity signRecordEntity) {

        Optional<SignRecordEntity> optional = signRecordRepository.findById(signRecordEntity.getId());
        if (optional.isPresent() == false) {
            // 插入早上签到记录
            signRecordRepository.insertSignMorningRecord(signRecordEntity.getId(), signRecordEntity.getSignStartTime(), signRecordEntity.getIsOntime()
                    ,signRecordEntity.getReason(), signRecordEntity.getWorkerId(), LocalDateTime.now());
            return 1;
        } else {
            // 更新早上签到记录
            signRecordRepository.updateSignMorningRecord(signRecordEntity.getId(), signRecordEntity.getSignStartTime(), signRecordEntity.getIsOntime()
                    ,signRecordEntity.getReason());
            return 0;
        }

    }

    /**
     * 下午签到
     * @param signRecordEntity
     * @return
     */
    @Override
    public Integer signInAfternoon(SignRecordEntity signRecordEntity) {
        Integer isOntime ;
        Optional<SignRecordEntity> optional = signRecordRepository.findById(signRecordEntity.getId());
        if (optional.isPresent() == false ) {
            // 插入新签到记录，不包含早上记录，并新增reason字段，重置isOntime字段
            isOntime = 0;
            String reason = "早上无签到记录,记旷工半天;" + signRecordEntity.getReason();
            // 这里新增记录有bug
            signRecordRepository.insertSignAfternoonRecord(signRecordEntity.getId(), signRecordEntity.getSignEndTime(), isOntime
                    ,reason , signRecordEntity.getWorkerId(),LocalDateTime.now());
            return 1;
        } else if (StringUtils.isBlank(optional.get().getSignStartTime())){
            isOntime = 0;
            String reason = "早上无签到记录,记旷工半天;" + signRecordEntity.getReason();
            signRecordRepository.updateSignAfernoonRecord(signRecordEntity.getId(), signRecordEntity.getSignEndTime(), isOntime
                    ,reason);
        } else {
            signRecordRepository.updateSignAfernoonRecord(signRecordEntity.getId(), signRecordEntity.getSignEndTime(),
                    signRecordEntity.getIsOntime(),signRecordEntity.getReason());
        }
        return 1;
    }


}
