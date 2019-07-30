package com.james.signature.service;

import com.james.signature.domain.SignRecordEntity;
import com.james.signature.model.SignRecordInfo;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Service
public interface SignService {

    List<SignRecordInfo> getAllSignInfo();

    List<SignRecordInfo> getAllByWorkerId(Integer workerId);

    Integer signInMorning(SignRecordEntity signRecordEntity);

    Integer signInAfternoon(SignRecordEntity signRecordEntity);

    boolean exportAllSignRecord(ServletOutputStream stream);
}
