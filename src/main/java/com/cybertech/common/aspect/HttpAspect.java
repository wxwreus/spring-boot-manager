package com.cybertech.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * \* @created with IntelliJ IDEA.
 * \* @date: 2017/12/27
 * \* @time: 上午10:14
 * \* @to change this template use File | Settings | File Templates.
 * \* @description:系统所有http请求拦截日志
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.cybertech.web.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttributes.getRequest();
        logger.debug("url={}", httpServletRequest.getRequestURI());
        logger.debug("method={}", httpServletRequest.getMethod());
        logger.debug("ip={}", httpServletRequest.getRemoteAddr());
        logger.debug("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.debug("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void after() {

    }
}
