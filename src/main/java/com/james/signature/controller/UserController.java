package com.james.signature.controller;

import com.james.signature.domain.UserEntity;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping(value = "/user")
//    @ApiImplicitParam(name = "id", value = "用户Id")
//    private String getUser(@RequestParam int id) {
//
//        return  "该接口需要根据需求完善";
//
//    }

    @GetMapping(value = "/user/list")
    @ApiOperation(value = "获取所有用户信息")
    private UserEntity[] getAllUser() {
        List<UserEntity> userEntities = userService.getAllUser();
        return userEntities.toArray(new UserEntity[userEntities.size()]);
    }

    @PostMapping(value = "/user")
    @ApiOperation(value = "根据员工Id获取用户信息")
    private UserEntity[] getAllUserByWorkerId(@RequestBody WorkerId workerIdObject) {
        List<UserEntity> userEntities = userService.getAllUserByWorkerId(workerIdObject.getWorkerId());
        return userEntities.toArray(new UserEntity[userEntities.size()]);
    }


}




