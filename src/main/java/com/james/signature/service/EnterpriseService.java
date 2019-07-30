package com.james.signature.service;

import com.james.signature.domain.EnterpriseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EnterpriseService {

    String getLntLat();

    EnterpriseEntity getEnterpriseInfo();

    String updateLntLat(String lntLat);

    String updateStartEndTime(String startTime, String endTime);

    String updateScope(String scope);

}
