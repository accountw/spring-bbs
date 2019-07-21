package com.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Interceptor implements HandlerInterceptor {



    private static final Log logger = LogFactory.getLog(Interceptor.class);

    /*
     * preHandle方法
     *
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("【-MyInterceptor1,在请求处理之前进行调用(controller方法调用之前)-】");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("【-MyInterceptor1,请求处理之后进行调用，但是在视图被渲染之前(controller方法调用之后)-】");
        if(response.getStatus()==500){
            modelAndView.setViewName("404");
            /*
             * setViewName(String viewName);
             * 为此ModelAndView设置视图名称，由DispatcherServlet通过ViewResolver解析。 将覆盖任何预先存在的视图名称或视图。
             */
        }
        if(response.getStatus()==404){
            modelAndView.setViewName("404");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("【-MyInterceptor1,在整个请求结束之后被调用,也就是在DispatcherServlet渲染了对应的视图之后执行(主要用于资源清理工作)-】");
    }

}