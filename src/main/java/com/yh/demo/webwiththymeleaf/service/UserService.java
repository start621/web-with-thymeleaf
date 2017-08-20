package com.yh.demo.webwiththymeleaf.service;

import com.yh.demo.webwiththymeleaf.domain.User;

import java.util.List;

/**
 * web-with-thymeleaf-UserService
 * 用户管理对外服务
 *
 * @author yh
 * @since 0.0.1 2017-08-20 11:39
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param user 用户实例
     */
    void createUser(User user);

    /**
     * 根据name删除一个用户高
     * @param name 用户名
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 返回当前所有用户
     * @return
     */
    List<User> getUserLists();
}
