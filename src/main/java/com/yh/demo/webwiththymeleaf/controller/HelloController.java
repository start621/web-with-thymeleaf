package com.yh.demo.webwiththymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * web-with-thymeleaf-HelloController
 *
 * hello world 验证
 * @author yh
 * @since 0.0.1 2017-08-20 10:07
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world!";
    }

}
