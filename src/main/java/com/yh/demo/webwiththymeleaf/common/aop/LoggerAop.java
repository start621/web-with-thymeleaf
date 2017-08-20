package com.yh.demo.webwiththymeleaf.common.aop;

import java.lang.annotation.*;

/**
 * web-with-thymeleaf-LoggerAop
 * aop 插入日志
 *
 * @author yh
 * @since 0.0.1 2017-08-20 17:09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerAop {

    public String description();
}
