package com.yh.demo.webwiththymeleaf.controller;

import com.yh.demo.webwiththymeleaf.domain.User;
import com.yh.demo.webwiththymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * web-with-thymeleaf-ThymeleafTestController
 * Thymeleaf 测试demo
 *
 * @author yh
 * @since 0.0.1 2017-08-20 22:46
 */

@RestController
public class ThymeleafTestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/thymeleaf")
    public ModelAndView index() {
        List<User> users = new ArrayList<>();
        users =  userService.getUserLists();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
