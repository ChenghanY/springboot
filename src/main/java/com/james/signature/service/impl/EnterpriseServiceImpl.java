package com.james.signature.service.impl;

import com.james.signature.domain.EnterpriseEntity;
import com.james.signature.repository.EnterpriseRepository;
import com.james.signature.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Override
    public String getLntLat() {
        String lntlat = enterpriseRepository.findById(2019).get().getLngLat();
        return lntlat;
    }

    @Override
    public EnterpriseEntity getEnterpriseInfo() {
        return enterpriseRepository.findById(2019).get();
    }

    @Override
    public String updateLntLat(String lntLat) {
        enterpriseRepository.updateLngLat(lntLat);
        return "已更新企业坐标";
    }

    @Override
    public String updateStartEndTime(String startTime, String endTime) {
        enterpriseRepository.updateStartTime(startTime);
        enterpriseRepository.updateEndTime(endTime);
        return "已更新企业上下班时间时间";
    }

    @Override
    public String updateScope(String scope) {
        enterpriseRepository.updateScope(scope);
        return "已更新企业签到范围";
    }
}
