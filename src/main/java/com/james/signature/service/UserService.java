package com.james.signature.service;

import com.james.signature.domain.UserEntity;
import com.james.signature.model.login.LoginInfo;

import java.util.List;

public interface UserService {

    LoginInfo userLogin(String userName, String userPwd);

    List<UserEntity> getAllUser();

    List<UserEntity> getAllUserByWorkerId(Integer id);
}
