package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.model.login.LoginInfo;
import com.james.signature.model.login.LoginRequestInfo;
import com.james.signature.service.AdminUserService;
import com.james.signature.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录服务")
@RequestMapping(value = Constants.URI_Login)
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserService adminUserService;


    @PostMapping
    @ApiOperation(value = "用户登录", response = LoginInfo.class)
    private StatusJson userLogin(@RequestBody LoginRequestInfo loginRequestInfo) {
       LoginInfo loginInfo =  userService.userLogin(loginRequestInfo.getUserName(), loginRequestInfo.getUserPwd());
        return new StatusJson(loginInfo);
    }

    @PostMapping(value = "/admin")
    @ApiOperation(value = "管理员登录", response = LoginInfo.class)
    private StatusJson adminLogin(@RequestBody LoginRequestInfo loginRequestInfo) {
        LoginInfo loginInfo =  adminUserService.AdminLogin(loginRequestInfo.getUserName(), loginRequestInfo.getUserPwd());
        return new StatusJson(loginInfo);
    }
}
