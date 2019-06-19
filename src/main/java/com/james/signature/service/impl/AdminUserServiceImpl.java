package com.james.signature.service.impl;


import com.james.signature.domain.AdminUserEntity;
import com.james.signature.model.login.LoginInfo;
import com.james.signature.repository.AdminUserRepository;
import com.james.signature.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public LoginInfo AdminLogin(String userName, String userPwd) {
        boolean isNotExist =  ObjectUtils.isEmpty(adminUserRepository.findByUserName(userName));
        boolean isCorrect;
        AdminUserEntity adminuserEntity;
        if (isNotExist) {
            return new LoginInfo(0, "用户名不存在，请联系管理员开通");
        } else {
            adminuserEntity = adminUserRepository.findByUserName(userName);
            isCorrect = (adminuserEntity.getUserPwd().equals(userPwd));
            if (isCorrect) {
                return new LoginInfo(1, "校验账号密码通过");
            } else {
                return new LoginInfo(0, "密码错误");
            }
        }
    }
}
