package com.james.signature.service.impl;

import com.james.signature.domain.TaskEntity;
import com.james.signature.domain.WorkerTaskRelaEntity;
import com.james.signature.model.task.TaskCheckInfo;
import com.james.signature.model.task.TaskCreateInfo;
import com.james.signature.model.task.TaskInfo;
import com.james.signature.model.task.TaskScheduleInfo;
import com.james.signature.model.worker.Subordinate;
import com.james.signature.repository.TaskRepository;
import com.james.signature.repository.WorkerSuperiorRelaRepository;
import com.james.signature.repository.WorkerTaskRelaRepository;
import com.james.signature.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    WorkerTaskRelaRepository workerTaskRelaRepository;

    @Autowired
    WorkerSuperiorRelaRepository workerSuperiorRelaRepository;

    @Override
    public List<TaskInfo> getAllTaskInfo() {
        List<WorkerTaskRelaEntity> workerTaskRelaEntities = workerTaskRelaRepository.findAll();
        List<TaskInfo> taskInfoList = new ArrayList<>();
        for (WorkerTaskRelaEntity w : workerTaskRelaEntities) {
            Optional<TaskEntity> task = taskRepository.findById(w.getTaskId());
            if(task.isPresent()) {
                taskInfoList.add(new TaskInfo(w.getWorkerId(),
                        task.get().getTaskName(), task.get().getTaskBuildTime(),
                        task.get().getTaskDescription(), w.getIsComplete(),
                        task.get().getExpectedCompleteTime()));
            }
        }
        return  taskInfoList;
    }

    @Override
    public List<TaskScheduleInfo> getScheduleByWorkerIdWhereIsNotComplete(Integer workerId) {

        // 拿到所有未完成的任务进度记录
        List<WorkerTaskRelaEntity> workerTaskRelaEntities = workerTaskRelaRepository.findAllByWorkerId(workerId)
                .stream().filter(p ->p.getIsComplete() == 0).collect(Collectors.toList());
        // list.stream可以返回空值
        List<TaskScheduleInfo> scheduleInfos = workerTaskRelaEntities.stream().map(p -> {
            Integer t = p.getTaskId();
            TaskEntity taskEntity = taskRepository.findById(t).get();
            return new TaskScheduleInfo(taskEntity.getTaskName(), taskEntity.getTaskBuildTime(),
                    taskEntity.getExpectedCompleteTime(), p.getConditionDescription(), p.getTaskId());
        }).collect(Collectors.toList());

        return scheduleInfos;
    }

    /**
     * 获取直接下级任务信息
     * @param supId
     * @return
     */
    @Override
    public List<TaskScheduleInfo> getSubordinateScheduleBySupId(Integer supId) {
        List<Integer> subordinateIds =
                workerSuperiorRelaRepository.findAllBySuperiorId(supId).stream().filter(p -> p.getRelaLevel() == 1)
                .map(p -> p.getWorkerId()).collect(Collectors.toList());

        List<WorkerTaskRelaEntity> workerTaskRelaEntities = workerTaskRelaRepository.findAllByWorkerIdIn(subordinateIds);
        List<TaskScheduleInfo> scheduleInfos = workerTaskRelaEntities.stream().map(p -> {
            Integer t = p.getTaskId();
            TaskEntity taskEntity = taskRepository.findById(t).get();
            return new TaskScheduleInfo(taskEntity.getTaskName(), taskEntity.getTaskBuildTime(),
                    taskEntity.getExpectedCompleteTime(), p.getConditionDescription(), p.getTaskId());
        }).collect(Collectors.toList());

        return scheduleInfos;
    }

    /**
     * 更新（审批）任务状态
     * @param taskCheckInfo
     * @return
     */
    @Override
    public boolean updateTaskCondition(TaskCheckInfo taskCheckInfo) {
        workerTaskRelaRepository.updateWorkerTaskRela(taskCheckInfo.getTaskId(), taskCheckInfo.getWorkerId(),
                taskCheckInfo.getIsComplete(), taskCheckInfo.getConditionDescription());
        return true;
    }

    /**
     * 上级下发任务
     * @param taskCreateInfo
     * @return
     */
    @Override
    public boolean createTask(TaskCreateInfo taskCreateInfo) {
//        taskRepository.createTask(taskCreateInfo.getTaskName(), taskCreateInfo.getTaskBuildTime(),
//                taskCreateInfo.getTaskDescription(), taskCreateInfo.getExpectedCompleteTime());

        TaskEntity t = new TaskEntity(taskCreateInfo.getTaskName(), taskCreateInfo.getTaskBuildTime(),
                taskCreateInfo.getTaskDescription(), taskCreateInfo.getExpectedCompleteTime());
        // 新建任务
        taskRepository.save(t);

        List<Subordinate> subordinateList = taskCreateInfo.getSubordinateList();
        for (Subordinate s: subordinateList){
            WorkerTaskRelaEntity wt = new WorkerTaskRelaEntity( 0, s.getWorkerShouldDo() ,s.getWorkerId(), t.getId());
            workerTaskRelaRepository.saveAndFlush(wt);
        }

        taskRepository.flush();
        // workerTaskRelaRepository.flush();

        return true;
    }


}
