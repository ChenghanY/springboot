package com.james.signature.service;

import com.james.signature.model.login.LoginInfo;
import org.springframework.stereotype.Service;

@Service
public interface AdminUserService {
    LoginInfo AdminLogin(String userName, String userPwd);
}
