package com.shsxt.base;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xlf on 2019/4/15.
 */
public class BaseController {

    @ExceptionHandler
    public String exc(HttpServletRequest request,
                      HttpServletResponse response,
                      Exception ex){

        System.out.println("BaseController exc...");

        request.setAttribute("ex", ex.getMessage());

        // 针对指定异常做特殊处理
        if(ex instanceof ParamException){
            ParamException e = (ParamException) ex;
            request.setAttribute("ex", e.getMessage());
            //TODO ....自己业务代码
            return "params_error";
        }

        return "error";// 默认错误视图
    }
}
