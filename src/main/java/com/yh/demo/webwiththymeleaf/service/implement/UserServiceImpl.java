package com.yh.demo.webwiththymeleaf.service.implement;

import com.yh.demo.webwiththymeleaf.domain.User;
import com.yh.demo.webwiththymeleaf.repository.UserRepo;
import com.yh.demo.webwiththymeleaf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * web-with-thymeleaf-UserServiceImpl
 * 用户管理接口实现
 *
 * @author yh
 * @since 0.0.1 2017-08-20 16:59
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void createUser (User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Integer getAllUsers() {
        return null;
    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public List<User> getUserLists() {
        return userRepo.findAll();
    }
}
