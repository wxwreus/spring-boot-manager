package com.cybertech.common.exception;

import com.cybertech.common.result.Result;
import com.cybertech.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * \* @created with IntelliJ IDEA.
 * \* @date: 2017/12/27
 * \* @time: 上午10:04
 * \* @to change this template use File | Settings | File Templates.
 * \* @description:系统异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        logger.debug("【系统异常】{}",e);
        return ResultUtil.error(1000,e.getMessage());
    }
}