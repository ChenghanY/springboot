package com.james.signature.service.impl;

import com.james.signature.domain.UserEntity;
import com.james.signature.model.login.LoginInfo;
import com.james.signature.repository.UserRepository;
import com.james.signature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    /**
     * 使用工具类ObjectUtils检测返回的Entity是否为空
     * @param userName
     * @param userPwd
     * @return
     */
    @Override
    public LoginInfo userLogin(String userName, String userPwd) {
       boolean isNotExist =  ObjectUtils.isEmpty(userRepository.findByUserName(userName));
       boolean isCorrect;
       UserEntity userEntity;
        if (isNotExist) {
            return new LoginInfo(0, "用户名不存在，请联系管理员开通",-1);
        } else {
            userEntity = userRepository.findByUserName(userName);
            isCorrect = (userEntity.getUserPwd().equals(userPwd));
            if (isCorrect) {
                return new LoginInfo(1, "校验账号密码通过",userEntity.getWorkerId());
            } else {
                return new LoginInfo(0, "密码错误",-1);
            }
        }
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<UserEntity> getAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities;
    }

    /**
     * 根据员工Id获取用户信息
     * @param id
     * @return
     */
    @Override
    public List<UserEntity> getAllUserByWorkerId(Integer id) {
        if( id == null) {
            return getAllUser();
        } else {
            List<UserEntity> userEntities = userRepository.findAllByWorkerId(id);
            return  userEntities;
        }
    }

}

