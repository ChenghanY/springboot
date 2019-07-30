package com.james.signature.service.impl;


import com.james.signature.domain.SuperiorEntity;
import com.james.signature.domain.UserEntity;
import com.james.signature.domain.WorkerEntity;
import com.james.signature.domain.WorkerSuperiorRelaEntity;
import com.james.signature.model.worker.InitWorkerInfo;
import com.james.signature.model.worker.WorkerInfo;
import com.james.signature.repository.SuperiorRepository;
import com.james.signature.repository.UserRepository;
import com.james.signature.repository.WorkerRepository;
import com.james.signature.repository.WorkerSuperiorRelaRepository;
import com.james.signature.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkerSuperiorRelaRepository workerSuperiorRelaRepository;

    @Autowired
    SuperiorRepository superiorRepository;

    @Override
    public List<WorkerInfo> getWorkerInfo(Integer id) {

        List<WorkerInfo> workerInfoes = new ArrayList<>();
        if (id == null) {
            List<WorkerEntity> workerEntities = workerRepository.findAll();
            workerInfoes = workerEntities.stream()
                    .map(p -> new WorkerInfo( p.getId(), p.getName(),  p.getTel(), p.getEmail(), p.getAge(), p.getHireDate(), p.getIsActive()))
                    .collect(Collectors.toList());
        } else {
            WorkerEntity w = workerRepository.findById(id).get();
            WorkerInfo workerInfo = new WorkerInfo(w.getId(), w.getName(), w.getTel(), w.getEmail(), w.getAge(), w.getHireDate(), w.getIsActive());
            workerInfoes.add(workerInfo);

        }

        return workerInfoes;
    }

    @Override
    public InitWorkerInfo createWorker(InitWorkerInfo info) {

        // 员工信息
        WorkerEntity workerEntity = info.getWorkerEntity();
        WorkerEntity resultWorker = workerRepository.saveAndFlush(workerEntity);

        //上下级信息
        WorkerSuperiorRelaEntity workerSuperiorRelaEntity = info.getWorkerSuperiorRelaEntity();
        WorkerSuperiorRelaEntity resultWorkerSupRale = workerSuperiorRelaRepository.saveAndFlush(workerSuperiorRelaEntity);

        // 用户信息
        UserEntity userEntity = info.getUserEntity();
        UserEntity resultUser = userRepository.saveAndFlush(userEntity);

        if ( info.getIsSuperior() == 1) {
            // 个人的管理信息
            SuperiorEntity superiorEntity = info.getSuperiorEntity();
            SuperiorEntity resultSuper = superiorRepository.saveAndFlush(superiorEntity);
            return new InitWorkerInfo(info.getIsSuperior(), resultWorker, resultUser, resultSuper, resultWorkerSupRale);
        } else {
            return new InitWorkerInfo(info.getIsSuperior(), resultWorker, resultUser, resultWorkerSupRale);
        }

    }

    @Override
    public String deleteWorker(Integer workerId) {
        StringBuffer s = new StringBuffer();
        Optional<SuperiorEntity> superiorOptional = superiorRepository.findById(workerId);
        if(superiorOptional.isPresent()== false) {
            workerRepository.deleteById(workerId);
            s.append("删除员工主表记录成功;");

            userRepository.deleteByWorkerId(workerId);
            s.append("删除登录用户信息成功;");

            workerSuperiorRelaRepository.deleteByWorkerId(workerId);
            s.append("删除上下级关系成功;");

        } else {
            superiorRepository.deleteById(workerId);
            s.append("删除上级表记录成功;");

            workerRepository.deleteById(workerId);
            s.append("删除员工主表成功;");

            userRepository.deleteByWorkerId(workerId);
            s.append("删除登录用户信息成功;");

            // 找到所删除成员的所有直接下属的关系Id
            List<Integer> relaId  =  workerSuperiorRelaRepository.findAllBySuperiorId(workerId).stream().filter(p -> p.getRelaLevel() == 1).map(p1 -> p1.getId()).collect(Collectors.toList());

            // 获取新的上级Id
            Integer newSupId;
            Optional<WorkerSuperiorRelaEntity> o = workerSuperiorRelaRepository.findAllByWorkerId(workerId).stream().filter(p -> p.getRelaLevel() == 1).findFirst();
            if (o.isPresent()) {
                newSupId = o.get().getSuperiorId();
            } else {
                //管理员的Id
                newSupId = 18;
            }

            // 更新旧下属的上级Id
            workerSuperiorRelaRepository.updateRelaBySuperiorId(relaId, newSupId);
            s.append("原下属成员已变更上级;");

            // 删除自己的上属依赖
            workerSuperiorRelaRepository.deleteByWorkerId(workerId);
            s.append("删除上下级关系成功;");
        }

       return s.toString();
    }


}



