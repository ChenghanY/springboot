package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.model.task.TaskCheckInfo;
import com.james.signature.model.task.TaskCreateInfo;
import com.james.signature.model.task.TaskInfo;
import com.james.signature.model.task.TaskScheduleInfo;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "任务服务")
@RequestMapping(value = Constants.URI_TASK)
public class TaskController {

    @Autowired
    TaskService taskService;

    @ApiOperation(value = "获取所有用户任务情况", response = TaskInfo.class, responseContainer = "List")
    @GetMapping
    public TaskInfo[] getAllTaskInfo() {
        List<TaskInfo> taskInfoList = taskService.getAllTaskInfo();
        return taskInfoList.toArray(new TaskInfo[taskInfoList.size()]);
    }

    @ApiOperation(value = "根据员工Id获取待完成任务情况", responseContainer = "List")
    @PostMapping(value = "/notComplete")
    public TaskScheduleInfo[] getTaskScheduleInfo(@RequestBody WorkerId workerIdObject) {
        List<TaskScheduleInfo> taskScheduleInfos = taskService.getScheduleByWorkerIdWhereIsNotComplete(workerIdObject.getWorkerId());
        return taskScheduleInfos.toArray(new TaskScheduleInfo[taskScheduleInfos.size()]);
    }

    @ApiOperation(value = "获取下属任务进度", responseContainer = "List")
    @PostMapping(value = "/subordinate")
    public TaskScheduleInfo[] getSubordinateTaskInfo(@RequestBody WorkerId workerIdObject) {
        List<TaskScheduleInfo> taskScheduleInfos = taskService.getSubordinateScheduleBySupId(workerIdObject.getWorkerId());
        return taskScheduleInfos.toArray(new TaskScheduleInfo[taskScheduleInfos.size()]);
    }

    @ApiOperation(value = "员工提交任务", responseContainer = "List")
    @PutMapping(value = "/submit")
    public StatusJson summitTaskInfo(@RequestBody TaskCheckInfo taskCheckInfo) {
        taskService.updateTaskCondition(taskCheckInfo);
        return new StatusJson("任务提交成功");
    }

    @ApiOperation(value = "上级审批任务", responseContainer = "List")
    @PutMapping(value = "/check")
    public StatusJson checkTaskInfo(@RequestBody TaskCheckInfo taskCheckInfo) {
        taskService.updateTaskCondition(taskCheckInfo);
        return new StatusJson("任务审批成功");
    }


    @ApiOperation(value = "上级下发任务", responseContainer = "List")
    @PostMapping(value = "/create")
    public StatusJson createTaskInfo(@RequestBody TaskCreateInfo taskCreateInfo) {
        taskService.createTask(taskCreateInfo);
        return new StatusJson("任务下发成功");
    }

}
