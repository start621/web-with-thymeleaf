package com.yh.demo.webwiththymeleaf.controller;

import com.yh.demo.webwiththymeleaf.common.aop.LoggerAop;
import com.yh.demo.webwiththymeleaf.domain.User;
import com.yh.demo.webwiththymeleaf.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * web-with-thymeleaf-UserController
 * 用户管理controller
 *
 * @author yh
 * @since 0.0.1 2017-08-20 17:09
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/userManagement/users", method = RequestMethod.GET)
    @LoggerAop(description = "get user lists")
    @ApiOperation(value = "获取所有用户")
    public List<User> getUsers() {
        log.info("test");
        return userService.getUserLists();
    }

}
