package com.dony15.exception;

import com.alibaba.fastjson.JSON;
import com.dony15.utils.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一的错误处理页面
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
  
    @Override  
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        logger.error(ex.getMessage(),ex);
        //ajax 请求
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { //如果是ajax请求响应头会有x-requested-with
            AjaxResponse ajaxResponse = new AjaxResponse();
            ajaxResponse.setThrowable(ex);
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
            out.print(JSON.toJSONString(ajaxResponse));
            out.flush();

            return null;
        }else {//非ajax请求跳转登陆页

            ModelAndView mv = new ModelAndView();

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if ("debug".equals(cookies[i].getName())) {
                        StackTraceElement[] stackTraces = ex.getStackTrace();

                        StringBuilder stackTraceStr = new StringBuilder();
                        stackTraceStr.append(ex.toString())
                                .append("<br>");
                        for (int j = 0; j < stackTraces.length; j++) {
                            stackTraceStr.append(stackTraces[j].toString())
                                    .append("<br>");
                        }

                        mv.getModel().put("stackTraces", stackTraceStr);
                    }
                }
            }

            mv.setViewName("error.html");

            return mv;
        }
    }  
}