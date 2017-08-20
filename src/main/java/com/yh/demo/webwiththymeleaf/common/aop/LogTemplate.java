package com.yh.demo.webwiththymeleaf.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * web-with-thymeleaf-LogTemplate
 * 在方法入口，出口，异常处理增加日志模板
 *
 * @author yh
 * @since 0.0.1 2017-08-20 17:26
 */
@Aspect
@Service
@Slf4j
public class LogTemplate {

    @Before("within(com.yh.demo.webwiththymeleaf.*) && @annotation(loggerAop)")
    public void addLogBeforeMethod(JoinPoint joinPoint, LoggerAop loggerAop) {
        log.info("start " + loggerAop.description());
        log.info(joinPoint.getSignature().toString());
        log.info(parseParameters(joinPoint.getArgs()));
    }

    @AfterReturning("within(com.yh.demo.webwiththymeleaf.*) && @annotation(loggerAop)")
    public void addLogAfterMethod(JoinPoint joinPoint, LoggerAop loggerAop) {
        log.info("end" + loggerAop.description());
    }

    @AfterThrowing(value = "within(com.yh.demo.webwiththymeleaf.*) && @annotation(loggerAop)", throwing = "e")
    public void addLogAfterException(JoinPoint joinPoint, LoggerAop loggerAop, Exception e) {
        log.error("exec" + loggerAop.description() + "exception");
        log.error("stack trace: [%s]", ExceptionUtils.getStackTrace(e));
    }


    private String parseParameters (Object[] parameters) {
        if (null == parameters || parameters.length <= 0) {
            return "";
        }
        StringBuffer param = new StringBuffer("parameters:[{}] ");
        for (Object obj : parameters) {
            param.append(ToStringBuilder.reflectionToString(obj)).append("  ");
        }
        return param.toString();
    }
}
