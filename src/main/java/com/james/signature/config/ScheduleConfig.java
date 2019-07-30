package com.james.signature.config;

import com.james.signature.domain.SignRecordEntity;
import com.james.signature.domain.TestEntity;
import com.james.signature.repository.SignRecordRepository;
import com.james.signature.repository.TestRepository;
import com.james.signature.repository.WorkerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class ScheduleConfig {

    @Autowired
    SignRecordRepository signRecordRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    TestRepository testRepository;

    /**
     * 每日新增待签到的记录
     */
    @Scheduled(cron = "0 10 0 ? * *")
    public void insertSignRecord() {

        /*获取时间的标准方式
         LocalDateTime localDateTime = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));
         LocalDateTime localDateTimeNow = LocalDateTime.now();
        */


        /* LocalDateTime 和 util.Date的转换
         Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
         Date localDateTime = Date.from(instant);
        */


        // 将当前时间转换成19XXXXXX格式,用于生成主键
        String localDate = LocalDate.now().toString().replace("-", "").substring(2);
        Integer isOntime = 0;

        // 生成待签到记录
        LocalDateTime localDateTime = LocalDateTime.now();
        List<SignRecordEntity> signRecordEntities = workerRepository.findAll().stream().map(p -> {
            Integer recordId = Integer.valueOf(localDate + p.getId());
            return new SignRecordEntity(recordId, isOntime, p.getId(), localDateTime);
        }).collect(Collectors.toList());

        // 数据库新增待操作记录
        signRecordRepository.saveAll(signRecordEntities);
        signRecordRepository.flush();

        System.out.println(LocalDate.now().toString() + "新增signRecord的定时任务已经执行完成");

    }

    /**
     * 每日处理未签到记录，记录为旷工
     */
    @Scheduled(cron = "0 5 0 ? * *")
    public void updateSignRecord() {

        List<SignRecordEntity> signRecordEntities = signRecordRepository.findAllByRecordCreateTimeBetween(LocalDateTime.now().minusDays(1), LocalDateTime.now()).stream()
                .filter(p -> StringUtils.isAllBlank(p.getSignEndTime())).map(p1 -> {
                    if (StringUtils.isBlank(p1.getSignStartTime())) {
                        p1.setIsOntime(0);
                        p1.setReason("全天无签到记录，记旷工一天");
                    } else {
                        p1.setIsOntime(0);
                        p1.setReason("下午无签到记录，记旷工半天");
                    }
                    return p1;
                }).collect(Collectors.toList());

        if (signRecordEntities.size() == 0) {
            System.out.println(LocalDateTime.now().minusDays(1).toString() + "昨日全员下午均已签到");
            return;
        }

        signRecordRepository.saveAll(signRecordEntities);
        signRecordRepository.flush();

        System.out.println("更新signRecord的任务已经执行完成");
    }

    /**
     * 测试MySQL的字段映射
     */
    // @Scheduled(cron = "0 26 10 ? * *")
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();

        testRepository.saveAndFlush(new TestEntity(12345, 0, 11, localDateTime));

    }
}
