package com.james.signature.service;

import com.james.signature.model.task.TaskCheckInfo;
import com.james.signature.model.task.TaskCreateInfo;
import com.james.signature.model.task.TaskInfo;
import com.james.signature.model.task.TaskScheduleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskInfo> getAllTaskInfo();

    List<TaskScheduleInfo> getScheduleByWorkerIdWhereIsNotComplete(Integer workerId);

    List<TaskScheduleInfo> getSubordinateScheduleBySupId(Integer supId);

    boolean updateTaskCondition(TaskCheckInfo taskCheckInfo);

    boolean createTask(TaskCreateInfo taskCreateInfo);

}
