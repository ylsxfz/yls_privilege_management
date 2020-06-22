package com.authority.manager.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yls
 * @Date 2020/3/30 14:39
 * @Description 统一封装业务的异常处理
 * @Version 1.0
 **/
//ControllerAdvice：该注解是定义统一的异常处理，
//basePackages：定义扫描哪些包
@ControllerAdvice(basePackages = "com.spring.boot")
public class GlobalExceptionHandler {
    //ExceptionHandler 用来定义函数针对的异常类型，可以传入多个需要捕获的异常。
    @ExceptionHandler(BusinessException.class)
    //如果返回的json数据或者其他对象，添加该注解
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }

}
