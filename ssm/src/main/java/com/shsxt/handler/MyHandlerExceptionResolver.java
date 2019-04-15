package com.shsxt.handler;

import com.shsxt.base.ParamException;
import com.shsxt.po.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xlf on 2019/4/15.
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object target, Exception ex) {
        System.out.println("MyHandlerExceptionResolver ... ");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");// 设置默认错误视图
        mv.addObject("ex", ex.getMessage());// 设置默认错误信息

        // 针对指定异常做特殊处理
        if(ex instanceof ParamException){
            ParamException e = (ParamException) ex;
            mv.setViewName("params_error");
            mv.addObject("ex", e.getMessage());
            //TODO ....自己业务代码
        }

        return mv;
    }

    public static void main(String[] args) {
        String a = "hello";
        System.out.println(a instanceof String);

        User user = new User();
        System.out.println(user instanceof User);


    }
}
