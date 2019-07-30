package com.james.signature.controller;

import com.james.signature.util.StatusJsonForAndroid;
import com.james.signature.model.login.LoginInfo;
import com.james.signature.model.login.LoginRequestInfo;
import com.james.signature.repository.UserRepository;
import com.james.signature.service.AdminUserService;
import com.james.signature.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录", response = LoginInfo.class)
    private StatusJsonForAndroid userLogin(@RequestBody LoginRequestInfo loginRequestInfo) {
       LoginInfo loginInfo =  userService.userLogin(loginRequestInfo.getUserName(), loginRequestInfo.getUserPwd());
        return new StatusJsonForAndroid(loginInfo);
    }

    @PostMapping(value = "/admin/login")
    @ApiOperation(value = "管理员登录", response = LoginInfo.class)
    private StatusJsonForAndroid adminLogin(@RequestBody LoginRequestInfo loginRequestInfo) {
        LoginInfo loginInfo =  adminUserService.AdminLogin(loginRequestInfo.getUserName(), loginRequestInfo.getUserPwd());
        return new StatusJsonForAndroid(loginInfo);
    }
}
