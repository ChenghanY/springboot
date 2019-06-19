package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.domain.UserEntity;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "系统用户服务")
@RequestMapping(value = Constants.URI_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取所有用户信息")
    private UserEntity[] getAllUser() {
        List<UserEntity> userEntities = userService.getAllUser();
        return userEntities.toArray(new UserEntity[userEntities.size()]);
    }

    @PostMapping
    @ApiOperation(value = "根据员工Id获取用户信息")
    private UserEntity[] getAllUserByWorkerId(@RequestBody WorkerId workerIdObject) {
        List<UserEntity> userEntities = userService.getAllUserByWorkerId(workerIdObject.getWorkerId());
        return userEntities.toArray(new UserEntity[userEntities.size()]);
    }


}




